import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserRoleEnum } from '../../enums';
import User from '../../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class FireserviceService {
  baseUrl : String  = "http://localhost:8080";
  roles = {
   admin:UserRoleEnum.FACULTY,
  };
  

  constructor(private http : HttpClient) {}

  createAccount(email: String, password: String) :Observable<any>{   
    var body = {
      username : email,
      password : password
    }
    return this.http.post("http://localhost:8080/register",body);
    
  }

  getUser():User{
    console.log(localStorage.getItem('user'));
    return JSON.parse(localStorage.getItem('user'));
  }

  firstLoginAttempt(email,password): Observable<any>{   
    var user  =  {
      username : email,
      password : password
    }
    return this.http.post("http://localhost:8080/login",user);
    
  }

  enterBarcode(barcode): Observable<any>{   
    return this.http.post("http://localhost:8080/api/barcode",barcode);
    
  }

  getBarcode(barcode): Observable<any>{   
    return this.http.get("http://localhost:8080/api/getBarcode/"+barcode);
    
  }
  
}
