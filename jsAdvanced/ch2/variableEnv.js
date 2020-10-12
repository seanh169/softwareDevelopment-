let hello = 'hello';

function sayHello() {
    let hello = 'woah';
    this.hello = 'woah';
    console.log(this.hello);
}

const sayHi = () => {
    this.hello = 'yo';

    console.log(this.hello)
    this.
}

sayHello();

sayHi();