import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AutoAboutComponent } from './auto-about.component';

describe('AutoAboutComponent', () => {
  let component: AutoAboutComponent;
  let fixture: ComponentFixture<AutoAboutComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AutoAboutComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AutoAboutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
