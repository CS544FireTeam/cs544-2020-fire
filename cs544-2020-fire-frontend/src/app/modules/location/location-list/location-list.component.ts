import {AfterViewInit, Component, EventEmitter, OnInit, Output} from '@angular/core';
import CheckedItem from "../../shared/models/checked-item.model";
import {PagingBaseComponent} from "../../shared/components/paging-base.component";
import {Location} from "../../../domain/models";

interface LocationItem extends CheckedItem, Location {
}

@Component({
  selector: 'fire-location-list',
  templateUrl: './location-list.component.html',
  styleUrls: ['./location-list.component.less']
})
export class LocationListComponent extends PagingBaseComponent<LocationItem> implements OnInit, AfterViewInit {

  //TODO will be integrate with BK
  mockData: LocationItem[] = [
    {
      id: 1,
      description: 'Argiro Student Center',
      isChecked: false,

    },
    {
      id: 2,
      description: 'Autopia',
      isChecked: false,

    },
    {
      id: 3,
      description: 'Dorm',
      isChecked: false,

    },
    {
      id: 4,
      description: 'Argiro Student Center',
      isChecked: false,

    },
    {
      id: 5,
      description: 'Autopia',
      isChecked: false,

    },
    {
      id: 6,
      description: 'Dorm',
      isChecked: false,

    },
    {
      id: 7,
      description: 'Argiro Student Center',
      isChecked: false,

    },
    {
      id: 8,
      description: 'Autopia',
      isChecked: false,

    },
    {
      id: 9,
      description: 'Dorm',
      isChecked: false,

    },
    {
      id: 10,
      description: 'Dorm',
      isChecked: false,

    }
  ];

  @Output() onEdit: EventEmitter<Location> = new EventEmitter();
  @Output() onAddNew: EventEmitter<Location> = new EventEmitter();

  constructor() {
    super(['description','actionButton']);
  }

  ngOnInit() {
    super.ngOnInit(this.mockData);
  }

  ngAfterViewInit(): void {
    super.ngAfterViewInit();
  }

  onEditClick(location) {
    this.onEdit.emit(location);
  }

  onAddClick() {
    this.onAddNew.emit();
  }
}
