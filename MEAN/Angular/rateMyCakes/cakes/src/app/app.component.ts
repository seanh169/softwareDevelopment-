import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpService } from './http.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  
  title = 'app';
  newCake: any;
  allCakes = [];

  constructor(private _httpService: HttpService){}

  ngOnInit(){
  	this.newCake = {title: "", URL: ""};
    this.getCakesFromService();
  }

  onSubmit(){
  	// console.log(this.newCake);
   
     let observable = this._httpService.addCake(this.newCake); 
     observable.subscribe(data => {
       console.log(this.newCake);
       this.newCake = {title: "", URL: ""};
     })
    // var cake = new Cakes({title: this.newCake.title, URL: this.newCake.URL});cake.save();
  	// this.allCakes.push(this.newCake);
  	// console.log(this.allCakes);
  	// this.newCake = {title: "", URL: ""};

  }
  getCakesFromService(){
      let observable = this._httpService.getCakes();

      observable.subscribe(data => {

      for(let dat in data){ 
        this.allCakes.push((data[dat]));
      }
         
    })
}
}
