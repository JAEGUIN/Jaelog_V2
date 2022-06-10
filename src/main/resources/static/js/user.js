'use strict';

var compare_result = false;
function fn_compare_pw(){
        var pw = $("#password").val();
        var pw2 = $("#password2").val();

        if(pw == pw2){
            compare_result = true;
            $('#s_result').text('비밀번호가 일치합니다.').css({color:"green"});
        }else{
            compare_result = false;
            $('#s_result').text('비밀번호가 일치하지 않습니다 !!').css({color:"red"});
        }
    }

let index = {
    init: function () {
        $("#btn-save").on("click", () => { //this를 바인딩하기 위해 화샬표 함수 사용
            let form = document.querySelector("#needs-validation");
            var pw = $("#password").val();
            var pw2 = $("#password2").val();
            if (form.checkValidity() == false) {
                console.log("회원가입 안됨")
            } if (pw != pw2) {
                console.log("회원가입 안됨")
            }else {
                this.save();
            }
        });
    },

    save: function () {
        let data = { //JavaScript Object
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val(),
            nickname: $("#nickname").val()
        }

        $.ajax({
            type: "POST", //Http method
            url: "/user/api/user", //API 주소
            data: JSON.stringify(data), //JSON으로 변환
            contentType: "application/json; charset=utf-8", //MIME 타입
            dataType: "json" //응답 데이터
        }).done(function (res) {
            alert("회원가입이 완료되었습니다.");
            location.href = "/";
        }).fail(function (err) {
            alert('가입 불가합니다.');
        });
    }
}
index.init();