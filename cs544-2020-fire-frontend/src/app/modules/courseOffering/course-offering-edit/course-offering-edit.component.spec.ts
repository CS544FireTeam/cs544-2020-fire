import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseOfferingEditComponent } from './course-offering-edit.component';

describe('CourseOfferingEditComponent', () => {
  let component: CourseOfferingEditComponent;
  let fixture: ComponentFixture<CourseOfferingEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CourseOfferingEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CourseOfferingEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
