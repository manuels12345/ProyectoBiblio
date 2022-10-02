import { HttpErrorResponse, HttpResponse, HttpResponseBase } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/models/Usuario';
import { UsuarioService } from 'src/app/servicios/usuario.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['../usuarios/usuarios.component.css']
})
export class LoginComponent implements OnInit {
  constructor(
    private usuariosService: UsuarioService, private router: Router) {}

  ngOnInit(): void {
  }
  login = new FormGroup({
    username: new FormControl(''),
    password: new FormControl('')
  });


  onSubmit() {
    console.log(this.login.value.username);
    if(!this.login.value.username || !this.login.value.password){
      //No funciona esta validacion ni comparacion
      alert("Faltan datos");
    }else{
      this.usuariosService.cargarUsuario(this.login.value.username as string).subscribe(user=>{
        if(this.login.value.username = user.username){
          this.router.navigate(['/libros']);
          return alert("Bienvenido " + user.username);
        }
      })
    }

  }
}
