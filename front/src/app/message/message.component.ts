import { Component, Input, OnInit } from '@angular/core';
import { Message } from '../models/message.model';
import { Router } from '@angular/router';
import { MessageService } from '../services/message.service'

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.scss']
})
export class MessageComponent implements OnInit {
  @Input() message!: Message;

  constructor(private messageService: MessageService, private router: Router) {}

  ngOnInit() {}

  onDelete() {
    this.messageService.deleteMessage(this.message.id).subscribe(
      (response) => {
        window.location.reload();
      }
    );
  }
}
