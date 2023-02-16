import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Studentclass } from 'model/studentclass';
import { StudentServiceService } from 'service/student-service.service';

@Component({
  selector: 'app-addstudent',
  templateUrl: './addstudent.component.html',
  styleUrls: ['./addstudent.component.css']
})
export class AddstudentComponent {
      student:Studentclass;

  constructor(private router:Router,private route:ActivatedRoute,private studentservice:StudentServiceService)
  {
    this.student=new Studentclass();
  }
  onSubmit()
  {
    this.studentservice['save'](this.student).subscribe((result:any)=>this.student=result);
  }
}
