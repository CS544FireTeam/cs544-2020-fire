import {Component, OnInit} from '@angular/core';
import {FireserviceService} from 'src/app/domain/services/testservice/fireservice.service';
import Course from "../../../domain/models/course.model";
import {CourseClientService} from "../../../domain/core/http";


@Component({
  selector: 'fire-coursepage',
  templateUrl: './course-home.component.html',
  styleUrls: ['./course-home.component.less']
})
export class CourseHomeComponent implements OnInit {

  DEFAULT_EMPTY_COURSE = {
    abbr: '',
    name: '',
    code: '',
    description: '',
  };

  selectedTab = 0;

  currentCourse: Course;

  constructor(private fireService: FireserviceService,
              private courseClientService: CourseClientService) {
  }

  ngOnInit() {
    this.courseClientService.getAllCourses$().subscribe(courses => {
      console.log(courses);
    })
  }

  onEditCourse(course: Course) {
    this.currentCourse = course;
    this.selectedTab = 1;
  }

  onAddCourse(course: Course) {
    this.currentCourse = {
      ...this.DEFAULT_EMPTY_COURSE,
    };
    this.selectedTab = 1;
  }

  saveCourse(course: Course) {
    this.courseClientService.addCourse$(course).subscribe(course => {
      console.log(course);
      this.selectListCourse();
    })
  }

  deleteCourse($event: Course) {
    //Todo integrate with BK
    this.selectListCourse();
  }

  updateCoures($event: Course) {
    //Todo integrate with BK
    this.selectListCourse();
  }

  selectListCourse() {
    // TODO: reload Data
    this.currentCourse = {
      ...this.DEFAULT_EMPTY_COURSE,
    };
    this.selectedTab = 0;
  }
}


