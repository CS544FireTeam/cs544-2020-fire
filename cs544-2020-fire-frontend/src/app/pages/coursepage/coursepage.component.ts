import { Component, OnInit } from '@angular/core';
import { FireserviceService } from 'src/app/services/testservice/fireservice.service';

@Component({
  selector: 'app-coursepage',
  templateUrl: './coursepage.component.html',
  styleUrls: ['./coursepage.component.less']
})
export class CoursepageComponent implements OnInit {
  barcode='';
  user = {
    "name":"",
    "barcode":""
  };

  constructor(private fireService:FireserviceService) { }

  ngOnInit() {
  }


  submit(){
    this.fireService.getBarcode(this.barcode).subscribe((res)=>{
      this.user=res;
       console.log(res);
    })
  }

}


