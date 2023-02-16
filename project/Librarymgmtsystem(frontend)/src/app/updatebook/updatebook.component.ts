import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Bookclass } from 'model/bookclass';
import { BookServiceService } from 'service/book-service.service';

@Component({
  selector: 'app-updatebook',
  templateUrl: './updatebook.component.html',
  styleUrls: ['./updatebook.component.css']
})
export class UpdatebookComponent implements OnInit {
  id!:number;
  book!:Bookclass;
  constructor(private route:ActivatedRoute, private router:Router, private bookservice:BookServiceService){}
  ngOnInit() {
    this.book = new Bookclass();
    this.id = this.route.snapshot.params['id'];
    this.bookservice.getBooks(this.id).subscribe(data=>{
      this.book = data;
      console.log(data)
    });
  }
    onSubmit()
  {
    this.bookservice.updateBook( this.id, this.book).subscribe((result:any)=>this.book=result);
  }
  gotoBookList()
  {
    this.router.navigate(['getbooks'])
  }
}