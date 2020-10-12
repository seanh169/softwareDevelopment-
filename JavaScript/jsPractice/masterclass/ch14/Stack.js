// Stack
// LIFO Data Structure



// using Arrays. As long as you pop/push OR shift/unshift you are implementing a STACK on an Array.
// let stack = [];

// stack.push('google.com');
// stack.push('instagram.com');
// stack.push('youtube.com');
// stack.pop()


// Build Own Stack using SLL

class Node {

    constructor(val) {
        this.val = val;
        this.next = null;
    }

}

class Stack {

    constructor() {

        this.first = null;
        this.last = null;
        this.length = 0;

    }

    push(val) {

        let newNode = new Node(val);

        if(!this.first) {
            this.first = newNode;
            this.last = newNode;
        }else{
            let temp = this.first;
            this.first = newNode;
            this.first.next = temp;
        }


        this.length++;
        return this.length;
    }

    pop(){
        if(!this.first){
            return undefined;
        }else{
            let temp = this.first;
            this.first = temp.next;
            temp.next = null;
            this.length--;
        }
    }


}

let stack = new Stack();

stack.push("hi");
stack.push("hello");
stack.push("hey");
stack.push("yo");
// stack.push("waddup");
stack.pop();
console.log(stack);