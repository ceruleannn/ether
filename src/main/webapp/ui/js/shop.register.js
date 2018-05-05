$(document).ready(function () {
    // 0 for get code 1 for sign up
    // to check which submit button was clicked;
    var curClick = 0;

    $("#signup").on("click", function(ev) {

        curClick = 1;

        var username = $('#username');
        if (username.val().length<6||username.val().length>20){
            username.get(0).setCustomValidity("用户名6-20位!");
        }else {
            username.get(0).setCustomValidity("");
        }

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

        var repassword = $('#repassword');
        if (repassword.val()!==password.val()){
            repassword.get(0).setCustomValidity("两次输入的密码不匹配");
        }else {
            repassword.get(0).setCustomValidity("");
        }

    });

    $("#form").submit(function (ev) {

        var phone = $.trim($('#phone').val());
        ev.preventDefault();
        if (curClick===0){
            ajaxJson('/u/sms?phone='+phone+'&action=register','GET',null,processCode);
        }
        else{

            var username = $.trim($('#username').val());
            var code = $.trim($('#code').val());
            var password = $.trim($('#password').val());

            var realname = $.trim($('#realname').val());
            var sex = $.trim($('#sex').val());
            var address = $.trim($('#address').val());
            var mail = $.trim($('#mail').val());


            var data = 'phone='+phone+'&username='+username+'&code='+code+'&password='+password;
            ajaxJson('/u/sign.do','GET',{phone:phone,username:username,code:code,password:password,realname:realname,sex:sex,address:address,mail:mail},processRegister);
        }
    });

    $("#getcode").bind("click",function () {
        $("#codesubmit").click();
    });

    $("#codesubmit").on("click", function(ev) {

        curClick = 0;

        var phone = $('#phone');
        var phoneReg = /(^1[3|4|5|7|8]\d{9}$)|(^09\d{8}$)/;
        if (!phoneReg.test($.trim(phone.val()))) {
            $('#phone').get(0).setCustomValidity("无效的手机号");
        }else {
            $('#phone').get(0).setCustomValidity("");
        }

    });


    function processCode(data) {
        if (data["code"]!=="200"){
            alert("手机号已经注册");
        }
    }

    function processRegister(data) {
        if (data["code"]!=="200"){
            alert("验证码错误");
        }else{
            window.location.href="/index";
        }
    }

})