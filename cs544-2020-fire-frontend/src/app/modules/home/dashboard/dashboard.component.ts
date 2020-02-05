import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FireserviceService } from 'src/app/domain/services/testservice/fireservice.service';
import { User } from 'src/app/domain';

@Component({
  selector: 'fire-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  page = "users";
  opened:boolean = false;
  user:User;
  constructor(private router: Router,private fireService:FireserviceService) { 
      this.user = this.fireService.user;
  }

  ngOnInit() {
  }

  show(type:string):void {
    this.opened = false;
    this.page=type;
  }

  logout(){
    localStorage.clear();
    this.router.navigateByUrl('/pages/home');
}

}
