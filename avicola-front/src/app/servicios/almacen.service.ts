import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {catchError, map, throwError} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AlmacenService {

  constructor(private _http: HttpClient) { }

  listar(){
    return this._http.get(environment.baseUrl + '/almacen/listar')

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
