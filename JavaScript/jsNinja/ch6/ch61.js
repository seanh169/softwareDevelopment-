async function hello(num){
    try{
        let promise = new Promise((resolve, reject) => {
            if(num == 1){
                reject("failed");
            }
            setTimeout(() => resolve("done!"), 1000)
          });
          let result = await promise;
        console.log(result);
        console.log('hello');
    }catch(e){
        console.log(e)
    }
}

hello(1);