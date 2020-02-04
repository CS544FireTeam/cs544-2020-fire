import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LocationpageComponent } from './locationpage.component';

describe('LocationpageComponent', () => {
  let component: LocationpageComponent;
  let fixture: ComponentFixture<LocationpageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LocationpageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LocationpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
