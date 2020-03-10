import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { CarDetailsComponent } from './car-details/car-details.component';
import { UserLogingComponent } from './user-loging/user-loging.component';
import { CustomerOwnerRegisterComponent } from './customer-owner-register/customer-owner-register.component';
import { Services } from './Services';

@NgModule({
  declarations: [
    AppComponent,
    CarDetailsComponent,
    UserLogingComponent,
    CustomerOwnerRegisterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [Services],
  bootstrap: [AppComponent]
})
export class AppModule { }
