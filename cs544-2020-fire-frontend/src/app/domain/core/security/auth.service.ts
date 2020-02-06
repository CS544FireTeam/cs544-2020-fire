import {Injectable} from "@angular/core";
import {JwtHelperService} from "@auth0/angular-jwt";
import {User} from "../../models";
import {UserRoleEnum} from "../../enums";

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
    const user: User = JSON.parse(localStorage.getItem('fire-user'));
    //const userRole = localStorage.getItem('fire-user');
    if (this.isAuthenticated() && expectedRoles.includes(user.role.toString())) {
      return true;
    }
    return false;
  }

  public getUserInformation(){
    const user: User = this.getUser();
    return user.firstName + ', ' + user.lastName;
  }

  public getUserRole() {
    const user: User = this.getUser();
    return user.role;
  }

  private getUser(): User {
    const userObject = localStorage.getItem('fire-user');
    if(userObject) {
      const user: User = JSON.parse(userObject);
      return user;
    } else {
      return {
        firstName: 'Anonymous',
        lastName: 'Anonymous',
        role: UserRoleEnum.ANONYMOUS,
      }
    }
  }
}
