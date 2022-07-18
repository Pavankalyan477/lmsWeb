import { MediaMatcher } from '@angular/cdk/layout';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
Numbers:number[]=[];
  selected:any;
  show:boolean=false;
  ngOnInit(): void {
   
  }

  select(item:string) {
    this.selected = item; 
    if(item==='Parties'){
      this.show=true
    }else{
      this.show=false;
    }
    
};
isActive(item: string) {
    return this.selected === item;
};

}
