import { Component, OnInit } from '@angular/core';
import { FireserviceService } from 'src/app/domain/services/testservice/fireservice.service';

@Component({
  selector: 'fire-coursepage',
  templateUrl: './course-home.component.html',
  styleUrls: ['./course-home.component.less']
})
export class CourseHomeComponent implements OnInit {
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


