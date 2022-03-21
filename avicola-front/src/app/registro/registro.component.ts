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
  columnasAMostrar: string[] = ['producto', 'cantidad'];
  almacenes:any[] = []
  productos: Producto[] = [];
  parteCabecera: ParteCabeceraVM;

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

  agregarDetalle(){
    this.detalles.push(this.detalle)
    this.dataSource.data = this.detalles;
    this.detalle = {}
  }

  guardarRegistro(){
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

