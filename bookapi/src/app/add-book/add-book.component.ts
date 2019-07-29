import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Book} from '../book.model'
import { DataService } from '../data.service';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {

  book: Book = new Book("","","");

  constructor(private dataService: DataService){}

  ngOnInit() {
  }

  createEmployee(): void {
    this.dataService.createBook(this.book)
        .subscribe( data => {
          alert("New book created successfully.");
        });

  };

}
