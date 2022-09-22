import { Injectable } from '@angular/core';
import { Message } from '../models/message.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class MessageService {

  constructor(private http: HttpClient){

  }

  getAllMessages(): Observable<Message[]> {
    return this.http.get<Message[]>('http://localhost:8080/api/message');
  }

  deleteMessage(id: number): Observable<Message> {
    return this.http.delete<Message>('http://localhost:8080/api/message/${id}');
  }

  addMessage(
    formValue:{content: string, icon: string, link: string, tags: string, dueDate: Date}
  ): Observable<Message> {
    return this.http.post<Message>('http://localhost:8080/api/message', formValue);
  }

}
