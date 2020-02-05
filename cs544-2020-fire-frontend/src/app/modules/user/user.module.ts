import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MaterialModule} from "../../material-module";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {TimeSlotRouting} from "./user-routing.module";
import {UserHomeComponent} from "./user-home/user-home.component";


@NgModule({
  declarations: [
    UserHomeComponent,
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
export class UserModule { }
