import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CourseOfferingHomeComponent} from "./course-offering-home/course-offering-home.component";
import {CourseOfferingListComponent} from "./course-offering-list/course-offering-list.component";
import {CourseOfferingEditComponent} from "./course-offering-edit/course-offering-edit.component";
import {UserRoleEnum} from "../../domain/enums";

const routes: Routes = [
  {
    path: '',
    component: CourseOfferingHomeComponent,
    data: {
      expectedRoles: [UserRoleEnum.ADMIN, UserRoleEnum.FACULTY]
    }
  },
  {
    path: 'list',
    component: CourseOfferingListComponent,
  },
  {
    path: 'new',
    component: CourseOfferingEditComponent,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CourseOfferingRouting {
}
