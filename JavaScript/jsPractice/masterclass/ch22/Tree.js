class Node {

    constructor(value){
        this.value = value;
        this.children = [];
    }

}

class Tree {
    constructor(){
        this.root = null;
    }
}

let oneTree = new Tree();
oneTree.root = new Node(5);
oneTree.root.children.push(new Node(10));
oneTree.root.children.push(new Node(12));
console.log(oneTree);