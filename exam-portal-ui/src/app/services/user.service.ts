import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private readonly apiUrl = 'http://localhost:8088/api/v1/user';

  constructor(private http: HttpClient) { }

  public register(user:any){
    return this.http.post(`${this.apiUrl}`, user);
  }
}
