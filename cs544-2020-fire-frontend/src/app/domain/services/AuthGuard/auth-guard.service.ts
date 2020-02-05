import { Injectable } from '@angular/core';
import { CanActivate, RouterStateSnapshot, ActivatedRouteSnapshot, Router } from '@angular/router';
import { FireserviceService } from '../testservice/fireservice.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate{

  constructor( private router: Router,private fireService:FireserviceService) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
    
    if(route.data.roles && route.data.roles.indexOf(this.fireService.roles.admin) === -1){
      console.log("THSIS WAS CALLED");
      return false;
    }
    console.log("THSIS WAS CALLED 2");
    return true;
  }
}
