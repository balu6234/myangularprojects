import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Studentclass } from 'model/studentclass';
import { Observable } from 'rxjs';
import { StudentServiceService } from 'service/student-service.service';
import { UpdatestudentComponent } from '../updatestudent/updatestudent.component';

@Component({
  selector: 'app-studentlist',
  templateUrl: './studentlist.component.html',
  styleUrls: ['./studentlist.component.css']
})
export class StudentlistComponent implements OnInit {
  student:any;
  constructor(private studentservice:StudentServiceService, private router:Router, ){}
  ngOnInit() {
      this.studentservice.getstudentList().subscribe(data=>{this.student= data;});
  }
  updateStudent(id:number)
  {
    this.router.navigate(['updatestudent',id]);
  }
  deleteStudent(id:number){
    this.studentservice.deleteStudent(id).subscribe(data=>{console.log(data);
      this.ngOnInit();

    })
  }
  
}

