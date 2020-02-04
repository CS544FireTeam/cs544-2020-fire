import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  page = "users";
  opened:boolean = false;
  constructor(private router: Router) { }

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
