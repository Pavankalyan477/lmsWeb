import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormGroupDirective, NgForm, Validators } from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material/core';
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { ImsServiceService } from '../ims-service.service';
import { PartyDetails } from '../PartyDetails';


// export class MyErrorStateMatcher implements ErrorStateMatcher {
//   isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
//     const isSubmitted = form && form.submitted;
//     return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
//   }
// }

@Component({
  selector: 'app-create-party',
  templateUrl: './create-party.component.html',
  styleUrls: ['./create-party.component.css']
})
export class CreatePartyComponent implements OnInit {

  disable=false;
  count=0;
  toppings = new FormControl('');
  toppingList: string[] = ['customer', 'supplier', 'employee', 'admin', 'manager', 'catalog admin','accountant','operations manager'];
 

 // parties:PartyDetails={id:0,partyName:"",description:"",partyType:"",roles:"",gstNo:"",status:"",addresses:[]}
  //matcher = new MyErrorStateMatcher();
  constructor(private imsService:ImsServiceService,private router:Router,private _snackBar: MatSnackBar) { }

  mform: FormGroup = new FormGroup({
    partyName: new FormControl("", [Validators.required]),
    partyType: new FormControl("", [Validators.required]),
    roles: new FormControl("",[Validators.required]),
    description: new FormControl(),
    gstNo: new FormControl()
  });
  ngOnInit(): void {
  }

  horizontalPosition: MatSnackBarHorizontalPosition = 'end';
  verticalPosition: MatSnackBarVerticalPosition = 'top';


 

  openSnackBar() {
    this._snackBar.open('Created Successfully..:)', 'OK', {
      horizontalPosition: this.horizontalPosition,
      verticalPosition: this.verticalPosition,
      
    },);
  }

  AddParty(parties:PartyDetails){
    console.log(parties)
    this.imsService.addParty(parties).subscribe(
      (response: PartyDetails) => {
       // console.log(response);
       this.openSnackBar();
       setTimeout(()=>{
        this.router.navigate(['/dashboard/parties']);
       },2500)
        
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        //this.parties={id:0,partyName:"",description:"",partyType:"",roles:"",gstNo:"",status:"",addresses:[]}
      }
    );
  }
  

  getErrorMessage() {
    
    return 'You must enter a value';
  }

}
