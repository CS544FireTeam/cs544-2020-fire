import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MaterialModule} from "../../material-module";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {TimeSlotEditComponent} from "./time-slot-edit/time-slot-edit.component";
import {TimeSlotHomeComponent} from "./time-slot-home/time-slot-home.component";
import {TimeSlotListComponent} from "./time-slot-list/time-slot-list.component";
import {TimeSlotRouting} from "./time-slot-routing.module";


@NgModule({
  declarations: [
    TimeSlotEditComponent,
    TimeSlotHomeComponent,
    TimeSlotListComponent,
  ],
  imports: [
    CommonModule,
    CommonModule,
    TimeSlotRouting,
    MaterialModule,
    ReactiveFormsModule,
    FormsModule,
  ]
})
export class TimeSlotModule { }
