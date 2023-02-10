import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from 'model/user';
import { Observable } from 'rxjs';

@Injectable({
providedIn: 'root'
})
export class UserService {

  private getUrl:string;
  private addUrl:string;

  constructor(private http:HttpClient) { 

    this.getUrl="http://localhost:8080/getuser";
    this.addUrl="http://localhost:8080/user";

  }
  public save(user:User)
  {
    return this.http.post<User>(this.addUrl,user);
  }
  public findAll():Observable<User[]>
  {
    return this.http.get<User[]>(this.getUrl);
  }
}


