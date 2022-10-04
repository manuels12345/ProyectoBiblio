import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Reserva } from '../models/Reserva';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})

export class ReservaService {


  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'GET,POST,OPTIONS,DELETE,PUT'
    }),
  };

  constructor(private http: HttpClient) {}

  agregarReserva(reserva : Reserva): Observable<Reserva> {
    const idUsuario = reserva.user_id;
    const idBook = reserva.book_id;

    return this.http.post<Reserva>('http://localhost:8080/lendigs/users/'+ idUsuario + '/books/' + idBook, reserva, this.httpOptions);
  }

}
