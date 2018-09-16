import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-heading',
  templateUrl: './heading.component.html',
  styleUrls: ['./heading.component.css']
})
export class HeadingComponent implements OnInit {
	myStyle: object = {};
    myParams: object = {};
    width: number = 100;
    height: number = 100;
 	 constructor() { }

  ngOnInit() {
        this.myStyle = {
            'position': 'fixed',
            'width': '100%',
            'height': '20px',
            'z-index': -1,
            'top': 0,
            'left': 0,
            'right': 0,
            'bottom': 0,
        };
         this.myParams = {
            particles: {
                number: {
                    value: 100,
                },
                color: {
                    value: '#ff0000'
                },
                shape: {
                    type: 'triangle',
                },
        }
    };
    }

	}

