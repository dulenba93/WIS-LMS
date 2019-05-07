import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';
import { Subject } from './subject';

@Injectable({
  providedIn: 'root'
})
export class SubjectService {

  private subjectUrl = "http://localhost:3000/subjects/"

  constructor(
    private http: HttpClient
    ) { }

  getSubjects(): Observable<Subject[]>{
    return this.http.get<Subject[]>(this.subjectUrl);
  }

  getSubject(id: number): Observable<Subject>{
    return this.http.get<Subject>(this.subjectUrl + id)
  }
}
