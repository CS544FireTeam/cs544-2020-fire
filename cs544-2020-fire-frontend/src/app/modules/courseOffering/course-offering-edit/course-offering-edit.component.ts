import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CourseOffering, Location} from "../../../domain/models";
import Course from "../../../domain/models/course.model";
import User from "../../../domain/models/user.model";

@Component({
  selector: 'fire-course-offering-edit',
  templateUrl: './course-offering-edit.component.html',
  styleUrls: ['./course-offering-edit.component.less']
})
export class CourseOfferingEditComponent implements OnInit {

  @Input()
  set courseOffering(courseOffering: CourseOffering) {
    this._courseOffering = courseOffering;
    this.loadData(this.courseOffering);
  }

  @Output() onUpdate: EventEmitter<CourseOffering> = new EventEmitter();
  @Output() onAdd: EventEmitter<CourseOffering> = new EventEmitter();
  @Output() onDelete: EventEmitter<CourseOffering> = new EventEmitter();

  formGroup: FormGroup;

  private _courseOffering: CourseOffering;

  constructor(private formBuilder: FormBuilder) {
  }

  get courseOffering(): CourseOffering {
    return this._courseOffering;
  }

  courses : Course[] = [
    { id: 1, code: 'CS 109', abbr: 'MICROS Tour', name: 'Meeting with Compro students at MICROS company', description: 'Meeting with Compro students at MICROS company', },
    { id: 2, code: 'CS 110', abbr: 'ICC Tour', name: 'Meeting with Compro students at ICC, Ohio', description: 'Meeting with Compro students at ICC, Ohio', },
    { id: 3, code: 'CS000', abbr: 'JSearch', name: 'Job Search (Sept 04 students only)', description: 'Full-time Job Search', },
    { id: 4, code: 'CS108', abbr: 'Des Moines Trip', name: 'Meeting with Compro Students by Dr. Gregory and Elaine Guthrie', description: 'Meeting with Compro Students by Dr. Gregory and Elaine Guthrie', },
    { id: 5, code: 'CS208', abbr: 'Seattle Trip', name: 'Meeting with Compro Students by Dr. Gregory and Elaine Guthrie', description: 'Meeting with Compro Students by Dr. Gregory and Elaine Guthrie', },
    { id: 6, code: 'CS220', abbr: 'Data Structures', name: 'Data Structures', description: 'NULL', },
    { id: 7, code: 'CS390', abbr: 'FPP', name: 'Fundamental Programming Practices', description: 'Fundamentals of OO Programming', },
    { id: 8, code: 'CS401', abbr: 'MPP', name: 'Modern Programming Practices', description: 'Modern Programming Practices', },
  ];

  locations: Location[] = [
      {
        id: 1,
        description: 'Autopia',
      },
      {
        id: 2,
        description: 'Dorm',
      }
    ];

  faculties: User[] = [
    {
      id: 1,
      username: 'Lam Tang',
      firstName: 'Lam',
      lastName: 'Tang'
    },
    {
      id: 2,
      username: 'Mike',
      firstName: 'Mike',
      lastName: 'Tayson'
    },
    {
      id: 3,
      username: 'Hoang Thao',
      firstName: 'Thao',
      lastName: 'Hoang'
    }
  ];

  ngOnInit() {
    this.formGroup = this.formBuilder.group({
      id: [''],
      course: ['', Validators.required],
      location: ['', Validators.required],
      faculty: ['', Validators.required],
      startDate: ['', Validators.required],
      endDate: ['', Validators.required],
    });
  }

  loadData(courseOffering: CourseOffering) {
    if (courseOffering) {
      this.formGroup.patchValue(courseOffering);
    }
  }

  save() {
    this.onAdd.emit(this.formGroup.value);
  }

  update() {
    this.onUpdate.emit(this.formGroup.value);
  }

  delete() {
    this.onDelete.emit(this.formGroup.value);
  }

}
