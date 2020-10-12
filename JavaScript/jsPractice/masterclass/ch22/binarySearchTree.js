class Node {
    constructor(value, left = null, right = null) { 
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

class BinarySearchTree { 

    constructor(){
        this.root = null;
    }

    insert(value){
        let newNode = new Node(value);
        if(this.root === null) {
            this.root = newNode;
            return this;
        }


        let current = this.root;
        while(true){
        if(value === current.value) {
            return this;
        }
        if(value < current.value) {
            if(current.left === null) { 
                current.left = newNode;
                return this;
            }
            current = current.left;
        }
        
        if(value > current.value){
            if(current.right === null) {
                current.right = newNode;
                return this;
            }
            current = current.right;
            }
        }
           
        
    }

    find(value){
        let current = this.root;
        while(current){
            
            if (current === null )return false;

            if(value < current.value){
                
                current = current.left;
                if(current === null) return false;
                if (current.value === value){
                    return true;
                }
            }

            if(value > current.value){
                
                current = current.right;
                if(current === null) return false;
                if (current.value === value){
                    return true;
                }
            }
        }
    }

    bfs() {
        let queue = [];
        let visited = [];
        if(!this.root) return false;
        queue.push(this.root);
        while(queue.length) {
            let dequeued = queue.shift();
            visited.push(dequeued);
            if(dequeued.left) {
                queue.push(dequeued.left)
            }
            if(dequeued.right) {
                queue.push(dequeued.right)
            }
        }

        return visited;
    }

    dfsPreOrder(){

        let visited = [];
        let current = this.root;
        
        const traverse = (node) => {
            visited.push(node);
            if(node.left) traverse(node.left)
            if(node.right) traverse(node.right)
        }
        traverse(current);
        return visited;
    }

}

let tree = new BinarySearchTree();
tree.insert(41);
tree.insert(20);
tree.insert(30);
tree.insert(15);
tree.insert(42);
tree.insert(22);
console.log(tree.dfsPreOrder());

// console.log(tree);
// console.log(tree.root.left.right);
