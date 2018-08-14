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
  authors = [];
  authorid = [];
  constructor(private _httpService: HttpService,
              private _route: ActivatedRoute,
              private _router: Router){}


  ngOnInit(){
    this.newAuthor = {name: ""};
    this.onClick();
    // this.authors = [];
  }
  onClick(){
  	let observable = this._httpService.getAuthors();
  	observable.subscribe(data=> {
  		console.log(data);
      for(let dat in data){
        this.authors.push(data[dat]);
      }
  	})
  }
  deleteAuthor(deleteId: String){
      let observable = this._httpService.deleteAuthor(deleteId);
      observable.subscribe(data => {
          
      })
      // this.onClick();
  }
  findOneAuthor(authorid: String){
       this.authorid = [];
       let observable = this._httpService.findOneAuthor(authorid);
       observable.subscribe(data => {
         for(let item in data){
            this.authorid.push(data[item]);
         }

       })
    }
  
}
