import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { FireserviceService } from 'src/app/services/testservice/fireservice.service';

@Component({
  selector: 'app-userspage',
  templateUrl: './userspage.component.html',
  styleUrls: ['./userspage.component.less']
})
export class UserspageComponent implements OnInit {
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
