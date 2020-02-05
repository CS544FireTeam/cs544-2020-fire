import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CourseOffering} from "../../models";

@Injectable({
  providedIn: "root",
})

export class CourseOfferingClientService {
  private API_BASE = '/api/';
  private COURSE_OFFERING_API = 'course-offerings';

  constructor(private http: HttpClient) {
  }

  private get url(): string {
    return `${this.API_BASE}${this.COURSE_OFFERING_API}`;
  }

  getAllCourseOfferings$(): Observable<CourseOffering[]> {
    return this.http.get<CourseOffering[]>(`${this.url}`);
  }

  getCourseOffering$(courseOfferingId: number): Observable<CourseOffering> {
    return this.http.get<CourseOffering>(`${this.url}/${courseOfferingId}`);
  }

  addCourseOffering$(courseOffering: CourseOffering): Observable<CourseOffering> {
    return this.http.post<CourseOffering>(`${this.url}`, courseOffering);
  }

  modifyCourseOffering$(courseOffering: CourseOffering): Observable<CourseOffering> {
    return this.http.put<CourseOffering>(`${this.url}/${courseOffering.id}`, courseOffering);
  }

  deleteCourseOffering$(courseOfferingId: number): Observable<any> {
    return this.http.delete<any>(`${this.url}/${courseOfferingId}`);
  }

}
