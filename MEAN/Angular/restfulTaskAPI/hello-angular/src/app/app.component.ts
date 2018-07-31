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
  newTask: any;
  thisTask = [];
  editThisTask: any;
  allTasks = [];
  selectedTask: any;
  constructor(private _httpService: HttpService){}

    ngOnInit(){
      this.editThisTask = {title: "", description: ""};
      this.newTask = {title: "", description: ""};
      // this.tasks = [];
      // this.thisTask = {title: "", description: ""};
      // console.log(this.newTask.title)
      this.getTasksFromService();
      // this.thisTask = [];
      // console.log("Hello");
    }
    onSubmit(){

      let observable = this._httpService.addTask(this.newTask);
      observable.subscribe(data => {
          // console.log("Got data back from post", data);

          this.newTask = {title: "", description: ""};


      })
      this.onButtonClick();
      // location.reload();
    }
    getTasksFromService(){
      let observable = this._httpService.getTasks();

      observable.subscribe(data => {

      // console.log("Got our tasks!", data)
      for(let dat in data){ 
        this.tasks.push((data[dat]));
      }
      // console.log(this.tasks);
   
    })

    
    }
   editTask(taskid: String){
       this.thisTask = [];
       let observable = this._httpService.editTask(taskid);
       observable.subscribe(data => {
         for(let item in data){
            this.thisTask.push(data[item]);
         }
         console.log(this.thisTask);
         console.log("got here", data);

         
        
       })












    }

    updateTask(thisId: String){
      // console.log(thisId);
      // console.log(this.editThisTask);
      let observable = this._httpService.updateTask(this.editThisTask, thisId);
      observable.subscribe(data => {
          console.log("got our data" , data);


      })
      this.onButtonClick();
    }
    deleteTask(deleteId: String){
      let observable = this._httpService.deleteTask(deleteId);
      observable.subscribe(data => {
          console.log("got our data" , data);


      })
      this.onButtonClick();
    }
onButtonClick(): void {
 this.allTasks = [];
 let observable = this._httpService.getTasks();
 // let tasks = document.getElementById("tasks");
 // let text = "";
 // let showinfo = document.createElement("input");
 // showinfo.type = "button";
 // showinfo.value = "show info";
 // let me = document.getElementById("displayTasks");


 

 observable.subscribe(data => {
     // console.log(data);
     for(let dat in data){
      // let button = '<button (click)="showInfo(' + data[dat]._id + ')'+ '">Show</button>';
      let button = '<button (click)="showInfo()">Show</button>';
      console.log(button);
      this.allTasks.push(data[dat]);
      // console.log(data[dat]._id); 
       // text += data[dat].title+ "&nbsp;&nbsp;&nbsp;&nbsp;" + " - " + data[dat].description + button + "<br><br><br>"
       // document.getElementById("tasks").innerHTML = text;
       // let btn = document.getElementById("btn");
       // console.log(document.getElementById("btn").id);
       // console.log(document.getElementById("btn").val;
       // btn.setAttribute("val", data[dat]._id);
       // console.log(document.getElementById("btn").val)
       // btn.onclick = function showinfo(){

       //   // console.log(this);
       //   // console.log(data[dat]._id);
       //   let info = document.getElementById("info");
       //   info.innerHTML =  data[dat].description; 
        

       // };       

     }
     

 })

}

showInfo(idz): void {
  console.log(idz);
   let observable = this._httpService.editTask(idz);
   observable.subscribe(data => {
       console.log(`got here`);
       console.log(data);
       this.selectedTask = data;
       console.log(this.selectedTask);

   })


}








}


