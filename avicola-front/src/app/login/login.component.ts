import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {BackendService} from "../servicios/backend.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  login = {usuario: '', password: ''}
  constructor(private backendService: BackendService,
              private router: Router) { }

  ngOnInit(): void {
  }

  iniciarSesion(){
    this.backendService.login(this.login)
      .subscribe(response => {
        console.log(response)
        localStorage.setItem('token', response.token);
        localStorage.setItem('nombre', response.nombre);
        localStorage.setItem('usuario', response.usuario);

        this.router.navigate(['/registro-parte'])
      }, err => {
        console.log(err)
      })
  }

}
