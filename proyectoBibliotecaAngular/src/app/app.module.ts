import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './layouts/header/header.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { PrincipalComponent } from './pages/principal/principal.component';
import { PrestamosComponent } from './pages/prestamos/prestamos.component';
import { DevolucionesComponent } from './pages/devoluciones/devoluciones.component';
import { UsuariosComponent } from './pages/usuarios/usuarios.component';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { LibrosComponent } from './pages/libros/libros.component';
<<<<<<< HEAD
import { LoginComponent } from './pages/login/login.component';
=======
import { NuevoUsuarioComponent } from './pages/nuevo-usuario/nuevo-usuario.component';
>>>>>>> 27d1615a7005b1bcc802b1a2bc5f33d4d5f3ce86

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    PrincipalComponent,
    PrestamosComponent,
    DevolucionesComponent,
    UsuariosComponent,
    LibrosComponent,
<<<<<<< HEAD
    LoginComponent
=======
    NuevoUsuarioComponent,
>>>>>>> 27d1615a7005b1bcc802b1a2bc5f33d4d5f3ce86
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
