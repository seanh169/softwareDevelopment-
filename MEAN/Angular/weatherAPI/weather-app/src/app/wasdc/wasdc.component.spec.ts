import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WasdcComponent } from './wasdc.component';

describe('WasdcComponent', () => {
  let component: WasdcComponent;
  let fixture: ComponentFixture<WasdcComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WasdcComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WasdcComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
