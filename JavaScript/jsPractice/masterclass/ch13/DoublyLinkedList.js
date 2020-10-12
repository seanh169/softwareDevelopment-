class Node {

    constructor(value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }

}

class DoublyLinkedList { 

    constructor() {
        
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    push(val) {
        let newNode = new Node(val);

        if(!this.head) {
            this.head = newNode;
            this.tail = newNode;
        }else{
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
        this.length++;
        return this;


    }

    pop(){
        let poppedNode = this.tail;
        if (!this.head) {
            return undefined;
        }else if(this.length === 1){
            this.head = null;
            this.tail = null;
        }else {
            this.tail = poppedNode.prev;
            this.tail.next = null;
            poppedNode.prev = null;
            
        }
        this.length--;
        return poppedNode;


    }

    shift(){
        let poppedNode = this.head;
        if (!this.head) {
            return undefined;
        }else if(this.length === 1){
            this.head = null;
            this.tail = null;
        }else{
            this.head = poppedNode.next;
            this.head.prev = null;
            poppedNode.next = null;
        }
        this.length--;
        return poppedNode;
    }

    traverse(){
        let runner = this.head;

        while(runner) { 
            console.log(runner);
            runner = runner.next;
        }
    }
    
}
let dll = new DoublyLinkedList();
dll.push('hi');
dll.push('yo');
dll.push('hehehe');
dll.push('ccc');
dll.shift();
// console.log(dll.tail.next);
console.log(dll);
// dll.traverse();
