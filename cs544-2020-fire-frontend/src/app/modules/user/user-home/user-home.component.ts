import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { FireserviceService } from 'src/app/domain/services/testservice/fireservice.service';
import { UserClientService } from 'src/app/domain/core/http/user-client.service';
import User from 'src/app/domain/models/user.model';
import { Observable } from 'rxjs';
import { UserRoleEnum, Student } from 'src/app/domain';
import { FormGroup, Validators, FormControl, FormBuilder } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';
import { StudentClientService } from 'src/app/domain/core/http/student-client.service';

export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}

const ELEMENT_DATA: PeriodicElement[] = [
  {position: 1, name: 'Hydrogen', weight: 1.0079, symbol: 'H'},
  {position: 2, name: 'Helium', weight: 4.0026, symbol: 'He'},
  {position: 3, name: 'Lithium', weight: 6.941, symbol: 'Li'},
  {position: 4, name: 'Beryllium', weight: 9.0122, symbol: 'Be'},
  {position: 5, name: 'Boron', weight: 10.811, symbol: 'B'},
  {position: 6, name: 'Carbon', weight: 12.0107, symbol: 'C'},
  {position: 7, name: 'Nitrogen', weight: 14.0067, symbol: 'N'},
  {position: 8, name: 'Oxygen', weight: 15.9994, symbol: 'O'},
  {position: 9, name: 'Fluorine', weight: 18.9984, symbol: 'F'},
  {position: 10, name: 'Neon', weight: 20.1797, symbol: 'Ne'},
];

@Component({
  selector: 'app-userspage',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.less']
})
export class UserHomeComponent implements OnInit {
  barcode ='';
  name = '';
  updateFormGroup:FormGroup;
  createFormGroup:FormGroup;
  fireForm:User = {
    username: "",
    firstName: "",
    lastName:"",
    id:null,
  };
  opened:boolean = false;
  dataSource: MatTableDataSource<User>;
  displayedColumns: string[] = ['Username', 'Firstname', 'Lastname', 'Role','Edit','Delete'];
  constructor(private fireService:FireserviceService,
    private userClientService:UserClientService,
    private studentService:StudentClientService,
    private formBuilder: FormBuilder) { 
    this.dataSource = new MatTableDataSource([])
    this.updateFormGroup = this.setFormbuilder(this.fireForm);
    this.createFormGroup = this.setCreateFormBuilder();
  }

  ngOnInit() {
   this.getAllUsers();
  }

  setFormbuilder(fireForm:User){
    return this.formBuilder.group({
      username : new FormControl(
        fireForm.username,
        Validators.compose([
          Validators.required,
        ])
      ),
      firstName : new FormControl(
        fireForm.firstName,
        Validators.compose([
          Validators.required,
        ])
      ),
      lastName : new FormControl(
        fireForm.lastName,
        Validators.compose([
          Validators.required,
        ])
      ),
    });
  }

  setCreateFormBuilder(){
    return this.formBuilder.group({
      username : new FormControl(
        '',
        Validators.compose([
          Validators.required,
        ])
      ),
      firstName : new FormControl(
        '',
        Validators.compose([
          Validators.required,
        ])
      ),
      lastName : new FormControl(
        '',
        Validators.compose([
          Validators.required,
        ])
      ),
      password : new FormControl(
        '',
        Validators.compose([
          Validators.required,
        ])
      ),
      studentCode : new FormControl(
        '',
        Validators.compose([
          Validators.required,
        ])
      ),
      barcode : new FormControl(
        '',
        Validators.compose([
          Validators.required,
        ])
      ),
    });
  }


  // submit(){
  //   var barcode ={
  //     "name":this.name,
  //     "barcode":this.barcode
  //   };

  //   this.fireService.enterBarcode(barcode).subscribe((res)=>{
  //      console.log(res);
  //   })
  // }

  createAccount(student:Student){
     console.log(student)
     this.studentService.addStudent$(student).subscribe((res)=>{
       console.log("success")
     });
  }

  onchange(){
    this.opened=false;
  }

  deleteUser(user:User):void{
     this.userClientService.deleteUser$(user.id).subscribe((res)=>{
      this.removeLocal(user);
     })
  }

  close(){
    this.opened=false;
  }

  getAllUsers(){
    this.userClientService.getAllUsers$().subscribe((res)=>{
      this.dataSource.data = res;
      console.log(res);
    })
  }

  editUser(user:User){
    this.fireForm = user;
     this.opened=true;
     this.updateFormGroup = this.setFormbuilder(user);
  }

  updateAccount(details:any){
    this.fireForm.username = details.username;
    this.fireForm.lastName = details.lastName;
    this.fireForm.firstName = details.firstName;
    this.userClientService.modifyUser$(this.fireForm).subscribe((res)=>{
      this.updateLocal();
      this.opened=false;
    })
   
  }

  updateLocal():void{
    let index = this.dataSource.data.findIndex((user)=>this.fireForm.id==user.id);
    this.dataSource[index]=this.fireForm;
  }

  removeLocal(muser:User):void{
    let index = this.dataSource.data.findIndex((user)=>muser.id==user.id);
    this.dataSource.data.splice(index,1);
    this.dataSource=new MatTableDataSource(this.dataSource.data);
  }

}
