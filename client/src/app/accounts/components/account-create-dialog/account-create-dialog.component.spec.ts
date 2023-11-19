import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AccountCreateDialogComponent } from './account-create-dialog.component';

describe('AccountCreateDialogComponent', () => {
  let component: AccountCreateDialogComponent;
  let fixture: ComponentFixture<AccountCreateDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AccountCreateDialogComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(AccountCreateDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
