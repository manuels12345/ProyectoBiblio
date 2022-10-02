import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';


import { PrincipalComponent } from './pages/principal/principal.component';
import { PrestamosComponent } from './pages/prestamos/prestamos.component';
import { DevolucionesComponent } from './pages/devoluciones/devoluciones.component';
import { UsuariosComponent } from './pages/usuarios/usuarios.component';
import { LibrosComponent } from './pages/libros/libros.component';
<<<<<<< HEAD
<<<<<<< HEAD
import { LoginComponent } from './pages/login/login.component';
=======
import { NuevoUsuarioComponent } from './pages/nuevo-usuario/nuevo-usuario.component';
>>>>>>> 27d1615a7005b1bcc802b1a2bc5f33d4d5f3ce86
=======
>>>>>>> origin

const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'inicio'},
  {path: 'principal', component:PrincipalComponent },
  {path:'prestamos', component:PrestamosComponent},
  {path:'login', component:LoginComponent},
  {path: 'devoluciones',component:DevolucionesComponent},
  {path:'usuarios', component:UsuariosComponent},
<<<<<<< HEAD
  {path:'libros', component:LibrosComponent},
  {path:'nuevousuario', component:NuevoUsuarioComponent}
=======
  {path:'libros', component:LibrosComponent}
>>>>>>> origin


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
