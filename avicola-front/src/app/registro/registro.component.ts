import { Component, OnInit } from '@angular/core';
import {AlmacenService} from "../servicios/almacen.service";
import {ProductoService} from "../servicios/producto.service";
import {Producto} from "../interfaces/Producto";
import {ParteDetalle} from "../interfaces/ParteDetalle";
import {MatTableDataSource} from "@angular/material/table";
import {ParteCabeceraVM} from "../view-models/ParteCabeceraVM";
import {RecojoService} from "../servicios/recojo.service";

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
    private almacenService: AlmacenService,
    private recojoServicio: RecojoService,
    private productoService: ProductoService
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
    this.almacenService.listar()
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
    })
    console.log(this.parteCabecera)

    this.recojoServicio.guardarRegistro(this.parteCabecera)
      .subscribe(response => {
        console.log(response)
      }, err => {
        console.log(err)
      })

  }

  listarProductos(){
    this.productoService.listar()
      .subscribe((response: any) => {


        if(response != null){
          this.productos = response;
        }
      }, err => {
        console.log(err)
      })
  }






}

