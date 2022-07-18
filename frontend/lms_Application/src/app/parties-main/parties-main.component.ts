import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { of } from 'rxjs';
export interface PeriodicElement {
  Name: string;
  PartyId: number;
  Roles: string;
  CreatedAt: string;
  ModifiedOn:string;
  ModifiedBy:string;
  status:string
}

const ELEMENT_DATA: PeriodicElement[] = [
  {PartyId: 1, Name: 'Hydrogen', CreatedAt:" 11-11-2021", Roles: 'H',ModifiedOn:"12-06-2022",ModifiedBy:"kalyan",status:"active"},
  {PartyId: 2, Name: 'Helium', CreatedAt:" 11-11-2021" ,Roles: 'He',ModifiedOn:"12-06-2022",ModifiedBy:"kalyan",status:"active"},
  {PartyId: 3, Name: 'Lithium', CreatedAt:" 11-11-2021",Roles: 'Li',ModifiedOn:"12-06-2022",ModifiedBy:"kalyan",status:"active"},
  {PartyId: 4, Name: 'Beryllium', CreatedAt:" 11-11-2021" ,Roles: 'Be',ModifiedOn:"12-06-2022",ModifiedBy:"kalyan",status:"active"},
  {PartyId: 5, Name: 'Boron', CreatedAt:" 11-11-2021" ,Roles: 'B',ModifiedOn:"12-06-2022",ModifiedBy:"kalyan",status:"active"},
  {PartyId: 6, Name: 'Carbon', CreatedAt:" 11-11-2021", Roles: 'C',ModifiedOn:"12-06-2022",ModifiedBy:"kalyan",status:"active"},
  {PartyId: 7, Name: 'Nitrogen', CreatedAt:" 11-11-2021", Roles: 'N',ModifiedOn:"12-06-2022",ModifiedBy:"kalyan",status:"active"},
  {PartyId: 8, Name: 'Oxygen', CreatedAt:" 11-11-2021", Roles: 'O',ModifiedOn:"12-06-2022",ModifiedBy:"kalyan",status:"active"},
  {PartyId: 9, Name: 'Fluorine', CreatedAt:" 11-11-2021", Roles: 'F',ModifiedOn:"12-06-2022",ModifiedBy:"kalyan",status:"active"},
  {PartyId: 10, Name: 'Neon', CreatedAt:" 11-11-2021", Roles: 'Ne',ModifiedOn:"12-06-2022",ModifiedBy:"kalyan",status:"active"},
  {PartyId: 11, Name: 'Sodium', CreatedAt:" 11-11-2021", Roles: 'Na',ModifiedOn:"12-06-2022",ModifiedBy:"kalyan",status:"active"},
  {PartyId: 12, Name: 'Magnesium', CreatedAt:" 11-11-2021" ,Roles: 'Mg',ModifiedOn:"12-06-2022",ModifiedBy:"kalyan",status:"active"},
  {PartyId: 13, Name: 'Aluminum', CreatedAt:" 11-11-2021", Roles: 'Al',ModifiedOn:"12-06-2022",ModifiedBy:"kalyan",status:"active"},
  {PartyId: 14, Name: 'Silicon', CreatedAt:" 11-11-2021", Roles: 'Si',ModifiedOn:"12-06-2022",ModifiedBy:"kalyan",status:"active"},
  {PartyId: 15, Name: 'Phosphorus', CreatedAt:" 11-11-2021", Roles: 'P',ModifiedOn:"12-06-2022",ModifiedBy:"kalyan",status:"active"},
  {PartyId: 16, Name: 'Sulfur', CreatedAt:" 11-11-2021" ,Roles: 'S',ModifiedOn:"12-06-2022",ModifiedBy:"kalyan",status:"active"},
  {PartyId: 17, Name: 'Chlorine', CreatedAt:" 11-11-2021" ,Roles: 'Cl',ModifiedOn:"12-06-2022",ModifiedBy:"kalyan",status:"active"},
  {PartyId: 18, Name: 'Argon', CreatedAt:" 11-11-2021" ,Roles: 'Ar',ModifiedOn:"12-06-2022",ModifiedBy:"kalyan",status:"active"},
  {PartyId: 19, Name: 'Potassium', CreatedAt:" 11-11-2021", Roles: 'K',ModifiedOn:"12-06-2022",ModifiedBy:"kalyan",status:"active"},
  {PartyId: 20, Name: 'Calcium', CreatedAt:" 11-11-2021" ,Roles: 'Ca',ModifiedOn:"12-06-2022",ModifiedBy:"kalyan",status:"active"},
  {PartyId: 11, Name: 'Sodium', CreatedAt:" 11-11-2021", Roles: 'Na',ModifiedOn:"12-06-2022",ModifiedBy:"kalyan",status:"active"},
  {PartyId: 12, Name: 'Magnesium', CreatedAt:" 11-11-2021" ,Roles: 'Mg',ModifiedOn:"12-06-2022",ModifiedBy:"kalyan",status:"active"},
  {PartyId: 13, Name: 'Aluminum', CreatedAt:" 11-11-2021", Roles: 'Al',ModifiedOn:"12-06-2022",ModifiedBy:"kalyan",status:"active"},
  {PartyId: 14, Name: 'Silicon', CreatedAt:" 11-11-2021", Roles: 'Si',ModifiedOn:"12-06-2022",ModifiedBy:"kalyan",status:"active"},
  {PartyId: 15, Name: 'Phosphorus', CreatedAt:" 11-11-2021", Roles: 'P',ModifiedOn:"12-06-2022",ModifiedBy:"kalyan",status:"active"},
  {PartyId: 16, Name: 'Sulfur', CreatedAt:" 11-11-2021" ,Roles: 'S',ModifiedOn:"12-06-2022",ModifiedBy:"kalyan",status:"active"},
  {PartyId: 17, Name: 'Chlorine', CreatedAt:" 11-11-2021" ,Roles: 'Cl',ModifiedOn:"12-06-2022",ModifiedBy:"kalyan",status:"active"},
  {PartyId: 18, Name: 'Argon', CreatedAt:" 11-11-2021" ,Roles: 'Ar',ModifiedOn:"12-06-2022",ModifiedBy:"kalyan",status:"active"},
  {PartyId: 19, Name: 'Potassium', CreatedAt:" 11-11-2021", Roles: 'K',ModifiedOn:"12-06-2022",ModifiedBy:"kalyan",status:"active"},
  {PartyId: 20, Name: 'Calcium', CreatedAt:" 11-11-2021" ,Roles: 'Ca',ModifiedOn:"12-06-2022",ModifiedBy:"kalyan",status:"active"},
];


@Component({
  selector: 'app-parties-main',
  templateUrl: './parties-main.component.html',
  styleUrls: ['./parties-main.component.css']
})
export class PartiesMainComponent implements OnInit {
  routeValue:boolean=true;
  panelOpenState = false;
  constructor() { }

  @ViewChild(MatPaginator) paginator!:MatPaginator
  ngOnInit(): void {
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }
  displayedColumns: string[] = ['PartyId', 'Name', 'Roles', 'CreatedAt','ModifiedOn','ModifiedBy','Status'];
  dataSource = new MatTableDataSource<PeriodicElement>(ELEMENT_DATA);
  changeUpload(){
   this.routeValue=false
  }
  changeSearch(){
    this.routeValue=true;
  }
  


}




