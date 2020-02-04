import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomepageComponent } from './pages/homepage/homepage.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';


const routes: Routes = [
  {path: '', redirectTo: 'pages/home', pathMatch: 'full' },
  {path: 'pages/home', component: HomepageComponent},
  {path: 'pages/dashboard', component: DashboardComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
