export class Usuario {
    id?: number;
    account_non_expired?: boolean;
    account_non_locked?: boolean;
    credentials_non_expired?: boolean;
    deleted?: boolean;
    enabled?: boolean;
    fault?: string;
    username: string;
    password: string;
    name: string;
    lastname: string;
    address: string;
    tel: string;
    constructor(username: string, password: string, name: string, lastname: string, address: string, tel:string){
    this.username = username;
    this.password = password;
    this.name = name;
    this.lastname = lastname;
    this.address = address;
    this.tel = tel;
    }
}
