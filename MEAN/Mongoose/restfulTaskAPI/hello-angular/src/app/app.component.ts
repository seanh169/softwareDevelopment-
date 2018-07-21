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
 let text = "";
 let showinfo = document.createElement("input");
 showinfo.type = "button";
 showinfo.value = "show info";
 

 observable.subscribe(data => {
     console.log(data);
     for(let dat in data){ 
       text += data[dat].title+ "&nbsp;&nbsp;&nbsp;&nbsp;" + "<button ng-click='showinfo(data[dat]._id)'>show info</button> " +   "<br><br><br>"
       document.getElementById("tasks").innerHTML = text;
       
      

     }
     

 })

}

showinfo(idz): void {
  console.log(idz);
   let observable = this._httpService.getTasks();
   observable.subscribe(data => {
       console.log("GOT HERE");

   })


}








}


