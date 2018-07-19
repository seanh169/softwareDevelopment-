import { Component, OnInit } from '@angular/core';
import { HttpService } from './http.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  tasks = [];
  title = 'Restful Tasks API';
  constructor(private _httpService: HttpService){}

    ngOnInit(){
      this.getTasksFromService();
      // console.log("Hello");
    }
    getTasksFromService(){
      let observable = this._httpService.getTasks();

      observable.subscribe(data => {

      console.log("Got our tasks!", data)
      for(let dat in data){ 
        this.tasks.push((data[dat]));
      }
      console.log(this.tasks);
   
    });

    
}
onButtonClickParam(num: Number): void { 
    console.log(`Click event is working with num param: ${num}`);
    // call the service's method to post the data, but make sure the data is bundled up in an object!
    let observable = this._httpService.postToServer({data: num});
    observable.subscribe(data => console.log("Got our data!", data));



}
onButtonClick(): void {
 let observable = this._httpService.getTasks();
 let tasks = document.getElementById("tasks");

 observable.subscribe(data => {
     console.log(data);
     for(let dat in data){ 
       document.getElementById("tasks").innerHTML ="<b>task title</b>" + "<br><br>" +  data[dat].title + "-" + data[dat].description;


     }


 })

}

}
