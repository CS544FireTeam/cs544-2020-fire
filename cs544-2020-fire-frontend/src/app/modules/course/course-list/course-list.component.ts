import {AfterViewInit, Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {PagingBaseComponent} from "../../shared/components/paging-base.component";
import Course from "../../../domain/models/course.model";

@Component({
  selector: 'fire-course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.less']
})
export class CourseListComponent extends PagingBaseComponent<Course> implements OnInit, AfterViewInit {

  @Input() set courses(courses: Course[]) {
    this._courses = courses;
    super.ngOnInit(courses);
  }

  @Output() onEdit: EventEmitter<Course> = new EventEmitter();
  @Output() onAddNew: EventEmitter<Course> = new EventEmitter();

  _courses: Course[];

  get courses() {
    return this._courses;
  }

  constructor() {
    super(['number', 'abbr', 'name', 'description', 'actionButton']);
  }

  ngOnInit() {
    super.ngOnInit(this.courses);
  }

  ngAfterViewInit(): void {
    super.ngAfterViewInit();
  }

  onEditClick(course) {
    this.onEdit.emit(course)
  }

  onAddClick() {
    this.onAddNew.emit();
  }
}
