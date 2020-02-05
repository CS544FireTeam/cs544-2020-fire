import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../../models";

@Injectable({
  providedIn: "root",
})

export class UserClientService {
  private API_BASE = 'http://localhost:8080';
  private USER_API = 'users';

  constructor(private http: HttpClient) {
  }

  private get url(): string {
    return `${this.API_BASE}/${this.USER_API}`;
  }

  getAllUsers$(): Observable<User[]> {
    return this.http.get<User[]>(`${this.url}`);
  }

  getUser$(userId: number): Observable<User> {
    return this.http.get<User>(`${this.url}/${userId}`);
  }

  addUser$(user: User): Observable<User> {
    return this.http.post<User>(`${this.url}`, user);
  }

  modifyUser$(user: User): Observable<User> {
    console.log(user);
    return this.http.put<User>(`${this.url}/${user.id}`, user);
  }

  deleteUser$(userId: number): Observable<any> {
    return this.http.delete<any>(`${this.url}/${userId}`);
  }

}
