import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Studentclass } from 'model/studentclass';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentServiceService {
  private addStudentUrl:string;
  private putStudentUrl:string;
  private getStudentsUrl:string;
  private deleteStudentUrl:string;
  private getbyIdUrl:string;

  constructor(private http:HttpClient) {
     this.addStudentUrl="http://localhost:8080/student";
     this.putStudentUrl="http://localhost:8080/student/update";
     this.getStudentsUrl="http://localhost:8080/getstudents";
     this.deleteStudentUrl="http://localhost:8080/student/delete";
     this.getbyIdUrl="http://localhost:8080/students";
   }
   getstudentList(): Observable<Studentclass[]>{
    return this.http.get<Studentclass[]>(this.getStudentsUrl);
   }
   public save(student:Studentclass)
   {
     return this.http.post<Studentclass>(this.addStudentUrl,student);
   }
   public getAll():Observable<Studentclass[]>
   {
    return this.http.get<Studentclass[]>(this.getStudentsUrl);
   }
  public updateStudent(id:number,student:Studentclass):Observable<object>{
    return this.http.put<Studentclass>(`${this.putStudentUrl}/${id}`,student);
   }
   public deleteStudent(id:number):Observable<any>{
    return this.http.delete(`${this.deleteStudentUrl}/${id}`);
   }
   getStudents(id: number): Observable<Studentclass> {
    return this.http.get<Studentclass>(`${this.getbyIdUrl}/${id}`);
   }
}
