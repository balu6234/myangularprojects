import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Studentclass } from 'model/studentclass';
import { StudentServiceService } from 'service/student-service.service';

@Component({
  selector: 'app-updatestudent',
  templateUrl: './updatestudent.component.html',
  styleUrls: ['./updatestudent.component.css']
})
export class UpdatestudentComponent implements  OnInit {
  id!:number;
  student!:Studentclass;
  constructor(private route:ActivatedRoute, private router:Router, private studentservice:StudentServiceService){}
  ngOnInit() {
    this.student= new Studentclass();
    this.id = this.route.snapshot.params['id'];
    this.studentservice.getStudents(this.id).subscribe(data=>{
      this.student = data;
      console.log(data)
    });
  }
  onSubmit()
  {
    this.studentservice.updateStudent( this.id, this.student).subscribe((result:any)=>this.student=result);
  }
  gotoBookList()
  {
    this.router.navigate(['getstudents'])
  }
}