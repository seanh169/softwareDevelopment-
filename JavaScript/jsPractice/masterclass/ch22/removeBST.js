var deleteNode = function(root, key) {
    var pre; 
    var cur=root;
    var tmp;
    
    while(cur) {
        if(cur.val > key) {
            pre = cur;
            cur = cur.left;
        } else if(cur.val < key) {
            pre = cur;
            cur = cur.right;
        } else {
            if(!cur.left || !cur.right) {
                if(!pre) {
                    return cur.left || cur.right;
                }
                if(pre.left === cur) {
                    pre.left = cur.left || cur.right;
                } else {
                    pre.right = cur.left || cur.right;
                }
                return root;
            }
            tmp = cur;
            pre = cur;
            cur = cur.right;
            while(cur.left) {
                pre = cur;
                cur = cur.left;
            }
            tmp.val = cur.val;
            key = cur.val;
        }
    }
    return root;
    };