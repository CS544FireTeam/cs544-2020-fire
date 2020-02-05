import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CourseOffering, Location} from "../../../domain/models";
import Course from "../../../domain/models/course.model";
import User from "../../../domain/models/user.model";
import {CourseClientService, LocationClientService} from "../../../domain/core/http";
import {UserClientService} from "../../../domain/core/http/user-client.service";
import {UserRoleEnum} from "../../../domain/enums";
import {DateAdapter, MAT_DATE_FORMATS} from "@angular/material/core";
import {APP_DATE_FORMATS, AppDateAdapter} from "../../shared/Utils/format-datepicker";

@Component({
  selector: 'fire-course-offering-edit',
  templateUrl: './course-offering-edit.component.html',
  styleUrls: ['./course-offering-edit.component.less'],
  providers: [
    {provide: DateAdapter, useClass: AppDateAdapter},
    {provide: MAT_DATE_FORMATS, useValue: APP_DATE_FORMATS}
  ]
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

  constructor(private formBuilder: FormBuilder,
              private courseClientService: CourseClientService,
              private userClientService: UserClientService,
              private locationClientService: LocationClientService,
  ) {
  }

  get courseOffering(): CourseOffering {
    return this._courseOffering;
  }

  courses: Course[];
  locations: Location[];
  faculties: User[];

  ngOnInit() {
    this.formGroup = this.formBuilder.group({
      id: [''],
      course: ['', Validators.required],
      location: ['', Validators.required],
      faculty: ['', Validators.required],
      startDate: ['', Validators.required],
      endDate: ['', Validators.required],
    });

    this.courseClientService.getAllCourses$().subscribe(courses => {
      this.courses = courses;
    });
    this.locationClientService.getAllLocations$().subscribe(locations => {
      this.locations = locations;
    });
    this.userClientService.getAllUsers$().subscribe(uers => {
      this.faculties = uers.filter(user => user.role === UserRoleEnum.FACULTY);
    })
  }

  loadData(courseOffering: CourseOffering) {
    if (courseOffering) {
      this.formGroup.patchValue(courseOffering);
    }
  }

  save() {
    this.onAdd.emit(this.getCourseOffer());
  }

  update() {
    this.onUpdate.emit(this.getCourseOffer());
  }

  delete() {
    this.onDelete.emit(this.formGroup.value);
  }

  private getCourseOffer() {
    return {
    ...this.formGroup.value,
    }
  }

  compareObjects(o1: any, o2: any): boolean {
    return o1.id === o2.id;
  }
}
