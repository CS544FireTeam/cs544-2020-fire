import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {TimeSlotHomeComponent} from "./time-slot-home/time-slot-home.component";
import {TimeSlotListComponent} from "./time-slot-list/time-slot-list.component";
import {TimeSlotEditComponent} from "./time-slot-edit/time-slot-edit.component";

const routes: Routes = [
  {
    path: '',
    component: TimeSlotHomeComponent,
  },
  {
    path: 'list',
    component: TimeSlotListComponent,
  },
  {
    path: 'new',
    component: TimeSlotEditComponent,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TimeSlotRouting {
}
