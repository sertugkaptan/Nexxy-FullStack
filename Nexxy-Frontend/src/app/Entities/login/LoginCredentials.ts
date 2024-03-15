import { FormControl, Validators } from "@angular/forms";

export interface LoginCredentials {
  username: FormControl;
  password: FormControl;
}

export class LoginCredentialsImpl implements LoginCredentials{
    username: FormControl;
    password: FormControl;
    constructor(){
        this.username= new FormControl('', Validators.required);
        this.password=new FormControl('', Validators.required);
    }
}