class Bike {
    miles: number;
    constructor(public price: number,
                public max_speed: string

    ) {
        this.price = price;
        this.max_speed = max_speed;
        this.miles = 0;
                    
    }
    displayInfo() {
        console.log("This bike cost: " + this.price + " , the bike can go up to: " + this.max_speed + ". The current total miles are: " + this.miles);
    } 
    ride() {
        console.log("Riding");
        this.miles += 10; 
    }
    reverse() {
        console.log("Reversing");
        if (this.miles < 5) {
            this.miles = 0
        } else { this.miles -= 5; };
        
    }
}

let x = new Bike(22, "25mph");
let y = new Bike(50, "30mph");
let z = new Bike(100, "45mph");

x.ride();
x.ride();
x.ride();
x.reverse();
x.displayInfo();
y.ride();
y.ride();
y.reverse();
y.reverse();
y.displayInfo();
z.reverse();
z.reverse();
z.reverse();
z.displayInfo();

//Have the first instance ride three times, reverse once and have it displayInfo(). Have the second instance ride twice, reverse twice and have it displayInfo(). Have the third instance reverse three times and displayInfo().

// What would you do to prevent the instance from having negative miles?
//I placed an if statement above the decrement of 5 miles if that its ever less than 5 it will just reset to 0.
// Which methods can return this in order to allow chaining methods?
// local methods?
// For assignment submission, upload a ".ts" file with the contents of the TypeScript Playground.