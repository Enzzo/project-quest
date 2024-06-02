$(document).ready(function(){
    $("#beginButton").on("click", function(){
        load();
    })
})

function load(){
    window.location="quest?game=start";
}

function select(idx){
    window.location="quest?idx="+idx;
}