export interface User{
    id:number;
    username:string;
    email:string;
    password:string;
}

export class UserImpl implements User{
    id: number;
    username: string;
    email: string;
    password: string;
    constructor(){
        this.id= -1;
        this.email='';
        this.username = '';
        this.password = '';
    }
}