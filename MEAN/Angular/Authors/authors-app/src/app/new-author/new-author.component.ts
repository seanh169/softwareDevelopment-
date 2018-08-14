import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-new-author',
  templateUrl: './new-author.component.html',
  styleUrls: ['./new-author.component.css']
})
export class NewAuthorComponent implements OnInit {
	newAuthor: any;
  constructor(private _httpService: HttpService) { }

  ngOnInit() {
  	this.newAuthor = {name: ""};
  }
  addNewAuthor(){
    console.log(this.newAuthor);
    this.newAuthor = {name: ""};
  	
  }
}
