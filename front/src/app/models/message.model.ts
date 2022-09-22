export class Message {
  id!: number
  creationTime!: Date;
  lastUpdate!: Date;
  content!: string;
  icon!: string;
  link?: string;
  tags?: string;
  dueDate?: Date;
}
