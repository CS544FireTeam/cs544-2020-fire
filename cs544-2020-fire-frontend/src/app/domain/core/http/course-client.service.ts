import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Course} from "../../models";

@Injectable({
  providedIn: "root",
})

export class CourseClientService {
  private API_BASE = '/api/';
  private COURSE_API = 'courses';

  constructor(private http: HttpClient) {
  }

  private get url(): string {
    return `${this.API_BASE}${this.COURSE_API}`;
  }

  getAllCourses$(): Observable<Course[]> {
    return this.http.get<Course[]>(`${this.url}`);
  }

  getCourse$(courseId: number): Observable<Course> {
    return this.http.get<Course>(`${this.url}/${courseId}`);
  }

  addCourse$(course: Course): Observable<Course> {
    return this.http.post<Course>(`${this.url}`, course);
  }

  modifyCourse$(course: Course): Observable<Course> {
    return this.http.put<Course>(`${this.url}/${course.id}`, course);
  }

  deleteCourse$(courseId: number): Observable<any> {
    return this.http.delete<any>(`${this.url}/${courseId}`);
  }

}
