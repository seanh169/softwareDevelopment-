import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AutoReviewsComponent } from './auto-reviews.component';

describe('AutoReviewsComponent', () => {
  let component: AutoReviewsComponent;
  let fixture: ComponentFixture<AutoReviewsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AutoReviewsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AutoReviewsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
