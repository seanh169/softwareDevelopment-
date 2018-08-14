import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HttpModule } from '@angular/http';
import { ActivatedRoute, Params, Router } from '@angular/router';

@Component({
  selector: 'app-new-author',
  templateUrl: './new-author.component.html',
  styleUrls: ['./new-author.component.css']
})
export class NewAuthorComponent implements OnInit {
	newAuthor: any;
  constructor(private _httpService: HttpService, private _route: ActivatedRoute, private _router: Router) { }

  ngOnInit() {
  	this.newAuthor = {name: ""};
  }
  addNewAuthor(){
    let observable = this._httpService.addAuthor(this.newAuthor);
    observable.subscribe(data =>{
      console.log(data);
    })
    console.log(this.newAuthor);
    this.newAuthor = {name: ""};

  	// this._router.navigate(['/']);
    this._router.navigate([this._router.url]);
  }
}
