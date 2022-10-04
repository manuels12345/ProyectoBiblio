import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Reserva } from 'src/app/models/Reserva';
import { ReservaService } from 'src/app/servicios/reserva.service';

@Component({
  selector: 'app-prestamos',
  templateUrl: './prestamos.component.html',
  styleUrls: ['./prestamos.component.css']
})
export class PrestamosComponent implements OnInit {

  constructor(private reservaService: ReservaService) { }

  ngOnInit(): void {
  }

  reserva = new FormGroup({
    user_id: new FormControl(''),
    book_id: new FormControl('')
  });

  onSubmit() {
    const reserva = new Reserva(
      this.reserva.value['user_id'] as string, 
      this.reserva.value['book_id'] as string,
      );

      if(!this.reserva.value['user_id'] || !this.reserva.value['book_id']){
        alert("Faltan datos");
      }
      return this.reservaService.agregarReserva(reserva).subscribe(reserva => {
        console.log(reserva);
      })
  }

}
