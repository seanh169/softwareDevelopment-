import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AutoHomeComponent } from './auto-home.component';

describe('AutoHomeComponent', () => {
  let component: AutoHomeComponent;
  let fixture: ComponentFixture<AutoHomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AutoHomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AutoHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
