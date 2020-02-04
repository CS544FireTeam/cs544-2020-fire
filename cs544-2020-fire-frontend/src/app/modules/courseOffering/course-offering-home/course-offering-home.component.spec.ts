import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseOfferingHomeComponent } from './course-offering-home.component';

describe('CourseofferingpageComponent', () => {
  let component: CourseOfferingHomeComponent;
  let fixture: ComponentFixture<CourseOfferingHomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CourseOfferingHomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CourseOfferingHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
