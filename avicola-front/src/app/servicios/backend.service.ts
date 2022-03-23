import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {catchError, map, throwError} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class BackendService {

  constructor( private  _http: HttpClient) { }

  post(ruta: string, data: any){
    return this._http.post(environment.baseUrl + ruta,data, {
      headers: {Authorization: 'Bearer '+this.obtenerToken()}

    })
      .pipe(
        map((res: any) => {
          if (!res) {
            throw new Error('Error al conectarse con el servidor');
          }
          return res;

        }),
        catchError((err) => {
          return throwError(err);
        }),
      );
  }
  login( data: any){
    return this._http.post(environment.baseUrl + '/logeo',data)
      .pipe(
        map((res: any) => {
          if (!res) {
            throw new Error('Error al conectarse con el servidor');
          }
          return res;

        }),
        catchError((err) => {
          return throwError(err);
        }),
      );
  }

  get(ruta: string){
    return this._http.get(environment.baseUrl + ruta, {
      headers: {Authorization: 'Bearer '+this.obtenerToken()}

    })
      .pipe(
        map((res: any) => {
          if (!res) {
            throw new Error('Error al conectarse con el servidor');
          }
          return res;

        }),
        catchError((err) => {
          return throwError(err);
        }),
      );
  }

  obtenerToken(){

    return localStorage.getItem('token') + ''
  }
}
