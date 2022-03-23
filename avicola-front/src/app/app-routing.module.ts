import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {RegistroComponent} from "./registro/registro.component";
import {LogueadoGuard} from "./guards/logueado.guard";

const routes: Routes = [
  {
    path:'login',
    component: LoginComponent
  },
  {
    path:'registro-parte',
    component: RegistroComponent,
    canActivate: [LogueadoGuard]
  },
  { path: '**', pathMatch: 'full', redirectTo: 'login'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
