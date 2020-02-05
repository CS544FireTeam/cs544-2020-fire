import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CourseHomeComponent} from "./course-home/course-home.component";
import {CourseListComponent} from "./course-list/course-list.component";
import {CourseEditComponent} from "./course-edit/course-edit.component";

const routes: Routes = [
  {
    path: '',
    component: CourseHomeComponent,
  },
  {
    path: 'list',
    component: CourseListComponent,
  },
  {
    path: 'new',
    component: CourseEditComponent,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CourseRouting {
}
