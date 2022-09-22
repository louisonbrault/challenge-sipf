import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MessageListComponent } from './message-list/message-list.component';
import { NewMessageComponent } from './new-message/new-message.component';
import { ModifiedMessageComponent } from './modified-message/modified-message.component';

const routes: Routes = [
  { path: '', component: MessageListComponent },
  { path: 'create', component: NewMessageComponent },
  { path: 'update/:id', component: ModifiedMessageComponent }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {}
