import {ActivatedRouteSnapshot, CanActivate, Router} from "@angular/router";
import {AuthService} from "./auth.service";
import {Injectable} from "@angular/core";

@Injectable({
  providedIn: "root",
})
export class AdminGuard implements CanActivate {
  constructor(public auth: AuthService,
              public router: Router) {
  }

  canActivate(route: ActivatedRouteSnapshot): boolean {
    const expectedRoles: string[] = route.data.expectedRoles;
    return this.auth.isActiveRole(expectedRoles);
  }
}
