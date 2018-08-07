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
      
      this.getTasksFromService();
     
    }
    onSubmit(){

      let observable = this._httpService.addTask(this.newTask);
      observable.subscribe(data => {
          

          this.newTask = {title: "", description: ""};


      })
      this.onButtonClick();
      
    }
    getTasksFromService(){
      let observable = this._httpService.getTasks();

      observable.subscribe(data => {

      for(let dat in data){ 
        this.tasks.push((data[dat]));
      }
         
    })

    
    }
   editTask(taskid: String){
       this.thisTask = [];
       let observable = this._httpService.editTask(taskid);
       observable.subscribe(data => {
         for(let item in data){
            this.thisTask.push(data[item]);
         }

       })
    }

    updateTask(thisId: String){
      
      let observable = this._httpService.updateTask(this.editThisTask, thisId);
      observable.subscribe(data => {
          console.log("got our data" , data);

      })
      this.onButtonClick();
    }
  deleteTask(deleteId: String){
      let observable = this._httpService.deleteTask(deleteId);
      observable.subscribe(data => {
          
      })
      this.onButtonClick();
  }
  onButtonClick(): void {
   this.allTasks = [];
   let observable = this._httpService.getTasks();
   
   observable.subscribe(data => {
       
       for(let dat in data){
        
        this.allTasks.push(data[dat]);
           

       }
       
   })

  }

  showInfo(idz): void {
    
     let observable = this._httpService.editTask(idz);
     observable.subscribe(data => {
         
         this.selectedTask = data;
         console.log(this.selectedTask)
     })

  }







}


