export interface User{
    username:string;
    email:string;
    password:string;
    moviesWatched:number[];
}

export class UserImpl implements User{
    username: string;
    email: string;
    password: string;
    moviesWatched: number[];
    constructor(){
        this.email='';
        this.username = '';
        this.password = '';
        this.moviesWatched = [];
    }
}