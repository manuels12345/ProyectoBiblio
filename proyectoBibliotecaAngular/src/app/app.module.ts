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
<<<<<<< HEAD
import { DataTableComponent } from './components/data-table/data-table.component';
import { DateFormatterPipe } from './pipes/date-formatter.pipe';
import { DynamicPipe } from './pipes/dynamic.pipe';
import { LibrosComponent } from './pages/libros/libros.component';

=======
>>>>>>> 283c913e354bb457e8fb8d6b10f80060190bd513

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    PrincipalComponent,
    PrestamosComponent,
    DevolucionesComponent,
    UsuariosComponent,
<<<<<<< HEAD
    DataTableComponent,
    DynamicPipe,
    DateFormatterPipe,
    LibrosComponent
=======
>>>>>>> 283c913e354bb457e8fb8d6b10f80060190bd513
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
