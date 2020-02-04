import {Component, OnInit} from '@angular/core';
import {FireserviceService} from 'src/app/domain/services/testservice/fireservice.service';
import Course from "../../../domain/models/course.model";



@Component({
  selector: 'fire-coursepage',
  templateUrl: './course-home.component.html',
  styleUrls: ['./course-home.component.less']
})
export class CourseHomeComponent implements OnInit {
  barcode = '';
  user = {
    "name": "",
    "barcode": ""
  };

  DEFAULT_EMPTY_COURSE = {
    abbr: '',
    name:'',
    code:'',
    description:'',
  };

  selectedTab = 0;

  currentCourse: Course;


  constructor(private fireService: FireserviceService) {
  }

  ngOnInit() {
  }


  submit() {
    this.fireService.getBarcode(this.barcode).subscribe((res) => {
      this.user = res;
      console.log(res);
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

  saveCourse($event: Course) {
    //Todo integrate with BK
    this.selectListCourse();
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


