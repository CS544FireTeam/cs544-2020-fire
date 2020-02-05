import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import Course from "../../../domain/models/course.model";

@Component({
  selector: 'fire-course-edit',
  templateUrl: './course-edit.component.html',
  styleUrls: ['./course-edit.component.less']
})
export class CourseEditComponent implements OnInit {

  @Input()
  set course(course: Course) {
    this._course = course;
    this.loadData(this.course);
  }

  @Output() onUpdate: EventEmitter<Course> = new EventEmitter();
  @Output() onAdd: EventEmitter<Course> = new EventEmitter();
  @Output() onDelete: EventEmitter<Course> = new EventEmitter();

  formGroup: FormGroup;

  private _course: Course;

  constructor(private formBuilder: FormBuilder) {
  }

  get course(): Course {
    return this._course;
  }

  ngOnInit() {
    this.formGroup = this.formBuilder.group({
      id: [''],
      code: ['', Validators.required],
      abbr: ['', Validators.required],
      name: ['', Validators.required],
      description: [''],
    });
  }

  loadData(course: Course) {
    if (course) {
      this.formGroup.patchValue(course);
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
