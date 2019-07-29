import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Book} from '../book.model'
import { DataService } from '../data.service';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {

  books$:Book[];

  constructor(private dataService: DataService) { }
  
  ngOnInit() {
    this.dataService.getBooks().subscribe(
     response =>this.handleSuccessfulResponse(response),
    );
  }

  handleSuccessfulResponse(response){
      this.books$=response;
  }

  deleteBook(book: Book): void {
    this.dataService.deleteBook(book)
            .subscribe(data => {
              this. books$ = this.books$.filter(u => u !== book);
            })
  }

}
