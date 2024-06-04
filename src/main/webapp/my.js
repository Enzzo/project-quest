$(document).ready(function(){
    $("#restartButton").on("click", function(){
        load();
    })
    $("#startButton").on("click", function(){
        let name = $("#nameField").val();
        window.location="quest?name=" +name+"&game=start";
    })
})

function load(){
    //window.location="quest?game=start";
    window.location="index.jsp"
}

function select(idx){
    window.location="quest?idx="+idx;
}