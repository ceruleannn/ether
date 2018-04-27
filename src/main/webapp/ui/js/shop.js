
function ajaxJson(url,methed,data,possessMethod){
    $.ajax({
        url: url,
        type: methed,
        data: data,
        dataType: 'json',
        success: function(data){
            possessMethod(data);
        },
        error: function(){
            alert("access ajax server failed");
        }
    });
}