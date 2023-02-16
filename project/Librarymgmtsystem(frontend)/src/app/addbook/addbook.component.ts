import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Bookclass } from 'model/bookclass';
import { BookServiceService } from 'service/book-service.service';

@Component({
  selector: 'app-addbook',
  templateUrl: './addbook.component.html',
  styleUrls: ['./addbook.component.css']
})
export class AddbookComponent {
     book:Bookclass;
constructor(private router:Router,private route:ActivatedRoute,private bookService:BookServiceService)
{
  this.book=new Bookclass();
}
onSubmit()
{
  this.bookService['save'](this.book).subscribe((result:any)=>this.book=result);
}
}
