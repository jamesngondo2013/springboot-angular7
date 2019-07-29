import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Book} from './book.model'

@Injectable({
  providedIn: 'root'
})
export class DataService {

  apiUrl = 'http://localhost:9095/book/books';

  constructor(private _http: HttpClient) { }

  getBooks(){
    return this._http.get<Book[]>(this.apiUrl);
  }

  public deleteBook(book){
    return this._http.delete<Book>(this.apiUrl +'/' + book.id);
  }

  public createBook(book){
    return this._http.post<Book>(this.apiUrl, book);
  }

}
