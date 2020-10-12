class Node {

    constructor(data) {
        this.data = data;
        this.parent = null;
        this.children = [];
    }
}

class Tree {
    

    constructor(node) {
        this.root = node;
    }

    BFS(value=null){
        let queue = [];
        let visited = [];
        // console.log(value);
        // break;
        if(!this.root) return undefined;

        queue.push(this.root);

        while(queue.length) {
            let dequeue = queue.shift();
            if(value !== null && dequeue.data === value) {
                return dequeue;
            }
            visited.push(dequeue);
            if(dequeue.children) {
                for(let i = 0; i < dequeue.children.length; i++) {
                    queue.push(dequeue.children[i]);
                }
            }
        }
        console.log(visited);
    }

    add(node, parent = null){
        if(!this.root){
            this.root = node;
            return this;
        }

        let current = this.root;
        while(current) {
            if(parent === null){
                current.children.push(node);
                return this;
            }


            if(parent !== null) {
                let x = this.BFS(parent.data);
                if(x){
                    x.children.push(node);
                }
                // console.log(x);


                return this;
            }

            }
            
    }

}

const rootNode = new Node(10);

const newTree = new Tree();

newTree.add(rootNode);

newTree.add(new Node(15));

newTree.add(new Node(20), new Node(15));

console.log(newTree.root.children);

