$(document).ready(function(){
    $("#restartButton").on("click", function(){
        load();
    })
    $("#startButton").on("click", function(){
        let name = $("#nameField").val();
        window.location="quest?name=" +name+"&game=start";
    })
})

function restart(){
    //window.location="quest?game=start";
    window.location="quest?game=start"
}

function select(idx){
    window.location="quest?idx="+idx;
}

function closeGame(){
    window.location="index.jsp";
}