import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {UserHomeComponent} from "./user-home/user-home.component";

const routes: Routes = [
  {
    path: '',
    component: UserHomeComponent,
  },
/*  {
    path: 'list',
    component: TimeSlotListComponent,
  },
  {
    path: 'new',
    component: TimeSlotEditComponent,
  }*/
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TimeSlotRouting {
}
