import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AutoTeamComponent } from './auto-team.component';

describe('AutoTeamComponent', () => {
  let component: AutoTeamComponent;
  let fixture: ComponentFixture<AutoTeamComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AutoTeamComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AutoTeamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
