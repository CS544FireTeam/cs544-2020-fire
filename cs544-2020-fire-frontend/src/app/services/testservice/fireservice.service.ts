import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FireserviceService {
  baseUrl : String  = "http://localhost:8080";
  constructor(private http : HttpClient) { }

  createAccount(email: String, password: String) :Observable<any>{   
    var body = {
      username : email,
      password : password
    }
    return this.http.post("http://localhost:8080/register",body);
    
  }

  firstLoginAttempt(email,password): Observable<any>{   
    var user  =  {
      username : email,
      password : password
    }
    return this.http.post("http://localhost:8080/login",user);
    
  }
  
}
