import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SessionpageComponent } from './sessionpage.component';

describe('SessionpageComponent', () => {
  let component: SessionpageComponent;
  let fixture: ComponentFixture<SessionpageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SessionpageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SessionpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
