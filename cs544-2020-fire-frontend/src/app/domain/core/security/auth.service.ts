import {Injectable} from "@angular/core";
import {JwtHelperService} from "@auth0/angular-jwt";

@Injectable({
  providedIn: "root",
})

export class AuthService {
  constructor(public jwtHelper: JwtHelperService) {}
  // ...
  public isAuthenticated(): boolean {
    const token = localStorage.getItem('token');
    // Check whether the token is expired and return
    // true or false
    return !this.jwtHelper.isTokenExpired(token);
  }

  public isActiveRole(expectedRoles: string[]): boolean {
    const userRole = localStorage.getItem('fire-role');
    if (this.isAuthenticated() && expectedRoles.includes(userRole)) {
      return true;
    }
    return false;
  }
}
