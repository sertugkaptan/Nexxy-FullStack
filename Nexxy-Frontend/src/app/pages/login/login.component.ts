import { Component } from '@angular/core';
import { LoginCredentials, LoginCredentialsImpl } from '../../Entities/login/LoginCredentials';
import { Router } from '@angular/router';
import { FormGroup, FormsModule, NgModel, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule,CommonModule,ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  loginForm! : FormGroup;

  errorMessage: string | null = null;

  constructor(private router: Router) { }  // Inject Router for navigation

  ngOnInit(): void { 
    this.loginForm = new FormGroup(new LoginCredentialsImpl());
  }

  onSubmit() {
    console.log(this.loginForm);
    
    if(this.loginForm != null && this.loginForm.valid){
      console.log('Login form submitted:', this.loginForm.value);

      // Simulate successful login (replace with actual login logic)
      this.router.navigate(['']);
    }
  }
}
