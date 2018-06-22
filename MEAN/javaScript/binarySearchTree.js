function BST(){
    this.root = null;    // the root attribute will be assigned to a node later


    BST.prototype.insert = function(data){
    	var node = new Node(data);
  		if(!this.root) {
    		this.root = node;
    		return this;
  		} 
  		var runner = this.root;
  		while(runner){
  			if(data < runner.data){
  				if(runner.left){
  					runner = runner.left;
  					return this;
  				}else{
  					runner.left = node;
  					return this;
  				}
  			}
  			if(data > runner.data){
  				if(runner.right){
  					runner = runner.right;
  				}else{runner.right = node;
  						return this;}
  			}
  		}
	}

 }   	

function Node(val){
    this.data = val;   // the value attribute will be assigned based on user input when a node is instantiated
    this.left = null;   // the left attribute will be assigned to a node later
    this.right = null;  // the right attribute will be assigned to a node later
}
var first = new BST();
first.insert(30).insert(40).insert(10).insert(20);
console.log(first.root);
// first.root = new Node(30);