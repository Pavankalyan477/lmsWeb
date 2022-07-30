import { HttpErrorResponse } from '@angular/common/http';
import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { ImsServiceService } from '../ims-service.service';
import { Page_gen, PartyDetails, Search } from '../PartyDetails';

@Component({
  selector: 'app-parties-main',
  templateUrl: './parties-main.component.html',
  styleUrls: ['./parties-main.component.css'],
})
export class PartiesMainComponent implements OnInit {
  routeValue: boolean = true;
  panelOpenState = false;
  selected = true;
  search_len=false;
  search_length=0

  partiesForm:FormGroup=new FormGroup({
    partyId:new FormControl(),
    partyName:new FormControl(""),
    roles:new FormControl(""),
    status:new FormControl(''),
    partyType:new FormControl(''),
    createdDate:new FormControl(''),
    lastModifiedDate: new FormControl(''),
    page:new FormControl(0),
    size:new FormControl(10)
  })
  // };
  pageSource: PartyDetails[] = [];
  public parties: PartyDetails[] = [];
  dataSource = new MatTableDataSource<PartyDetails>(this.pageSource);
  
  constructor(private imsService: ImsServiceService,public dialog: MatDialog) {}


 
  
  ngOnInit(): void {
    
   
    this.searchCriteria(this.partiesForm.value);
  }

  ngAfterViewInit() {
  }

 

  
  
  searchCriteria(data:any) {
      this.imsService.searchCriteria(data).subscribe(
        (res:Page_gen) => {
          this.dataSource.data = res['content'];
          this.pageSource=res['content'];
         
          this.search_length=res['totalElements'];
         
        },
        (error: Error) => {
          alert(error.message);
        }
      );
    

    
  }

  Search(data:any) {
  console.log(data);
  
    //  this.partiesForm.value.page = 0;
    //  this.partiesForm.value.size = 10;
    this.searchCriteria(data);
}
  nextPage(event: PageEvent) {
   
     this.partiesForm.value.page = event.pageIndex;
     this.partiesForm.value.size = event.pageSize;
    this.searchCriteria(this.partiesForm.value);
}

  displayedColumns: string[] = [
    'PartyId',
    'Name',
    'Roles',
    'CreatedAt',
    'ModifiedOn',
    'ModifiedBy',
    'Status',
  ];

  select(item: string) {
    if (item === 'Search') {
      this.routeValue = true;
      this.selected = true;
    this.partiesForm=new FormGroup({
      partyId:new FormControl(),
      partyName:new FormControl(""),
      roles:new FormControl(""),
      status:new FormControl(''),
      partyType:new FormControl(''),
      createdDate:new FormControl(''),
      lastModifiedDate: new FormControl(''),
      page:new FormControl(0),
      size:new FormControl(10)
    })

      this.Search(this.partiesForm.value);
       
    } else {
      this.routeValue = false;
      this.selected = false;
    }
  }
  isActive1() {
    return this.selected === true;
  }
  isActive2() {
    return this.selected === false;
  }
}
