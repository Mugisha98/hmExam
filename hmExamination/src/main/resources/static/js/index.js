
function captcha(){
    let a = Math.floor(Math.random()*100);
    let b = Math.floor(Math.random()*100);
    let mathQuiz = window.prompt("Confirm you're not a robot by answering"+"\n\t\t\t"+a+" + "+b);
    let result = a + b;
    if(parseInt(mathQuiz) === result){
        return console.log(result);
    }else{
        return mathQuiz;
    }
}