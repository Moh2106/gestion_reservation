import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  constructor(private http: HttpClient) { }

  public findAllReservation() : Observable<any>{
    return  this.http.get("http://localhost:9999/reservation-service/reservations");
  }

  public deleteReservation(id:number):Observable<any>{
    return this.http.delete(`http://localhost:9999/reservation-service/reservations/${id}`);
  }
}
