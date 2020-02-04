import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseofferingpageComponent } from './courseofferingpage.component';

describe('CourseofferingpageComponent', () => {
  let component: CourseofferingpageComponent;
  let fixture: ComponentFixture<CourseofferingpageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CourseofferingpageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CourseofferingpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
