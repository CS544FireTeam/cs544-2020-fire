import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomepageComponent } from './pages/homepage/homepage.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { UserspageComponent } from './pages/userspage/userspage.component';
import { CoursepageComponent } from './pages/coursepage/coursepage.component';
import { CourseofferingpageComponent } from './pages/courseofferingpage/courseofferingpage.component';
import { SessionpageComponent } from './pages/sessionpage/sessionpage.component';
import { LocationpageComponent } from './pages/locationpage/locationpage.component';


const routes: Routes = [
  {path: '', redirectTo: 'pages/home', pathMatch: 'full' },
  {path: 'pages/home', component: HomepageComponent},
  {path: 'pages/dashboard', component: DashboardComponent},
  {path: 'pages/users', component: UserspageComponent},
  {path: 'pages/courses', component: CoursepageComponent},
  {path: 'pages/courseoffering', component: CourseofferingpageComponent},
  {path: 'pages/session', component: SessionpageComponent},
  {path: 'pages/location', component: LocationpageComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
