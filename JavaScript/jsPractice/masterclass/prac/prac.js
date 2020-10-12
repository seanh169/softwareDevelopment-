function ListNode(val, next) {
    this.val = (val===undefined ? 0 : val)
    this.next = (next===undefined ? null : next)

    
}


var addTwoNumbers = function(l1, l2) {
   
    let returnList = new ListNode(0);
    let pointerOne = l1;
    let pointerTwo = l2;
    let current = returnList;
    let carry = 0;
    while(pointerOne !== null || pointerTwo !== null) {
        let x = pointerOne !== null ? pointerOne.val : 0;
        let y = pointerTwo !== null ? pointerTwo.val : 0;
        let sum = x + y + carry;
        
        carry = Math.floor(sum / 10);

        current.next = new ListNode(((sum) % 10));
        current = current.next;
        if(pointerOne !== null){
            pointerOne = pointerOne.next;
        }
        if(pointerTwo !== null){
            pointerTwo = pointerTwo.next;
        }
    }
    if(carry > 0){
        current.next = new ListNode(1);
    }

    return returnList.next;
 };









// var addTwoNumbers = function(l1, l2) {
   
//    let reverseListOne = reverseLinkedList(l1);
//    let reverseListTwo = reverseLinkedList(l2);

//    let holderArr = [];
//    let holderArrTwo = [];

//    while(reverseListOne !== null){
//        holderArr.push(reverseListOne.val);
//        reverseListOne = reverseListOne.next;
//    }

//    while(reverseListTwo !== null){
//     holderArrTwo.push(reverseListTwo.val);
//     reverseListTwo = reverseListTwo.next;
//     }
//     let oneNumber = Number.parseInt(holderArr.join(""));
//     let twoNumber = Number.parseInt(holderArrTwo.join(""));
//     let totalNum = oneNumber + twoNumber;
//     let parsedStr = "" + totalNum + "";
//     let splitUpstring = parsedStr.split("");
//     let reversedStr = splitUpstring.reverse();
//     let returnList = new ListNode(Number.parseInt(splitUpstring[0]))
//     let runner = returnList;
//     for(let i = 1 ; i < reversedStr.length; i++){
//         while(runner.next){
//             runner= runner.next;
//         }
//         runner.next = new ListNode(Number.parseInt(reversedStr[i]));
//     }
//    return returnList;
// };


function reverseLinkedList(linkedList){
    let prev = null;
    let curr = linkedList;
    let next = null;

    while(curr !== null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }

    return prev;
}
// addTwoNumbers(l1, l2)

let l1 = new ListNode(2, new ListNode(4));
l1.next.next = new ListNode(3);
let l2 = new ListNode(5, new ListNode(6));
l2.next.next = new ListNode(4);

console.log(addTwoNumbers(l1, l2))
// console.log(18 /9);
// reverseLinkedList(l1);
// console.log(l1);