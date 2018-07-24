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
  constructor(private _httpService: HttpService){}

    ngOnInit(){
      this.editThisTask = {title: "", description: ""};
      this.newTask = {title: "", description: ""};

      // this.thisTask = {title: "", description: ""};
      // console.log(this.newTask.title)
      this.getTasksFromService();
      // this.thisTask = [];
      // console.log("Hello");
    }
    onSubmit(){

      console.log("hello");
      console.log(this.newTask);

      let observable = this._httpService.addTask(this.newTask);
      observable.subscribe(data => {
          console.log("Got data back from post", data);
          this.newTask = {title: "", description: ""}

      })
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
   editTask(taskid: String){
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
    }
    deleteTask(deleteId: String){
      let observable = this._httpService.deleteTask(deleteId);
      observable.subscribe(data => {
          console.log("got our data" , data);


      })
    }
// onButtonClick(): void {
//  let observable = this._httpService.getTasks();
//  let tasks = document.getElementById("tasks");
//  let text = "";
//  // let showinfo = document.createElement("input");
//  // showinfo.type = "button";
//  // showinfo.value = "show info";
//  let me = document.getElementById("woah");
//  // me.hidden = false; 

 

//  observable.subscribe(data => {
//      console.log(data);
//      for(let dat in data){
//       let button = '<button id="btn">Show</button>';

//       console.log(data[dat]._id); 
//        text += data[dat].title+ "&nbsp;&nbsp;&nbsp;&nbsp;" + " - " + data[dat].description + "<br><br><br>"
//        document.getElementById("tasks").innerHTML = text;
//        // let btn = document.getElementById("btn");
//        // console.log(document.getElementById("btn").id);
//        // console.log(document.getElementById("btn").val;
//        // btn.setAttribute("val", data[dat]._id);
//        // console.log(document.getElementById("btn").val)
//        // btn.onclick = function showinfo(){

//        //   // console.log(this);
//        //   // console.log(data[dat]._id);
//        //   let info = document.getElementById("info");
//        //   info.innerHTML =  data[dat].description; 
        

//        // };       

//      }
     

//  })

// }

// showinfo(idz): void {
//   console.log(idz);
//    let observable = this._httpService.getTasks();
//    observable.subscribe(data => {
//        console.log(`got here`);

//    })


// }








}


