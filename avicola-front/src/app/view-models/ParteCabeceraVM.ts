import {ParteDetalleVM} from "./ParteDetalleVM";

export interface ParteCabeceraVM {
  fecha?: Date;
  codigoAlmacen?: string;
  detalles?: ParteDetalleVM[]
}
