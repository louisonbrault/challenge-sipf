import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  searchForm!: FormGroup;

  ngOnInit(): void {
    this.searchForm = this.formBuilder.group({
      tag: [null]
    });
  }

  constructor(private router: Router, private formBuilder: FormBuilder) { }

  onAddNewMessage() {
    this.router.navigateByUrl('/create');
  }

  searchByTag() {
    if (this.searchForm.value.tag != null && this.searchForm.value.tag != ""){
      this.router.navigateByUrl(`/search/${this.searchForm.value.tag}`);
    }
  }

  discardResearch() {
    this.router.navigateByUrl('/')
    this.searchForm = this.formBuilder.group({
      tag: [null]
    });
  }
}
