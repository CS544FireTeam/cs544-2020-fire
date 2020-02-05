import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Location} from "../../../domain/models";
import {FormBuilder, FormGroup, ValidationErrors, ValidatorFn, Validators} from "@angular/forms";

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

  @Input() set locations(locations: Location[]) {
    this._locations = locations;
  }

  @Output() onUpdate: EventEmitter<Location> = new EventEmitter();
  @Output() onAdd: EventEmitter<Location> = new EventEmitter();
  @Output() onDelete: EventEmitter<Location> = new EventEmitter();

  formGroup: FormGroup;
  private _locations: Location[];
  private _location: Location;

  constructor(private formBuilder: FormBuilder) {
  }

  get location(): Location {
    return this._location;
  }

  get locations() {
    return this._locations;
  }

  ngOnInit() {
    this.formGroup = this.formBuilder.group({
      id: [''],
      description: ['', Validators.required],
    },  { validators: this.checkDuplicate });
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

  checkDuplicate: ValidatorFn = (control: FormGroup): ValidationErrors | null => {
    if (this._locations) {
      const description: string = control.controls.description.value;
      const id = control.controls.id.value;
      if (this.locations.filter(location => location.description.toUpperCase() === description.toUpperCase() && id != location.id).length > 0) {
        return {duplicateLocation: true};
      }
    }
    return null;
  };
}
