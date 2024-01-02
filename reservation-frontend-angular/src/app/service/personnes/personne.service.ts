import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PersonneService {

  constructor(private http: HttpClient) { }

  public findAllPersonne() : Observable<any>{
    return  this.http.get("http://localhost:9999/reservation-service/personnes");
  }

  public findPersonneById(id: number) : Observable<any>{
    return  this.http.get(`http://localhost:9999/reservation-service/personnes/${id}`);
  }

  public deletePersonne(id:number):Observable<any>{
    return this.http.delete(`http://localhost:9999/reservation-service/personnes/${id}`);
  }
}
