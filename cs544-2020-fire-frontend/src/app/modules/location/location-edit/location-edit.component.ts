import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Location} from "../../../domain/models";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'fire-location-edit',
  templateUrl: './location-edit.component.html',
  styleUrls: ['./location-edit.component.less']
})
export class LocationEditComponent implements OnInit {

  @Input()
  set location(location: Location) {
    this._location = location;
    this.loadData(this.location);
  }

  @Output() onUpdate: EventEmitter<Location> = new EventEmitter();
  @Output() onAdd: EventEmitter<Location> = new EventEmitter();
  @Output() onDelete: EventEmitter<Location> = new EventEmitter();

  formGroup: FormGroup;

  private _location: Location;

  constructor(private formBuilder: FormBuilder) {
  }

  get location(): Location {
    return this._location;
  }

  ngOnInit() {
    this.formGroup = this.formBuilder.group({
      id: [''],
      description: ['', Validators.required],
    });
  }

  loadData(location: Location) {
    if (location) {
      this.formGroup.patchValue(location);
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
