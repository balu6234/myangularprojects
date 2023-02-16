import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {  Observable } from 'rxjs';
import { Bookclass } from 'model/bookclass';
import { BooklistComponent } from 'src/app/booklist/booklist.component';
@Injectable({
  providedIn: 'root'
})
export class BookServiceService {
  private addUrl:string;
 private putUrl: string;
  private getUrl: string;
 private deleteUrl: string;
 private getbyIdUrl: string

  constructor(private http:HttpClient) {
    this.addUrl="http://localhost:8080/book";
    this.putUrl="http://localhost:8080/book/update";
    this.deleteUrl="http://localhost:8080/delete";
    this.getUrl="http://localhost:8080/getbooks";
    this.getbyIdUrl="http://localhost:8080/books"
   }
  
   getBooks(id:number): Observable<any>{
    return this.http.get<Bookclass>(`${this.getbyIdUrl}/${id}`);
   }

   public save(book:Bookclass)
   {
     return this.http.post<Bookclass>(this.addUrl,book);
   }
   public findAll():Observable<Bookclass[]>
   {
    return this.http.get<Bookclass[]>(this.getUrl);
   }
   public updateBook(id:number, book:Bookclass):Observable<Object>{
    return this.http.put<Bookclass>(`${this.putUrl}/${id}`,book)
   }
   public deleteBook(id:number):Observable<any>{
    return this.http.delete<Bookclass>(`${this.deleteUrl}/${id}`);
   }
  public getBookList(): Observable<Bookclass[]> {
    return this.http.get<Bookclass[]>(this.getUrl);
   }
}
