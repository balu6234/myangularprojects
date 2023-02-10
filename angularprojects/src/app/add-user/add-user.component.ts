import { Component} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'model/user';
import { UserService } from 'service/user.service';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent {
  user:User;
  constructor(private router:Router,private route:ActivatedRoute,private userService:UserService)
  {
    this.user=new User();
  }
  onSubmit()
  {
    this.userService['save'](this.user).subscribe((result:any)=>this.user=result);
  }

}
