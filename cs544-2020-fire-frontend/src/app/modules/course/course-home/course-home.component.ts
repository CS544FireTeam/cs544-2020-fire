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
  courses: Course[];

  constructor(private fireService: FireserviceService,
              private courseClientService: CourseClientService) {
  }

  ngOnInit() {
    this.loadListCourse();
  }

  loadListCourse() {
    this.courseClientService.getAllCourses$().subscribe(courses => {
      this.courses = courses;
      this.selectedTab = 0;
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
      this.selectListCourse();
    })
  }

  deleteCourse(course: Course) {
    this.courseClientService.deleteCourse$(course.id).subscribe(() => {
      this.selectListCourse();
    });
  }

  updateCoures(course: Course) {
    this.courseClientService.modifyCourse$(course).subscribe(() => {
      this.selectListCourse();
    });
  }

  selectListCourse() {
    this.currentCourse = {
      ...this.DEFAULT_EMPTY_COURSE,
    };
    this.loadListCourse();
  }
}


