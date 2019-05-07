import { TestBed } from '@angular/core/testing';

import { NavItemService } from './nav-item.service';

describe('NavItemService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: NavItemService = TestBed.get(NavItemService);
    expect(service).toBeTruthy();
  });
});
