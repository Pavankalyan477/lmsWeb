import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroupDirective, NgForm, Validators } from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material/core';


export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}

@Component({
  selector: 'app-create-party',
  templateUrl: './create-party.component.html',
  styleUrls: ['./create-party.component.css']
})
export class CreatePartyComponent implements OnInit {

  toppings = new FormControl('');
  toppingList: string[] = ['customer', 'supplier', 'employee', 'admin', 'manager', 'catalog admin','accountant','operations manager'];
  emailFormControl = new FormControl('', [Validators.required]);
  partynameFormControl = new FormControl('', [Validators.required]);
  matcher = new MyErrorStateMatcher();
  constructor() { }

  ngOnInit(): void {
  }

}
