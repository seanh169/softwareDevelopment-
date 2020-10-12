const list = new Array(60000).join('1.1').split('.');

function removeItemsFromList() {
    // if(list.length < 50000) return this;
    console.log(list.length)
    var item = list.pop();
 
    if (item) {
        setTimeout(removeItemsFromList, 0);
    }
};
 
removeItemsFromList();
