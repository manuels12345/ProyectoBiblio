export class Usuario {
    constructor(
      public id: number | null | undefined,
      public address: string,
      public deleted: boolean | null | undefined,
      public fault: number | null | undefined,
      public last_name: string,
      public name: string,
      public tel: string | null | undefined,
      public account_non_expired: boolean | null | undefined,
      public account_non_locked: boolean | null | undefined,
      public credentials_non_locked: boolean | null | undefined,
      public enabled: boolean | null | undefined,
      public password: string,
      public username: string
    ) {}
  }
