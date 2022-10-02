import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../../servicios/usuario.service';
import { Usuario } from '../../models/Usuario';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit {

  public usuario = new Usuario;

  constructor(
    private usuariosService: UsuarioService) {}

  ngOnInit(): void {
  }

  onSubmit(nombre:string, apellido:string, direccion:string, tel:string, username:string,pw:string) {
    return this.usuariosService.agregarUsuario(nombre,apellido,direccion,tel,username,pw).subscribe((data) => {
      alert(data);
    });
  }


}
