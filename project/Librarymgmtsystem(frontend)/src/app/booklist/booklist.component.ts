import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Bookclass } from 'model/bookclass';
import { Observable } from 'rxjs';
import { BookServiceService } from 'service/book-service.service';

@Component({
  selector: 'app-booklist',
  templateUrl: './booklist.component.html',
  styleUrls: ['./booklist.component.css']
})
export class BooklistComponent implements OnInit {
  book:any;
  constructor(private bookservice:BookServiceService, private router:Router, ){}
  ngOnInit() {
      this.bookservice.getBookList().subscribe(data=>{this.book= data;});
  }
  updateBook(id:number)
  {
    this.router.navigate(['updatebook',id]);
  }
  deleteBook(id:number){
    this.bookservice.deleteBook(id).subscribe(data=>{console.log(data);
      this.ngOnInit();

    })
  }

  
  }   
   

    

