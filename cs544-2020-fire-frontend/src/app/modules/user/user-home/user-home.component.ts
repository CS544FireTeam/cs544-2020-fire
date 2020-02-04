import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { FireserviceService } from 'src/app/domain/services/testservice/fireservice.service';

@Component({
  selector: 'app-userspage',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.less']
})
export class UserHomeComponent implements OnInit {
  barcode ='';
  name = '';
  constructor(private fireService:FireserviceService) { }

  ngOnInit() {
  }


  onDownKey(event){
    event.preventDefault();
    console.log("eeee");
  }

  submit(){
    var barcode ={
      "name":this.name,
      "barcode":this.barcode
    };

    this.fireService.enterBarcode(barcode).subscribe((res)=>{
       console.log(res);
    })
  }

}
