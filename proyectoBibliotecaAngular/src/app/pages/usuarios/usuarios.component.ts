
import { Component, OnInit } from '@angular/core';
import { UsuarioService } from 'src/app/servicios/usuario.service';
import { Usuario } from '../../models/Usuario';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit {

  registrado:boolean = false;

  constructor(
    private usuariosService: UsuarioService, private router: Router) {}

  ngOnInit(): void {
  }

  datos = new FormGroup({
    username: new FormControl(''),
    password: new FormControl(''),
    name: new FormControl(''),
    lastname: new FormControl(''),
    address: new FormControl(''),
    tel: new FormControl('')
  });

  onSubmit() {
    const user = new Usuario(

    this.datos.value['username'] as string,
    this.datos.value['password'] as string,
    this.datos.value['name'] as string,
    this.datos.value['lastname'] as string,
    this.datos.value['address'] as string,
    this.datos.value['tel'] as string);

    if(!this.datos.value['username'] || !this.datos.value['password'] || !this.datos.value['name'] || !this.datos.value['lastname'] || !this.datos.value['address'] || !this.datos.value['tel']){
      alert("Faltan datos");
    }

    return this.usuariosService.agregarUsuario(user).subscribe(user => {
      console.log(user);
      this.registrado = true;
      if(!this.registrado){
        alert("Intenta de nuevo");
      }else{
        this.router.navigate(['/login']);
        return alert("Registro exitoso");
      }
    })
  }

}
