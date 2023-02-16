import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddbookComponent } from './addbook/addbook.component';
//import { UpdatebookComponent } from './updatebook/updatebook.component';
import { BooklistComponent } from './booklist/booklist.component';
import { AddstudentComponent } from './addstudent/addstudent.component';
//import { UpdatestudentComponent } from './updatestudent/updatestudent.component';
import { StudentlistComponent } from './studentlist/studentlist.component';
import { BookServiceService } from 'service/book-service.service';
import { StudentServiceService } from 'service/student-service.service';
import {HttpClientModule} from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { UpdatebookComponent } from './updatebook/updatebook.component';
import { UpdatestudentComponent } from './updatestudent/updatestudent.component';
@NgModule({
  declarations: [
    AppComponent,
    AddbookComponent,
   UpdatebookComponent,
    BooklistComponent,
    AddstudentComponent,
    UpdatestudentComponent,
    StudentlistComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [BookServiceService,
             StudentServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
