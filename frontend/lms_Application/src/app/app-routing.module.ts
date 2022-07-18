import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreatePartyComponent } from './create-party/create-party.component';
import { PartiesMainComponent } from './parties-main/parties-main.component';

const routes: Routes = [
  {path:"dashboard/parties",component:PartiesMainComponent},
  {path:"dashboard/add-party",component:CreatePartyComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
