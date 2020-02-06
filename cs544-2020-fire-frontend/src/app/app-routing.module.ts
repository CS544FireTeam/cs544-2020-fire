import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MainPageComponent} from "./modules/home/main-page/main-page.component";
import {HomepageComponent} from "./modules/home/home-page/home-page.component";
import {AuthGuardFireService} from "./domain/core/security/auth-guard.service";
import {AdminGuard} from "./domain/core/security/admin-guard.service";
import {UserRoleEnum} from "./domain/enums";
import {DashboardComponent} from "./modules/home/dashboard/dashboard.component";


const routes: Routes = [
  {
    path: 'login',
    component: HomepageComponent,
  },
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  },
  {
    path: 'fire',
    component: MainPageComponent,
    canActivate: [AuthGuardFireService],
    children: [
      {
        path:'welcome',
        component: DashboardComponent,
      },
      {
        path: 'users',
        loadChildren: () => import('./modules/user/user.module').then(m => m.UserModule),
        canActivate: [AdminGuard],
        data: {
          expectedRoles: [UserRoleEnum.ADMIN, UserRoleEnum.FACULTY]
        }
      },
      {
        path: 'courses',
        loadChildren: () => import('./modules/course/course.module').then(m => m.CourseModule),
        data: {
          expectedRoles: [UserRoleEnum.ADMIN, UserRoleEnum.FACULTY]
        }
      },
      {
        path: 'courseoffering',
        loadChildren: () => import('./modules/courseOffering/courseOffering.module').then(m => m.CourseOfferingModule),
        data: {
          expectedRoles: [UserRoleEnum.ADMIN, UserRoleEnum.FACULTY]
        }
      },
      {
        path: 'location',
        loadChildren: () => import('./modules/location/location.module').then(m => m.LocationModule),
        data: {
          expectedRoles: [UserRoleEnum.ADMIN, UserRoleEnum.FACULTY]
        }
      },
      {
        path: 'timeslot',
        loadChildren: () => import('./modules/timeSlot/time-slot.module').then(m => m.TimeSlotModule),
        data: {
          expectedRoles: [UserRoleEnum.ADMIN, UserRoleEnum.FACULTY]
        }
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
