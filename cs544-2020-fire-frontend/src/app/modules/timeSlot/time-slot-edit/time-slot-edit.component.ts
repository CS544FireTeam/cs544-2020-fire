import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {TimeSlot} from "../../../domain/models";
import {FormBuilder, FormGroup, ValidationErrors, ValidatorFn, Validators} from "@angular/forms";
import * as moment from "moment";

@Component({
  selector: 'fire-time-slot-edit',
  templateUrl: './time-slot-edit.component.html',
  styleUrls: ['./time-slot-edit.component.less']
})
export class TimeSlotEditComponent implements OnInit {

  @Input()
  set timeSlot(timeSlot: TimeSlot) {
    this._timeSlot = timeSlot;
    this.loadData(this.timeSlot);
  }

  @Input() set timeSlots(timeSlots: TimeSlot[]) {
    this._timeSlots = timeSlots;
  }

  @Output() onUpdate: EventEmitter<TimeSlot> = new EventEmitter();
  @Output() onAdd: EventEmitter<TimeSlot> = new EventEmitter();
  @Output() onDelete: EventEmitter<TimeSlot> = new EventEmitter();

  formGroup: FormGroup;
  private _timeSlots: TimeSlot[];
  private _timeSlot: TimeSlot;

  constructor(private formBuilder: FormBuilder) {
  }

  get timeSlot(): TimeSlot {
    return this._timeSlot;
  }

  get timeSlots() {
    return this._timeSlots;
  }

  ngOnInit() {
    this.formGroup = this.formBuilder.group({
      id: [''],
      description: ['', Validators.required],
      beginTime: ['', Validators.required],
      endTime: ['', Validators.required],
    },  { validators: this.checkDuplicate });
  }

  loadData(TimeSlot: TimeSlot) {
    if (TimeSlot) {
      this.formGroup.patchValue(TimeSlot);
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

  checkDuplicate: ValidatorFn = (control: FormGroup): ValidationErrors | null => {
    const beginTime: string = control.controls.beginTime.value;
    const endTime: string = control.controls.endTime.value;
    if (this._timeSlots) {
      const id = control.controls.id.value;
      if (this.timeSlots.filter(timeSlot =>
        timeSlot.beginTime.toUpperCase() === beginTime.toUpperCase()
        && timeSlot.endTime.toUpperCase() === endTime.toUpperCase()
        && id !== timeSlot.id).length > 0) {
        return {duplicateTimeSlot: true};
      }
    }

    var _startTime = moment(beginTime, "HH:mm");
    var _endTime = moment(endTime, "HH:mm");
    if(_startTime.isAfter(_endTime)) {
      return {invalidTime: true};
    }
    return null;
  };
}
