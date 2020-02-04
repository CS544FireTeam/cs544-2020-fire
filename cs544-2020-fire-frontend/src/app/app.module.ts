import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatFormFieldModule, MatInputModule, MatOptionModule, MatSelectModule, MatIconModule, MatButtonModule, MatSidenavModule, MatListModule, MatCheckboxModule, MatDividerModule, MatDialogModule, MatBottomSheetModule, MatRadioModule} from '@angular/material';
import { HttpClientModule } from '@angular/common/http';
import { FormBuilder, FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { httpIntercetptorProvider } from './services/interceptors';
import { InterceptorService } from './services/interceptors/interceptor.service';
import { FireserviceService } from './services/testservice/fireservice.service';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { HomepageComponent } from './pages/homepage/homepage.component';
import { UserspageComponent } from './pages/userspage/userspage.component';
import { CoursepageComponent } from './pages/coursepage/coursepage.component';
import { CourseofferingpageComponent } from './pages/courseofferingpage/courseofferingpage.component';
import { SessionpageComponent } from './pages/sessionpage/sessionpage.component';
import { LocationpageComponent } from './pages/locationpage/locationpage.component';

import {MaterialModule} from "./material-module";
import { LocationListComponent } from './modules/location/location-list/location-list.component';
import { CourseListComponent } from './modules/course/course-list/course-list.component';


@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    DashboardComponent,
    UserspageComponent,
    CoursepageComponent,
    CourseofferingpageComponent,
    SessionpageComponent,
    LocationpageComponent,
    LocationListComponent,
    CourseListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    MatOptionModule,
    MatSelectModule,
    ReactiveFormsModule,
    FormsModule,
    MatIconModule,
    MatButtonModule,
    HttpClientModule,
    MatSidenavModule,
    MatListModule,
    MatCheckboxModule,
    MatDividerModule,
    MatDialogModule,
    MatBottomSheetModule,
    MatRadioModule
  ],
  providers: [
    InterceptorService,
    httpIntercetptorProvider,
    FireserviceService,
    MaterialModule,
    BrowserAnimationsModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
