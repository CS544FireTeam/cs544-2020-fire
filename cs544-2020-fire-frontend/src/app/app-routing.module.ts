import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MainPageComponent} from "./modules/home/main-page/main-page.component";
import {HomepageComponent} from "./modules/home/home-page/home-page.component";


const routes: Routes = [
  {
    path: '',
    component: HomepageComponent,
  },
  {
    path: 'home',
    component: MainPageComponent,
    children: [
      {
        path: 'users',
        loadChildren: () => import('./modules/user/user.module').then(m => m.UserModule),
      },
      {
        path: 'courses',
        loadChildren: () => import('./modules/course/course.module').then(m => m.CourseModule),
      },
      {
        path: 'courseoffering',
        loadChildren: () => import('./modules/course/course.module').then(m => m.CourseModule),
      },
      {
        path: 'location',
        loadChildren: () => import('./modules/location/location.module').then(m => m.LocationModule),
      },
      {
        path: 'timeslot',
        loadChildren: () => import('./modules/timeSlot/time-slot.module').then(m => m.TimeSlotModule),
      },
    ]
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
