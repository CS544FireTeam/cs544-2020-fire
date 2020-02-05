import { Component, OnInit } from '@angular/core';
import {TimeSlot} from "../../../domain/models";
import {FireserviceService} from "../../../domain/services/testservice/fireservice.service";
import {TimeSlotClientService} from "../../../domain/core/http";

@Component({
  selector: 'fire-time-slot-home',
  templateUrl: './time-slot-home.component.html',
  styleUrls: ['./time-slot-home.component.less']
})
export class TimeSlotHomeComponent implements OnInit {

  DEFAULT_EMPTY_TIMESLOT: TimeSlot = {
    id: undefined,
    description: '',
    beginTime:'',
    endTime: '',
  };

  selectedTab = 0;

  currentTimeSlot: TimeSlot;
  timeSlots: TimeSlot[];

  constructor(private fireService: FireserviceService,
              private timeSlotClientService: TimeSlotClientService) {
  }

  ngOnInit() {
    this.loadListTimeSlot();
  }

  onEditTimeSlot(timeSlot: TimeSlot) {
    this.currentTimeSlot = timeSlot;
    this.selectedTab = 1;
  }

  onAddTimeSlot() {
    this.currentTimeSlot = {
      ...this.DEFAULT_EMPTY_TIMESLOT,
    };
    this.selectedTab = 1;
  }

  saveTimeSlot(TimeSlot: TimeSlot) {
    this.timeSlotClientService.addTimeSlot$(TimeSlot).subscribe(TimeSlot => {
      console.log(TimeSlot);
      this.selectListTimeSlot();
    })
  }

  deleteTimeSlot(TimeSlot: TimeSlot) {
    this.timeSlotClientService.deleteTimeSlot$(TimeSlot.id).subscribe(() => {
      this.selectListTimeSlot();
    });
  }

  updateTimeSlot(TimeSlot: TimeSlot) {
    this.timeSlotClientService.modifyTimeSlot$(TimeSlot).subscribe(() => {
      this.selectListTimeSlot();
    });
  }

  selectListTimeSlot() {
    this.currentTimeSlot = {
      ...this.DEFAULT_EMPTY_TIMESLOT,
    };
    this.loadListTimeSlot();
  }

  private loadListTimeSlot() {
    this.timeSlotClientService.getAllTimeSlots$().subscribe(TimeSlots => {
      this.timeSlots = TimeSlots;
      this.selectedTab = 0;
    })
  }
}
