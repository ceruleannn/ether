$(document).ready(function () {

    $("#login").on("click", function(ev) {


        var phone = $('#phone');
        var phoneReg = /(^1[3|4|5|7|8]\d{9}$)|(^09\d{8}$)/;
        if (!phoneReg.test(phone.val())) {
            phone.get(0).setCustomValidity("无效的手机号!");
        }else {
            phone.get(0).setCustomValidity("");
        }

        var password = $('#password');
        if (password.val().length<6||password.val().length>20){
            password.get(0).setCustomValidity("密码6-20位!");
        }else {
            password.get(0).setCustomValidity("");
        }


    });

    $("#form").submit(function (ev) {

        ev.preventDefault();
        var phone = $.trim($('#phone').val());
        var password = $.trim($('#password').val());

        var data = 'phone='+phone+'&password='+password;
        ajaxJson('http://localhost:8888'+'/user/login.do','GET',data,processLogin);

    });

    function processLogin(data) {
        if (data["code"]==="200"){
            window.location.href = "http://www.baidu.com";
        }else{
            alert("密码错误");
        }
    }
});
