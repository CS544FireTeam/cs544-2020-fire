import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {CourseEditComponent} from "./course-edit/course-edit.component";
import {CourseHomeComponent} from "./course-home/course-home.component";
import {CourseListComponent} from "./course-list/course-list.component";
import {MaterialModule} from "../../material-module";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CourseRouting} from "./course-routing.module";

@NgModule({
  declarations: [
    CourseEditComponent,
    CourseHomeComponent,
    CourseListComponent,
  ],
  imports: [
    CommonModule,
    CommonModule,
    CourseRouting,
    MaterialModule,
    ReactiveFormsModule,
    FormsModule,
  ]
})
export class CourseModule { }
