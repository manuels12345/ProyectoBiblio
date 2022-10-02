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
    this.usuariosService.cargarUsuario(this.login.value.username as string).subscribe(user=>{
      
      if(user == null){
        alert("usuario no encontrado");
      }else{
      return console.log(user);
      }
    })

    // if(!this.login.value.username || !this.login.value.password){
    //   alert("Faltan datos");
    // }else{
    //   this.usuariosService.cargarUsuario(this.login.value.username as string).subscribe(user =>{
    //     if(user.id == null){
    //       alert("Usuario no encontrado");
    //       return this.router.navigate(['/usuarios']);
    //     }else{
    //       alert("Bienvenido " + user.username);
    //       return this.router.navigate(['/libros']); 
    //     }
    //   });
    //}
  }
}
