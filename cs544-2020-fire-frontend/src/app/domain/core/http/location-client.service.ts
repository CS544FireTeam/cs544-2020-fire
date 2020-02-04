import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Location} from "../../models";

@Injectable({
  providedIn: "root",
})

export class LocationClientService {
  private API_BASE = 'http://localhost:8000/';
  private USER_API = 'locations';

  constructor(private http: HttpClient) {
  }

  private get url(): string {
    return `${this.API_BASE}/${this.USER_API}`;
  }

  getAllLocations$(): Observable<Location[]> {
    return this.http.get<Location[]>(`${this.url}`);
  }

  getLocation$(locationId: number): Observable<Location> {
    return this.http.get<Location>(`${this.url}/${locationId}`);
  }

  addLocation$(location: Location): Observable<Location> {
    return this.http.post<Location>(`${this.url}`, location);
  }

  modifyLocation$(location: Location): Observable<Location> {
    return this.http.put<Location>(`${this.url}/${location.id}`, location);
  }

  deleteLocation$(locationId: number): Observable<any> {
    return this.http.delete<any>(`${this.url}/${locationId}`);
  }

}
