import { Component, OnInit } from '@angular/core';
import { LoginUser } from '../model/login.user';
import { LoginService } from '../service/login.service';
import { Observable } from 'rxjs/Observable';
import { Router, ActivatedRoute } from '@angular/router';

import {
  debounceTime, distinctUntilChanged, switchMap
} from 'rxjs/operators';
import { Alert } from 'selenium-webdriver';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: [ './login.component.css' ]
})
export class LoginComponent implements OnInit {
  
  constructor(private userService: LoginService,private loginUser:LoginUser,private route: ActivatedRoute, private router: Router){
  }

  logIn(): void {
    this.userService.isAuthenticated(this.loginUser).subscribe(
      data => {
        if(data)
        this.router.navigate(['/home']);
      },
      error => {
        console.error("Error in Authenticating User!");
        return Observable.throw(error);
      }
   );
  }

  ngOnInit(): void {
    
  }
  
}
