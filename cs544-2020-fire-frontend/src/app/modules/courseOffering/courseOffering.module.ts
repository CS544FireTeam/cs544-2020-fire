import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MaterialModule} from "../../material-module";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CourseOfferingEditComponent} from "./course-offering-edit/course-offering-edit.component";
import {CourseOfferingHomeComponent} from "./course-offering-home/course-offering-home.component";
import {CourseOfferingListComponent} from "./course-offering-list/course-offering-list.component";
import {CourseOfferingRouting} from "./course-routing.module";


@NgModule({
  declarations: [
    CourseOfferingEditComponent,
    CourseOfferingHomeComponent,
    CourseOfferingListComponent,
  ],
  imports: [
    CommonModule,
    CommonModule,
    CourseOfferingRouting,
    MaterialModule,
    ReactiveFormsModule,
    FormsModule,
  ]
})
export class CourseOfferingModule { }
