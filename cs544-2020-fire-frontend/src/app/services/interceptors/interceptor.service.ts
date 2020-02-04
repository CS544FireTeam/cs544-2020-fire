import { Injectable,Injector } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpErrorResponse, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import {  tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class InterceptorService implements HttpInterceptor{

  constructor(private injector: Injector) { }

  private handleError(err: HttpErrorResponse): Observable<any> {
    let errorMsg;
    if (err.error instanceof Error) {
        errorMsg = `An error occurred: ${err.error.message}`;
        console.log(errorMsg);
    } else {
        errorMsg = `Backend returned code ${err.status}, body was: ${err.error}`;
    }
    if (err.status === 404 || err.status === 403) {
        console.log(errorMsg);
    }

    if (err.status === 401) {
      console.log("ITS NOT WORKING Bliat")
      console.log(errorMsg);
    }
  
    return Observable.throw(errorMsg);
}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    var authReq :HttpRequest<any>;
   if(localStorage.getItem("token")!=null){
    authReq = req.clone({headers: req.headers.set("Authorization","Bearer "+localStorage.getItem("token"))});
   }else{
    authReq = req;
   }
    return next.handle(authReq).pipe(tap(success=>{
      
      if(authReq.url=="http://localhost:8080/login"){
         this.injector.get(Router).navigateByUrl('pages/dashboard');
      }
     
    },err=>{
      this.injector.get(Router).navigateByUrl('pages/home');
    }));
  }





}
