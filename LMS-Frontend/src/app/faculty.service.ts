import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';
import { Faculty } from './faculty';

@Injectable({
  providedIn: 'root'
})
export class FacultyService {

  private facultyUrl = "http://localhost:3000/faculties/"

  constructor(
    private http: HttpClient
  ) { }

  getFaculties(): Observable<Faculty[]>{
    return this.http.get<Faculty[]>(this.facultyUrl);
  }
}
