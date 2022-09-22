import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MessageService } from '../services/message.service'

@Component({
  selector: 'app-new-message',
  templateUrl: './new-message.component.html',
  styleUrls: ['./new-message.component.scss']
})
export class NewMessageComponent implements OnInit {

  messageForm!: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private messageService: MessageService,
    private router: Router) { }

  ngOnInit(): void {
    this.messageForm = this.formBuilder.group({
      content: [null, Validators.required],
      icon: [null],
      link: [null],
      tags: [null],
      dueDate: [null]
    });
  }

  onSubmitForm(){
    this.messageService.addMessage(this.messageForm.value).subscribe();
    this.router.navigateByUrl('/');
  }

}
