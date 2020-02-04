import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatFormFieldModule, MatInputModule, MatOptionModule, MatSelectModule, MatIconModule, MatButtonModule} from '@angular/material';
import { HttpClientModule } from '@angular/common/http';
import { FormBuilder, FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { httpIntercetptorProvider } from './services/interceptors';
import { InterceptorService } from './services/interceptors/interceptor.service';
import { FireserviceService } from './services/testservice/fireservice.service';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { HomepageComponent } from './pages/homepage/homepage.component';

@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    DashboardComponent
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
    HttpClientModule
  ],
  providers: [
    InterceptorService,
    httpIntercetptorProvider,
    FireserviceService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
