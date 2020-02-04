import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Attendance, AttendanceSearchCriteria} from "../../models";

@Injectable({
  providedIn: "root",
})

export class AttendanceClientService {
  private API_BASE = '/api/';
  private ATTENDANCE_API = 'attendances';

  constructor(private http: HttpClient) {
  }

  private get url(): string {
    return `${this.API_BASE}/${this.ATTENDANCE_API}`;
  }

  searchAttendance$(attendanceSearchCriteria: AttendanceSearchCriteria): Observable<Attendance[]> {
    return this.http.post<Attendance[]>(`${this.url}/`, attendanceSearchCriteria);
  }

  addAttendance$(attendance: Attendance): Observable<Attendance> {
    return this.http.post<Attendance>(`${this.url}`, attendance);
  }

}
