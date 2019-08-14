/*
A pangram is a sentence that contains every single letter of the alphabet at least once. For example, the sentence "The quick brown fox jumps over the lazy dog" is a pangram, because it uses the letters A-Z at least once (case is irrelevant).

Given a string, detect whether or not it is a pangram. Return True if it is, False if not. Ignore numbers and punctuation.





*/


function isPangram(string) {
    
    let pangramCapitalLettersArray = [];
    let compareArray = [];
    let isPangram = true;

    for(i=65;i<91;i++){
        pangramCapitalLettersArray.push(i);
    }
    let upperCaseInput = string.toUpperCase();
    let newUpperCaseInput = upperCaseInput.replace(/[^A-Z']|\s/g, '');
    
    for (i = 0; i < newUpperCaseInput.length; i++){
        
        compareArray.push(newUpperCaseInput[i].charCodeAt(0));
    }
    let newComp = [...new Set(compareArray)].sort();
    
  
    for(i=0;i<pangramCapitalLettersArray.length;i++){
        if (pangramCapitalLettersArray[i] != newComp[i]){
            isPangram = false;
        }
    }
    console.log(isPangram);
    
}

isPangram('The quick brown fox jumps over the lazy dog.');
isPangram('hello');