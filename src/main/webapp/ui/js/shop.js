
function ajaxJson(url,mehtod,data,possessMethod){
    $.ajax({
        url: url,
        type: mehtod,
        data: data,
        dataType: 'JSON',
        success: function(data){
            possessMethod(data);
        },
        error: function(){
            alert("access ajax server failed");
        }
    });
}