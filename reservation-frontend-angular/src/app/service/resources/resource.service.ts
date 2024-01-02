import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ResourceService {

    constructor(private http: HttpClient) { }

  public findAllResource() : Observable<any>{
    return  this.http.get("http://localhost:9999/ressource-service/resources");
  }

  public deleteResource(id:number):Observable<any>{
    return this.http.delete(`http://localhost:9999/ressource-service/resources/${id}`);
  }
}
