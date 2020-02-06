import {AfterViewInit, Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {PagingBaseComponent} from "../../shared/components/paging-base.component";
import {Course, Location} from "../../../domain/models";

@Component({
  selector: 'fire-location-list',
  templateUrl: './location-list.component.html',
  styleUrls: ['./location-list.component.less']
})
export class LocationListComponent extends PagingBaseComponent<Location> implements OnInit, AfterViewInit {

  @Input() set locations(locations: Course[]) {
    this._locations = locations;
    super.ngOnInit(locations);
  }
  @Input() isAdmin: false;
  @Output() onEdit: EventEmitter<Location> = new EventEmitter();
  @Output() onAddNew: EventEmitter<Location> = new EventEmitter();

  _locations: Location[];

  constructor() {
    super(['description', 'actionButton']);
  }

  get locations() {
    return this._locations;
  }

  ngOnInit() {
    super.ngOnInit(this.locations);
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
