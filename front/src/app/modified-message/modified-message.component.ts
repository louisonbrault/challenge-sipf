import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Message } from '../models/message.model'
import { MessageService } from '../services/message.service'
import { Observable } from 'rxjs';

@Component({
  selector: 'app-modified-message',
  templateUrl: './modified-message.component.html',
  styleUrls: ['./modified-message.component.scss']
})
export class ModifiedMessageComponent implements OnInit {
  message$!: Observable<Message>
  message!: Message;
  messageForm!: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private messageService: MessageService,
    private router: Router,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    const messageId = +this.route.snapshot.params['id'];

    this.message$ = this.messageService.getMessageById(messageId);

    this.messageForm = this.formBuilder.group({
      content: [null, Validators.required],
      icon: [null],
      link: [null],
      tags: [null],
      dueDate: [null]
    })

    this.message$.subscribe(
      (data) => {
        this.messageForm = this.formBuilder.group({
          content: [data.content, Validators.required],
          icon: [data.icon],
          link: [data.link],
          tags: [data.tags],
          dueDate: [data.dueDate]
      }
    )
    });
  }

  onSubmitForm(){
    this.messageService.modifyMessage(+this.route.snapshot.params['id'], this.messageForm.value).subscribe(
      (data) => this.router.navigateByUrl('/'),
    );
  }

  dismiss(){
    this.router.navigateByUrl('/')
  }
}
