
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

/*
$(document).ready(function() {

    //GET
    $.ajax({
        method: "GET",
        url: 'http://localhost:8080/student/'
    }).done(
        function (data) {
            $('body').append(data.email).append(data.firstName).append(data.lastName)
        });
    //POST
    $.ajax({
        method: "POST",
        url:'http://localhost:8080/student/',
        data: {
            firstName:'Kiki',
            lastName:'Lypart',
            email:'lypart@Mail.com'
        }
    }).done(function (data){
        alert('POST saved'+data)
    });

});
*/



