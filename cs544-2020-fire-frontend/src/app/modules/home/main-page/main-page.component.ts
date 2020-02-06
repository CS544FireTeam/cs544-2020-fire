import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {AuthService} from "../../../domain/core/security/auth.service";
import {UserRoleEnum} from "../../../domain/enums";

@Component({
  selector: 'fire-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.less']
})
export class MainPageComponent implements OnInit {

  constructor(private router: Router, public auth: AuthService) {
  }

  isInActiveRole: boolean;

  ngOnInit() {
    this.isInActiveRole = !this.auth.isActiveRole([UserRoleEnum.ADMIN, UserRoleEnum.FACULTY])
  }

  logout() {
    localStorage.clear();
    this.router.navigate(['../']);
  }
}
