function charCount(inputChars){

    // let xx = inputChars.replace(/(\s|!)/g, '').split('');
    let xx = inputChars.replace(/[^a-z0-9]/g, '').split('');
    let obj = {};
    for(let i = 0; i < xx.length; i++){
        obj[xx[i]] = (obj[xx[i]] || 0) + 1;
    }
    console.log(obj);

}

charCount("aaaaA!  1");