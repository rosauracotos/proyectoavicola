import { Component, OnInit } from '@angular/core';
import {Producto} from "../interfaces/Producto";
import {ParteDetalle} from "../interfaces/ParteDetalle";
import {MatTableDataSource} from "@angular/material/table";
import {ParteCabeceraVM} from "../view-models/ParteCabeceraVM";
import Swal from 'sweetalert2';
import {BackendService} from "../servicios/backend.service";

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {

  public dataSource:  MatTableDataSource<ParteDetalle>;
  detalles: any[] = [];
  columnasAMostrar: string[] = ['producto', 'cantidad', 'modificar', 'eliminar'];
  almacenes:any[] = []
  productos: Producto[] = [];
  parteCabecera: ParteCabeceraVM;
  indexMod = -1;
  esModificacion = false;

  detalle: ParteDetalle = {};


  constructor(
    private backendService: BackendService
  ) {
    this.parteCabecera = {
      fecha: new Date(),
      detalles: []
    }
    this.dataSource = new MatTableDataSource<ParteDetalle>();
  }

  ngOnInit(): void {

    this.listarAlmacenes();
    this.listarProductos();
  }

  eliminarDetalleProducto(productoId: string){
    this.detalles = this.detalles.filter( d => d.producto.codigo != productoId );
    this.dataSource.data = this.detalles;
  }

  modificarRegistro(detalle: any, index: number){
    this.esModificacion = true;
    this.indexMod = index;
    this.detalle = {
      cantidad: detalle.cantidad,
      producto: detalle.producto
    }

  }

  listarAlmacenes(){
    this.backendService.get('/almacen/listar')
      .subscribe((response: any) => {


        if(response != null){
          this.almacenes = response;
        }
      }, err => {
        console.log(err)
      })
  }
  cancelar(){
    this.detalle = {};
    this.esModificacion = false;
    this.indexMod = -1;
  }

  agregarDetalle(){

    if(this.detalle.producto == null){
      alert('Debe elegir un producto');
      return;
    }

    if(this.detalle.cantidad == null || this.detalle.cantidad <= 0){
      alert('Debe ingresar una cantidad válida');
      return;
    }

    if(this.esModificacion){
      if(!this.existeProductoEnDetalles(this.detalle.producto?.codigo!, this.indexMod)){
        this.detalles[this.indexMod] = this.detalle;
        this.dataSource.data = this.detalles;
        this.detalle = {}
        this.indexMod = -1;
        this.esModificacion = false;
      } else {
        alert('El producto ya ha sido agregado')
      }


    } else {
      if(!this.existeProductoEnDetalles(this.detalle.producto?.codigo!)){
        this.detalles.push(this.detalle)
        this.dataSource.data = this.detalles;
        this.detalle = {}
      } else {
        alert('El producto ya ha sido agregado')
      }

    }


  }

  existeProductoEnDetalles(codigoProducto: string, indexExcluir = -1): boolean{

    let existe = false;

    for (let i = 0; i< this.detalles.length && !existe ; i++){

      if(i != indexExcluir){
        if(this.detalles[i].producto.codigo == codigoProducto){
          existe = true;
        }
      }

    }

    return existe;
  }

  guardarRegistro(){
    this.parteCabecera.detalles = [];
    this.detalles.forEach(item => {
      this.parteCabecera.detalles?.push({
        codProducto: item.producto.codigo,
        cantidad: item.cantidad
      })
      this.detalles = [];
      this.dataSource.data = [];

    })
    console.log(this.parteCabecera)


    this.backendService.post('/recojo/guardar',this.parteCabecera)
      .subscribe(response => {
        console.log(response);
        Swal.fire({
          title: "SE GUARDO CORRECTAMENTE!",
          icon: 'success'
        })
        this.parteCabecera = {
          fecha: new Date(),
          detalles: []
        }
      }, err => {
        console.log(err)
      })



  }

  listarProductos(){
    this.backendService.get('/producto/listar')
      .subscribe((response: any) => {


        if(response != null){
          this.productos = response;
        }
      }, err => {
        console.log(err)
      })
  }






}

