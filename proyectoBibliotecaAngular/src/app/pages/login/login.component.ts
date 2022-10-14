import { AuthenticationRequest } from '../../models/AuthenticationRequest';
import { HttpErrorResponse, HttpResponse, HttpResponseBase } from '@angular/common/http';
import { Component, EventEmitter, OnInit, Output} from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { UsuarioService } from 'src/app/servicios/usuario.service';
import { AppComponent } from 'src/app/app.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['../usuarios/usuarios.component.css']
})
export class LoginComponent implements OnInit {
  //@Output() loginClickedEvent = new EventEmitter<any>();


  constructor(
    private usuariosService: UsuarioService, private router: Router, private app : AppComponent) {}

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
      let usuario = this.login.value.username;
      let password = this.login.value.password;
      const data = new AuthenticationRequest(usuario,password);

      this.usuariosService.loginUsuario(data).subscribe(datos=>{
        //agregar llamada de api para cargar el usuario y comprobar si existe aca abajo
        if(usuario){
          this.router.navigate(['/libros']);
          //this.loginClickedEvent.emit(datos.jwt);
          localStorage.setItem('auth_token',this.app.jwt += datos.jwt);
          
          this.app.authenticated = true;
          console.log(localStorage.getItem('auth_token'));
          return alert("Bienvenido ");
        }
      })
    }

  }

  logout() {
    localStorage.removeItem('auth_token');
  }
 
  public get logIn(): boolean {
    return (localStorage.getItem('auth_token') !== null);
  }

}
