import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {TimeSlot} from "../../models";

@Injectable({
  providedIn: "root",
})

export class TimeSlotClientService {
  private API_BASE = '/api/';
  private TIME_SLOT_API = 'time-slots';

  constructor(private http: HttpClient) {
  }

  private get url(): string {
    return `${this.API_BASE}/${this.TIME_SLOT_API}`;
  }

  getAllTimeSlots$(): Observable<TimeSlot[]> {
    return this.http.get<TimeSlot[]>(`${this.url}`);
  }

  getTimeSlot$(timeSlotId: number): Observable<TimeSlot> {
    return this.http.get<TimeSlot>(`${this.url}/${timeSlotId}`);
  }

  addTimeSlot$(timeSlot: TimeSlot): Observable<TimeSlot> {
    return this.http.post<TimeSlot>(`${this.url}`, timeSlot);
  }

  modifyTimeSlot$(timeSlot: TimeSlot): Observable<TimeSlot> {
    return this.http.put<TimeSlot>(`${this.url}/${timeSlot.id}`, timeSlot);
  }

  deleteTimeSlot$(timeSlotId: number): Observable<any> {
    return this.http.delete<any>(`${this.url}/${timeSlotId}`);
  }

}
