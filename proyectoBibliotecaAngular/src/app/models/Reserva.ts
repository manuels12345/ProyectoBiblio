export class Reserva {
  constructor(
    public id: number | null | undefined,
    public book_id: number,
    public date_out: string,
    public date_return: string | null | undefined,
    public deleted: boolean | null | undefined,
    public user_id: boolean | null | undefined
  ) {}
}
