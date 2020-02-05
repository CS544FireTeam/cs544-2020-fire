import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CourseOffering, Location} from "../../../domain/models";
import Course from "../../../domain/models/course.model";
import User from "../../../domain/models/user.model";
import {CourseClientService, LocationClientService} from "../../../domain/core/http";
import {UserClientService} from "../../../domain/core/http/user-client.service";
import {UserRoleEnum} from "../../../domain/enums";

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

  constructor(private formBuilder: FormBuilder,
              private courseClientService: CourseClientService,
              private userClientService: UserClientService,
              private locationClientService: LocationClientService,
              ) {
  }

  get courseOffering(): CourseOffering {
    return this._courseOffering;
  }

  courses : Course[];
  locations: Location[] ;
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
    this.courseClientService.getAllCourses$().subscribe( courses => {
      this.courses = courses;
    });
    this.locationClientService.getAllLocations$().subscribe( locations => {
      this.locations = locations;
    });
    this.userClientService.getAllUsers$().subscribe( courses => {
      this.courses = courses.filter( user => user.role === UserRoleEnum.FACULTY);
    })
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
