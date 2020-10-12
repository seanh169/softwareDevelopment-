// Queue
// FIFO Data Structure

// Array

// let queue = [];

// queue.push('first');
// queue.push('second');
// queue.push('third');

// queue.shift();

// console.log(queue);

// Queue Custom Class


class Node {

    constructor(value) {
        this.value = value;
        this.next = null;
    }

}

class Queue {

    constructor() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    enqueue(val) {

        let newNode = new Node(val);

        if(!this.first) {
            this.first = newNode;
            this.last = newNode;
        }else{
            let temp = this.last;
            this.last = newNode;
            temp.next = newNode;
        }  


        this.size++;
    }

    dequeue() {
        let firstNode = this.first;
        if(!this.first) {
            return undefined;
        }else if(this.size === 1){
            // let firstNode = this.first;
            this.first = null;
            this.last = null;
        }else{
            // let firstNode = this.first;
            this.first = this.first.next;
            firstNode.next = null;
        }
        return firstNode;
        this.size--;
    }
}

let q = new Queue();
q.enqueue("hi");
q.enqueue("hello");
q.enqueue("yo");
console.log(q.dequeue());
q.enqueue("gh");
console.log(q);