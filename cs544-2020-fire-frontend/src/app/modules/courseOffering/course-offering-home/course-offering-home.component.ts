import { Component, OnInit } from '@angular/core';
import CourseOffering from "../../../domain/models/course-offering";
import {CourseOfferingClientService} from "../../../domain/core/http";
import {AuthService} from "../../../domain/core/security/auth.service";
import {UserRoleEnum} from "../../../domain/enums";

@Component({
  selector: 'fire-course-offering-home',
  templateUrl: './course-offering-home.component.html',
  styleUrls: ['./course-offering-home.component.less']
})
export class CourseOfferingHomeComponent implements OnInit {

  DEFAULT_EMPTY_COURSE_OFFERING = {
    id: undefined,
    course: undefined,
    location: undefined,
    faculty: undefined,
    startDate: new Date(),
    endDate: new Date(),
  };

  selectedTab = 0;
  isAdmin: boolean;
  currentCourseOffering: CourseOffering;
  courseOfferings: CourseOffering[];

  constructor(private courseOfferingClientService: CourseOfferingClientService,
              public auth: AuthService) {
    this.isAdmin = auth.isActiveRole([UserRoleEnum.ADMIN])
  }

  ngOnInit() {
    this.loadListCourseOfferings();
  }

  loadListCourseOfferings() {
    this.courseOfferingClientService.getAllCourseOfferings$().subscribe(courseOfferings => {
      this.courseOfferings = courseOfferings;
      this.selectedTab = 0;
    })
  }

  onEditCourseOffering(courseOffering: CourseOffering) {
    this.currentCourseOffering = courseOffering;
    this.selectedTab = 1;
  }

  onAddCourseOffering() {
    this.currentCourseOffering = {
      ...this.DEFAULT_EMPTY_COURSE_OFFERING,
    };
    this.selectedTab = 1;
  }

  saveCourseOffering(courseOffering: CourseOffering) {
    this.courseOfferingClientService.addCourseOffering$(courseOffering).subscribe(course => {
      this.selectListCourse();
    })
  }

  deleteCourseOffering(courseOffering: CourseOffering) {
    this.courseOfferingClientService.deleteCourseOffering$(courseOffering.id).subscribe(() => {
      this.selectListCourse();
    });
  }

  updateCourseOffering(courseOffering: CourseOffering) {
    this.courseOfferingClientService.modifyCourseOffering$(courseOffering).subscribe(() => {
      this.selectListCourse();
    });
  }

  selectListCourse() {
    this.currentCourseOffering = {
      ...this.DEFAULT_EMPTY_COURSE_OFFERING,
    };
    this.loadListCourseOfferings();
  }

}
