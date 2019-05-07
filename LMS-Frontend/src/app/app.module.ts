import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material';
import { LogInComponent } from './log-in/log-in.component';
import { HomeComponent } from './home/home.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { RegisterComponent } from './register/register.component';
import { MaterialsPageComponent } from './materials-page/materials-page.component';
import { MaterialDetailComponent } from './material-detail/material-detail.component';
import { FacultiesComponent } from './faculties/faculties.component';

@NgModule({
  exports: [
    FormsModule,
    ReactiveFormsModule
  ],
  declarations: [
    AppComponent,
    LogInComponent,
    HomeComponent,
    RegisterComponent,
    MaterialsPageComponent,
    MaterialDetailComponent,
    FacultiesComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    FlexLayoutModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
