import { Component, OnInit } from '@angular/core';
import { User } from '../user'
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms'
import { AdminService } from '../admin-service/admin.service';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  user = new User();  

  registerForm: FormGroup;

  constructor(private adminService:AdminService ) { }

  ngOnInit() {

  }

  addNewUser() {

    this.adminService.addNewUser(this.user).subscribe(
      res=>{
        location.reload();
      },
      err =>{
        alert("desila se neka greska");
      }

    );
  }

}
