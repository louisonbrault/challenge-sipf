import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifiedMessageComponent } from './modified-message.component';

describe('ModifiedMessageComponent', () => {
  let component: ModifiedMessageComponent;
  let fixture: ComponentFixture<ModifiedMessageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModifiedMessageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModifiedMessageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
