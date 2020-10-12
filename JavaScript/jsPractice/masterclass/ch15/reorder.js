// Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]

var reorderLogFiles = function(logs) {
    let letters = [];
    let numbers = [];
   for(let i = 0; i < logs.length; i++){
       console.log(logs[i].split(' ')[1]);
        if(isNaN(parseInt(logs[i].split(' ')[1])) ){
            letters.push(logs[i]);
        }else{
            numbers.push(logs[i]);
        }
    }
    letters = reorderLetters([...letters]);
    return [...letters,...numbers];
};

var reorderLetters = function(letters){
    return letters.sort((a,b)=>{
        let wo1 = a.substring(a.indexOf(" ")+1);
        let wo2 = b.substring(b.indexOf(" ")+1);
        if(wo1.localeCompare(wo2) == 0){
            return a.localeCompare(b);
        }else{
            return wo1.localeCompare(wo2);
        }
    });
    
}

reorderLogFiles(["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"])