import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AutoContactUsComponent } from './auto-contact-us.component';

describe('AutoContactUsComponent', () => {
  let component: AutoContactUsComponent;
  let fixture: ComponentFixture<AutoContactUsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AutoContactUsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AutoContactUsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
