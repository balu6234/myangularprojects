import { Component, OnInit } from '@angular/core';
import { User } from 'model/user';
import { UserService } from 'service/user.service';

@Component({
  selector: 'app-userlist',
  templateUrl: './userlist.component.html',
  styleUrls: ['./userlist.component.css']
})
export class UserlistComponent implements OnInit {
    user:any;
  
    constructor(private userservice: UserService) {
    }
  
    ngOnInit() {
      this.userservice.findAll().subscribe(data=>{
        this.user=data;
      });
}

}
