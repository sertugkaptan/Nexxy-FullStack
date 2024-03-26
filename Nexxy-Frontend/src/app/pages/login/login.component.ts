import { Component, EventEmitter, Output } from '@angular/core';
import { LoginCredentials, LoginCredentialsImpl } from '../../Entities/login/LoginCredentials';
import { Router } from '@angular/router';
import { FormGroup, FormsModule, NgModel, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { MovieApiServiceService } from '../../service/movie-api-service.service';

@Component({
  selector: 'login-component',
  standalone: true,
  imports: [FormsModule,CommonModule,ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  loginForm! : FormGroup;

  errorMessage: string | null = null;
  @Output() closed = new EventEmitter<void>(); // Event to signal closure

  constructor(private router: Router,private service:MovieApiServiceService) { }  // Inject Router for navigation

  ngOnInit(): void { 
    this.loginForm = new FormGroup(new LoginCredentialsImpl());
  }

  onSubmit() {
    console.log(this.loginForm);
    
    if(this.loginForm != null && this.loginForm.valid){
      console.log('Login form submitted:', this.loginForm.value);
      this.service.exportMovies().subscribe(data=>data);

      // Simulate successful login (replace with actual login logic)
      // this.router.navigate(['']);
      this.closed.emit();
    }
  }
}
