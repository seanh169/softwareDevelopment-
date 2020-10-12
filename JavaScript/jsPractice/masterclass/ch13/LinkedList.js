class Node {

    constructor(value) {
        this.value = value;
        this.next = null;
    }

}

class SinglyLinkedList { 

    constructor () {

        this.head = null;
        this.tail = null;
        this.length = 0;

    }

    push(val) {
        let newNode = new Node(val);
        if(this.head === null) {
            this.head = newNode;
            this.tail = newNode;
        }else{
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.length++;
        return this;
    }
    pop(){
        if(!this.head) {
            return undefined;
        }

        let runner = this.head;
        while(runner){
            if(!runner.next.next) {
                let temp = runner.next;
                runner.next = null;
                this.tail = runner;
                this.length--;
                return temp;
            }
            runner = runner.next;

        }
    }

    shift(){
        let temp = this.head;
        this.head = this.head.next;
        this.length--;
        return temp;
    }
    unshift(val){
        let newNode = new Node(val);
        if(!this.head){
            this.head = newNode;
        }else{
            let temp = this.head;
            this.head = newNode;
            this.head.next = temp;
        }
        this.length++;
        return newNode;
        
    }
    get(idx) {
        if( idx < 0 || idx >= this.length) {
            return null;
        }else{
            let runner = this.head;
            let counter = 0;
            while(runner){
                if(counter == idx) {
                    return runner;
                }else{
                    runner = runner.next;
                    counter++;
                }  
            }
        }
    }

    insert(idx, value) {

        let newNode = new Node(value);
        if( idx < 0 || idx > this.length) {
            return null;
        }else if(idx == this.length){
            this.push(newNode);
        }else{
            let runner = this.head;
            let counter = 0;
           
            while(runner){
                
                if((counter+1) == idx && (counter+1)) {
                    let temp = runner.next;
                    newNode.next = temp;
                    runner.next = newNode;
                    this.length++;
                    return this;
                }else{
                    runner = runner.next;
                    counter++;
                }  
            }
        }

    }

    set(idx, value) {

        if( idx < 0 || idx >= this.length) {
            return null;
        }else{
            let runner = this.head;
            let counter = 0;
           
            while(runner){
                
                if((counter+1) == idx) {
                    runner.next.value = value;
                    return this;
                }else{
                    runner = runner.next;
                    counter++;
                }  
            }
        }

    }

    remove(idx) { 
        if( idx < 0 || idx >= this.length) {
            return null;
        }else{
            let runner = this.head;
            let counter = 0;

            while(runner){
                
                if((counter+1) == idx && (counter+1) !== (this.length-1)) {
                    runner.next = runner.next.next;
                    this.length--;
                    return this;
                }else if(((counter+1) == idx )&& ((counter+1) == (this.length-1))){
                    this.pop();
                    return this;
                }else{
                    runner = runner.next;
                    counter++;
                }  
            }
        }
    }

    reverse() {
        let temp = this.head;
        this.head = this.tail;
        this.tail = temp; 
       
        let prev = null;
        let next;

        // let runner = temp;

       for(let i = 0; i < this.length; i++) {
           next = temp.next;
           temp.next = prev;
           prev = temp;
           temp = next;
       }

    }

    traverse(){
        if (this.head) {
            let runner = this.head;
            while(runner) {
                console.log(runner);
                runner = runner.next;
                
            }
        }
    }

}
let sll = new SinglyLinkedList();
sll.push("hi");
sll.push("hello");
sll.push("ho");
sll.unshift('yo');
// console.log(sll.get(3));
// console.log(sll.length);
sll.insert(4, 'dodod');
// sll.remove(3);
// sll.traverse();
sll.reverse();
sll.traverse();

// console.log(sll);