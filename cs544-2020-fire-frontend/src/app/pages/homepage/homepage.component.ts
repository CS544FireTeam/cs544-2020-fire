import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FireserviceService } from 'src/app/services/testservice/fireservice.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.scss']
})
export class HomepageComponent implements OnInit {
  loginFormGroup:FormGroup;
  fireForm = {
    email: "",
    password: ""
  };

  isLogin:Boolean = true;
  constructor(private formBuilder: FormBuilder,private router: Router,private fireService:FireserviceService) { 
    this.loginFormGroup = this.formBuilder.group({
      email : new FormControl(
        '',
        Validators.compose([
          Validators.required,
          Validators.pattern('^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$'),
        ])
      ),
      password : new FormControl(
        '',
        Validators.compose([
          Validators.required,
          Validators.minLength(4)
        ])
      ),
    });
  }

  ngOnInit() {
    this.checkToken();
  }


  private checkToken(){
    if(localStorage.getItem('token')!=null){
      let username : String  = localStorage.getItem('email');
      let password : String  = localStorage.getItem('password');
      this.firstLoginAttempt(username,password)
      return;
    }
    console.log("Not Logged in")
  }

  private firstLoginAttempt(username:String , password: String){
    this.fireService.firstLoginAttempt(username,password).subscribe(
      res => {}
    );
  }

  toggle(){
    this.isLogin = !this.isLogin;
  }

  public login (details) {
    this.fireService.firstLoginAttempt(details.email,details.password).subscribe(
      res => {
        if(res.token!=null){
          localStorage.setItem("token",res.token);
          localStorage.setItem("email",details.email.toString());
          localStorage.setItem("password",details.password.toString());
        }else{
          // this.showErr = true;
        }
        
      }
    )
  }


  createAccount(details){
    this.fireService.createAccount(details.email,details.password).subscribe(
      res => {
        localStorage.setItem("email",details.email.toString());
        localStorage.setItem("password",details.password.toString());
        localStorage.setItem("id",res.id);
        this.login(details);
      }
    );
  }

}
