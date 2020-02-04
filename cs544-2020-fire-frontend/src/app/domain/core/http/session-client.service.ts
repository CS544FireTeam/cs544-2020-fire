import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Session} from "../../models";

@Injectable({
  providedIn: "root",
})

export class SessionClientService {
  private API_BASE = 'http://localhost:8000/';
  private SESSION_API = 'sessions';

  constructor(private http: HttpClient) {
  }

  private get url(): string {
    return `${this.API_BASE}/${this.SESSION_API}`;
  }

  getAllSessions$(): Observable<Session[]> {
    return this.http.get<Session[]>(`${this.url}`);
  }

  getSession$(sessionId: number): Observable<Session> {
    return this.http.get<Session>(`${this.url}/${sessionId}`);
  }

  addSession$(session: Session): Observable<Session> {
    return this.http.post<Session>(`${this.url}`, session);
  }

  modifySession$(session: Session): Observable<Session> {
    return this.http.put<Session>(`${this.url}/${session.id}`, session);
  }

  deleteSession$(sessionID: number): Observable<any> {
    return this.http.delete<any>(`${this.url}/${sessionID}`);
  }

}
