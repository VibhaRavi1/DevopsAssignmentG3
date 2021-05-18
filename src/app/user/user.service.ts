
import { Injectable } from "@angular/core";
import { UserDetails } from "./user.model";
import { Observable, of } from "rxjs";
import { HttpClient } from "@angular/common/http";
import { map } from "rxjs/operators";

@Injectable({
  providedIn: "root",
})
export class UserService {
    baseUrl = "http://localhost:8080/api/v1";

    constructor(private http: HttpClient) {}
  
    getUser(){
        return this.http.get('http://localhost:8080/api/v1/user');
    }
    
}
