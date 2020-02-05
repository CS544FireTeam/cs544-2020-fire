import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MaterialModule} from "../../material-module";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {LocationEditComponent} from "./location-edit/location-edit.component";
import {LocationHomeComponent} from "./location-home/location-home.component";
import {LocationListComponent} from "./location-list/location-list.component";
import {LocationRouting} from "./location-routing.module";

@NgModule({
  declarations: [
    LocationEditComponent,
    LocationHomeComponent,
    LocationListComponent,
  ],
  imports: [
    CommonModule,
    CommonModule,
    LocationRouting,
    MaterialModule,
    ReactiveFormsModule,
    FormsModule,
  ]
})
export class LocationModule { }
