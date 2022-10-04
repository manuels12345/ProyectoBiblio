export class Reserva {
  id?: number;
  user_id: string;
  book_id: string;
  date_out?: string;
  date_return?: string;
  deleted?: boolean;
  constructor(user_id: string,book_id: string) {
  this.user_id = user_id;
  this.book_id = book_id;
  }
}
