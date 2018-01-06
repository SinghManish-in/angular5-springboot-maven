import { Injectable } from "@angular/core";
import { HttpModule, Http, Response, Headers, RequestOptions } from "@angular/http";
import { Observable } from "rxjs/Rx";

import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { LoginUser } from '../model/login.user';
import { RegisterUser } from '../model/register.user';


@Injectable()
export class LoginService {

  private serverUrl = 'http://localhost:8080/user';  // Base URL to web api for USER

  constructor(
    private http: Http) { }

  // Autheticate user from server
  isAuthenticated(user: LoginUser): Observable<Response> {
    let cpHeaders = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: cpHeaders });
    return this.http.post(this.serverUrl+"/login", JSON.stringify(user), options).map((res: Response) => res.json().success);
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }
}
