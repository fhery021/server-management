import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Server} from "../model/server";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ServerService {
  readonly url;

  constructor(private http:HttpClient) {
    this.url = 'http://localhost:8080/api/servers';
  }

  public findAll(): Observable<Server[]>{
    return this.http.get<Server[]>(this.url);
  }

  public save(server: Server){
    return this.http.post<Server>(this.url,server);
  }

  //TODO delete, update, getById
}
