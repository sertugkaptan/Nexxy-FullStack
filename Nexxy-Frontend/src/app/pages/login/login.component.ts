import { Component, EventEmitter, Input, Output } from '@angular/core';
import {
  LoginCredentials,
  LoginCredentialsImpl,
} from '../../Entities/login/LoginCredentials';
import { Router } from '@angular/router';
import {
  FormGroup,
  FormsModule,
  NgModel,
  ReactiveFormsModule,
} from '@angular/forms';
import { CommonModule } from '@angular/common';
import { MovieApiServiceService } from '../../service/movie-api-service.service';
import { UserImpl } from '../../Entities/login/User';

@Component({
  selector: 'login-component',
  standalone: true,
  imports: [FormsModule, CommonModule, ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {
  loginForm!: FormGroup;
  @Input() isRegister: boolean = false;
  errorMessage: string | null = null;
  @Output() closed = new EventEmitter<void>(); // Event to signal closure

  constructor(
    private router: Router,
    private service: MovieApiServiceService
  ) {} // Inject Router for navigation

  ngOnInit(): void {
    this.loginForm = new FormGroup(new LoginCredentialsImpl());
    console.log(this.isRegister);
  }

  onSubmit() {
    if (this.isRegister) {
      console.log(this.loginForm);
      this.createUser(this.loginForm);
    }

    // if(this.loginForm != null && this.loginForm.valid){
    //   console.log('Login form submitted:', this.loginForm.value);
    //   this.service.exportMovies().subscribe(data=>data);

    //   // Simulate successful login (replace with actual login logic)
    //   // this.router.navigate(['']);
    // }
  }
  createUser(loginForm: FormGroup): void {
    let user = new UserImpl();
    user.username = loginForm.get('username')!.value;
    user.email = loginForm.get('email')!.value;
    user.password = loginForm.get('password')!.value;
    console.log('test', user);

    this.service.createUser(user).subscribe((data) => data);
    this.closed.emit();
  }
}
