import { Component, OnInit } from '@angular/core';
import { Message } from '../models/message.model'
import { MessageService } from '../services/message.service'
import { Observable } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-message-list',
  templateUrl: './message-list.component.html',
  styleUrls: ['./message-list.component.scss']
})
export class MessageListComponent implements OnInit {

  messages$!: Observable<Message[]>;

  constructor(private messageService: MessageService, private route: ActivatedRoute, private router: Router) {}

  ngOnInit(): void {
    const tagSearch = this.route.snapshot.params['tag'];
    const path = this.router.url

    if (path.startsWith("/search/")){
      this.messages$ = this.messageService.researchByTag(tagSearch);
    } else {
      this.messages$ = this.messageService.getAllMessages();
    }
  }

}
