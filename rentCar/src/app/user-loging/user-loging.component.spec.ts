import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserLogingComponent } from './user-loging.component';

describe('UserLogingComponent', () => {
  let component: UserLogingComponent;
  let fixture: ComponentFixture<UserLogingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserLogingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserLogingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
