import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Student, StudentSearchResult, StudentSearchCriteria} from "../../models";

@Injectable({
  providedIn: "root",
})

export class StudentClientService {
  private API_BASE = '/api/';
  private STUDENT_API = 'students';

  constructor(private http: HttpClient) {
  }

  private get url(): string {
    return `${this.API_BASE}/${this.STUDENT_API}`;
  }

  getAllStudents$(): Observable<Student[]> {
    return this.http.get<Student[]>(`${this.url}`);
  }

  searchStudent(studentSearchCriteria: StudentSearchCriteria){
    return this.http.post<StudentSearchResult[]>(`${this.url}/search`,studentSearchCriteria );
  }

  getStudent$(studentId: number): Observable<Student> {
    return this.http.get<Student>(`${this.url}/${studentId}`);
  }

  addStudent$(student: Student): Observable<Student> {
    return this.http.post<Student>(`${this.url}`, student);
  }

  modifyStudent$(student: Student): Observable<Student> {
    return this.http.put<Student>(`${this.url}/${student.id}`, student);
  }

  deleteStudent$(studentId: number): Observable<any> {
    return this.http.delete<any>(`${this.url}/${studentId}`);
  }

}
