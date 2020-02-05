import {AfterViewInit, Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {PagingBaseComponent} from "../../shared/components/paging-base.component";
import CourseOffering from "../../../domain/models/course-offering";

@Component({
  selector: 'fire-course-offering-list',
  templateUrl: './course-offering-list.component.html',
  styleUrls: ['./course-offering-list.component.less']
})
export class CourseOfferingListComponent extends PagingBaseComponent<CourseOffering> implements OnInit, AfterViewInit {

  @Input() set courseOfferings(courseOfferings: CourseOffering[]) {
    this._courseOfferings = courseOfferings;
    //super.ngOnInit(courseOfferings);
  }

  @Output() onEdit: EventEmitter<CourseOffering> = new EventEmitter();
  @Output() onAddNew: EventEmitter<CourseOffering> = new EventEmitter();

  _courseOfferings: CourseOffering[];

  get courseOfferings() {
    //return this._courseOfferings;
    return [
      {
        course: {
          code: 'MPP422'
        },
        location: {
          description: "Auto Pia"
        },
        faculty: {
          firstName: 'Lam',
          lastName: 'Tang'
        },
        startDate: new Date(),
        endDate: new Date(),
      }
    ]
  }

  mockDatas: CourseOffering[] = [
    {

      course: {
        code: 'MPP422'
      },
      location: {
        description: "Auto Pia"
      },
      faculty: {
        firstName: 'Lam',
        lastName: 'Tang'
      },
      startDate: new Date(),
      endDate: new Date(),
    },
    {
      course: {
        code: 'MPP422'
      },
      location: {
        description: "Auto Pia"
      },
      faculty: {
        firstName: 'Lam',
        lastName: 'Tang'
      },
      startDate: new Date(),
      endDate: new Date(),
    },
    {
      course: {
        code: 'MPP422'
      },
      location: {
        description: "Auto Pia"
      },
      faculty: {
        firstName: 'Lam',
        lastName: 'Tang'
      },
      startDate: new Date(),
      endDate: new Date(),
    }
  ];

  constructor() {
    super(['course', 'location', 'faculty', 'startDate', 'endDate', 'actionButton']);
  }

  ngOnInit() {
    //super.ngOnInit(this.courseOfferings);
    super.ngOnInit(this.mockDatas);
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
