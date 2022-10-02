import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';


import { PrincipalComponent } from './pages/principal/principal.component';
import { PrestamosComponent } from './pages/prestamos/prestamos.component';
import { DevolucionesComponent } from './pages/devoluciones/devoluciones.component';
import { UsuariosComponent } from './pages/usuarios/usuarios.component';
import { LibrosComponent } from './pages/libros/libros.component';
import { LoginComponent } from './pages/login/login.component';

const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'inicio'},
  {path: 'principal', component:PrincipalComponent },
  {path:'prestamos', component:PrestamosComponent},
  {path:'login', component:LoginComponent},
  {path: 'devoluciones',component:DevolucionesComponent},
  {path:'usuarios', component:UsuariosComponent},
  {path:'libros', component:LibrosComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
