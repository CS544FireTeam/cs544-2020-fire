import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FireserviceService } from 'src/app/domain/services/testservice/fireservice.service';
import { User } from 'src/app/domain/models';

@Component({
  selector: 'fire-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomepageComponent implements OnInit {
  loginFormGroup:FormGroup;
  // fireForm = {
  //   email: "",
  //   password: ""
  // };
 user:User;
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
      this.firstLoginAttempt(localStorage.getItem('email'),localStorage.getItem('password'))
      return;
    }
    console.log("Not Logged in")
  }

  private firstLoginAttempt(username:String , password: String){
    this.fireService.firstLoginAttempt(username,password).subscribe(
      res => {
        this.fireService.user =res.user;
      }
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
          this.fireService.user =res.user;
        }else{
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
