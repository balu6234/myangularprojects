import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddbookComponent } from './addbook/addbook.component';
import { AddstudentComponent } from './addstudent/addstudent.component';
import { BooklistComponent } from './booklist/booklist.component';
import { StudentlistComponent } from './studentlist/studentlist.component';
import { UpdatebookComponent } from './updatebook/updatebook.component';
import { UpdatestudentComponent } from './updatestudent/updatestudent.component';

const routes: Routes = [
  {path: "getbooks", component:BooklistComponent},
  {path: "getstudents", component:StudentlistComponent},
  {path: "addbooks", component:AddbookComponent},
  {path: "addstudents", component:AddstudentComponent},
 {path: '', redirectTo:'getbooks', pathMatch: 'full'},
 {path: '', redirectTo:'getstudents', pathMatch: 'full'},
  {path: 'updatebook/:id', component:UpdatebookComponent},
  {path: 'updatestudent/:id', component:UpdatestudentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
