import { Component, OnInit } from '@angular/core'; 
import { HttpService } from './http.service';
import { ActivatedRoute, Params, Router } from '@angular/router';
// import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
	newAuthor: any;
  title = 'app';
  constructor(private _httpService: HttpService,
              private _route: ActivatedRoute,
              private _router: Router){}


  ngOnInit(){
    this.newAuthor = {name: ""};
    // this.onClick();
  }
  onClick(){
  	let observable = this._httpService.getAuthors();
  	observable.subscribe(data=> {
  		console.log(data);
  	})
  }
  
}
