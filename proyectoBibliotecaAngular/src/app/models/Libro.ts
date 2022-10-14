export class Libro {
  constructor(
    public id: number | null | undefined,
    public author: string,
    public available: string,
    public category: string,
    public copy: string,
    public date: string,
    public deleted: boolean | null | undefined,
    public description: string,
    public edit: string,
    public lang: string,
    public lost: number | null | undefined,
    public pages: number,
    public renovation: number | null | undefined,
    public stock: number,
    public title: string
  ) {}
}
