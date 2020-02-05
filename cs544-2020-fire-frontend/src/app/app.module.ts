import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {InterceptorService} from './domain/services/interceptors/interceptor.service';
import {FireserviceService} from './domain/services/testservice/fireservice.service';

import {MaterialModule} from "./material-module";
import {AuthGuardService} from './domain/services/AuthGuard/auth-guard.service';
import {httpIntercetptorProvider} from "./domain/services/interceptors";
import {MainPageComponent} from "./modules/home/main-page/main-page.component";
import {HomepageComponent} from "./modules/home/home-page/home-page.component";


@NgModule({
  declarations: [
    AppComponent,
    MainPageComponent,
    HomepageComponent,
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
