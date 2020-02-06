import {AfterViewInit, Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {PagingBaseComponent} from "../../shared/components/paging-base.component";
import {Course, TimeSlot} from "../../../domain/models";

@Component({
  selector: 'fire-time-slot-list',
  templateUrl: './time-slot-list.component.html',
  styleUrls: ['./time-slot-list.component.less']
})
export class TimeSlotListComponent extends PagingBaseComponent<TimeSlot> implements OnInit, AfterViewInit {

  @Input() set timeSlots(TimeSlots: Course[]) {
    this._timeSlots = TimeSlots;
    super.ngOnInit(TimeSlots);
  }
  @Input() isAdmin: false;
  @Output() onEdit: EventEmitter<TimeSlot> = new EventEmitter();
  @Output() onAddNew: EventEmitter<TimeSlot> = new EventEmitter();

  _timeSlots: TimeSlot[];

  constructor() {
    super(['description', 'beginTime', 'endTime', 'actionButton']);
  }

  get timeSlots() {
    return this._timeSlots;
  }

  ngOnInit() {
    super.ngOnInit(this.timeSlots);
  }

  ngAfterViewInit(): void {
    super.ngAfterViewInit();
  }

  onEditClick(timeSlot) {
    this.onEdit.emit(timeSlot);
  }

  onAddClick() {
    this.onAddNew.emit();
  }
}
