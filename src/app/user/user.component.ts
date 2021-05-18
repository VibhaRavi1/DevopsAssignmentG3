import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserDetails } from './user.model';
import { UserService } from './user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor(private userService : UserService, private router : Router) { }
  public result: any;

  ngOnInit(): void {
    // const result = this.userService.getUser();
    this.userService.getUser()
      .subscribe(
        user => {
          this.result = user;
          // console.log(user);
        }
      )

      console.log(this.result);
  }

  onLogout() : void {
    this.router.navigate(["login"]);
  }

}