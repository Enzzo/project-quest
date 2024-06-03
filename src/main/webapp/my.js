$(document).ready(function(){
    $("#beginButton").on("click", function(){
        load();
    })
    $("#sendButton").on("click", function(){
        let name = $("#nameField").val();
        window.location="quest?name=" +name;
    })
})

function load(){
    window.location="quest?game=start";
}

function select(idx){
    window.location="quest?idx="+idx;
}