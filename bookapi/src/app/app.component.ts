import { Component, OnInit } from '@angular/core';
import{Book} from './book.model';
import { DataService } from './data.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  title ='book-management';
  
}
