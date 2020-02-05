import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomepageComponent } from './modules/home/home-page/home-page.component';
import { DashboardComponent } from './modules/home/dashboard/dashboard.component';
import { UserHomeComponent } from './modules/user/user-home/user-home.component';
import { CourseHomeComponent } from './modules/course/course-home/course-home.component';
import { CourseOfferingHomeComponent } from './modules/courseOffering/course-offering-home/course-offering-home.component';
import { SessionHomeComponent } from './modules/session/session-home/session-home.component';
import { LocationHomeComponent } from './modules/location/location-home/location-home.component';
import { AuthGuardService } from './domain/services/AuthGuard/auth-guard.service';
import { UserRoleEnum } from './domain';


const routes: Routes = [
  {path: '', redirectTo: 'pages/home', pathMatch: 'full' },
  {path: 'pages/home', component: HomepageComponent},
  {
    path: 'pages/dashboard', 
    component: DashboardComponent,
    // canActivate : [AuthGuardService],
    // data : {roles:[UserRoleEnum.ADMIN]}
   },
  {path: 'pages/users', component: UserHomeComponent},
  {path: 'pages/courses', component: CourseHomeComponent},
  {path: 'pages/courseoffering', component: CourseOfferingHomeComponent},
  {path: 'pages/session', component: SessionHomeComponent},
  {path: 'pages/location', component: LocationHomeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
