import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreatePartyComponent } from './create-party/create-party.component';
import { PartiesMainComponent } from './parties-main/parties-main.component';
import { UpdatePartyComponent } from './update-party/update-party.component';

const routes: Routes = [
  {path:"dashboard/parties",component:PartiesMainComponent},
  {path:"dashboard/add-party",component:CreatePartyComponent},
  {path:"dashboard/add-party/:id",component:UpdatePartyComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
