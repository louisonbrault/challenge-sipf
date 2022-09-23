import { Component, Input } from '@angular/core';
import { Message } from '../models/message.model';
import { Router } from '@angular/router';
import { MessageService } from '../services/message.service'

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.scss']
})
export class MessageComponent {
  @Input() message!: Message;

  constructor(private messageService: MessageService, private router: Router) {}

  onDelete() {
    this.messageService.deleteMessage(this.message.id).subscribe(
      (response) => {
        this.router.navigateByUrl("/");
        window.location.reload();
      }
    )
  }

  onModify() {
    this.router.navigateByUrl(`update/${this.message.id}`)
  }
}
