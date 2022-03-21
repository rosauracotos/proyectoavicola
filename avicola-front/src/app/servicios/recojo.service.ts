import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {catchError, map, throwError} from "rxjs";
import {ParteCabeceraVM} from "../view-models/ParteCabeceraVM";

@Injectable({
  providedIn: 'root'
})
export class RecojoService {

  constructor( private  _http: HttpClient) { }

  guardarRegistro(registro: ParteCabeceraVM){
    return this._http.post(environment.baseUrl + '/recojo/guardar', registro)
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
}
