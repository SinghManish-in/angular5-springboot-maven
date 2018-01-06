import { Component, OnInit } from '@angular/core';

import { RegisterUser } from '../model/register.user';
import { RegisterService } from '../service/register.service';
import { Observable } from 'rxjs/Observable';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  firstNameValid: boolean = true;
  lastNameValid: boolean = true;
  emailValid: boolean = true;
  reEnterEmailValid: boolean = true;
  passwordValid: boolean = true;
  genderValid: boolean = true;

  hideReEnterEmail: boolean = true;

  constructor(private userService: RegisterService, private registerUser: RegisterUser, private router: Router) {
  }

  isValidForm() {
    if (this.registerUser.firstName && this.registerUser.lastName && this.registerUser.email && this.registerUser.password && this.registerUser.gender)
      alert("ms");
  }

  isReEnterEmailValid() {
    if (this.registerUser.email && this.registerUser.reEnterEmail && this.registerUser.email == this.registerUser.reEnterEmail) {
      this.reEnterEmailValid = true;
    }
    else {
      this.reEnterEmailValid = false;
    }
  }

  isEmailValid() {
    if (this.registerUser.email && this.isEmailFormatValid()) {
      this.emailValid = true;
      this.hideReEnterEmail = false;
    }
    else {
      this.emailValid = false;
      this.hideReEnterEmail = true;
    }
  }

  isPasswordValid() {
    if (this.registerUser.password)
      this.passwordValid = true;
    else
      this.passwordValid = false;
  }

  isLastNameValid() {
    if (this.registerUser.lastName)
      this.lastNameValid = true;
    else
      this.lastNameValid = false;
  }

  isFirstNameValid() {
    if (this.registerUser.firstName)
      this.firstNameValid = true;
    else
      this.firstNameValid = false;
  }

  isEmailFormatValid(): boolean {
    var validEmailPattern = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return validEmailPattern.test(this.registerUser.email);
  }

  register(registerUser): void {
    this.userService.register(this.registerUser).subscribe(
      data => {
        if (data)
          this.router.navigate(['/home']);
      },
      error => {
        console.error("Error saving user!");
        return Observable.throw(error);
      }
    );
  }

  ngOnInit(): void {
  }
}
