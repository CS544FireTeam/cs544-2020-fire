import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {httpIntercetptorProvider} from './domain/services/interceptors';
import {InterceptorService} from './domain/services/interceptors/interceptor.service';
import {FireserviceService} from './domain/services/testservice/fireservice.service';
import {DashboardComponent} from './modules/home/dashboard/dashboard.component';
import {HomepageComponent} from './modules/home/home-page/home-page.component';
import {UserHomeComponent} from './modules/user/user-home/user-home.component';
import {CourseHomeComponent} from './modules/course/course-home/course-home.component';
import {CourseOfferingHomeComponent} from './modules/courseOffering/course-offering-home/course-offering-home.component';
import {SessionHomeComponent} from './modules/session/session-home/session-home.component';
import {LocationHomeComponent} from './modules/location/location-home/location-home.component';

import {MaterialModule} from "./material-module";
import {LocationListComponent} from './modules/location/location-list/location-list.component';
import {CourseListComponent} from './modules/course/course-list/course-list.component';
import { AuthGuardService } from './domain/services/AuthGuard/auth-guard.service';


@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    DashboardComponent,
    UserHomeComponent,
    CourseHomeComponent,
    CourseOfferingHomeComponent,
    SessionHomeComponent,
    LocationHomeComponent,
    LocationListComponent,
    CourseListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    MaterialModule,
  ],
  providers: [
    InterceptorService,
    httpIntercetptorProvider,
    FireserviceService,
    MaterialModule,
    AuthGuardService,
    BrowserAnimationsModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
