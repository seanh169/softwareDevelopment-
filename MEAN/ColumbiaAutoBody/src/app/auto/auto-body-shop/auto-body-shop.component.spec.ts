import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AutoBodyShopComponent } from './auto-body-shop.component';

describe('AutoBodyShopComponent', () => {
  let component: AutoBodyShopComponent;
  let fixture: ComponentFixture<AutoBodyShopComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AutoBodyShopComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AutoBodyShopComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
