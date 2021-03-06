'use strict';

let index = {
    init: function () {
        $("#btn-save").on("click", () => {
            this.save();
        });
        $("#btn-delete").on("click", () => {
            this.deleteBoard();
        });
        $("#btn-update").on("click", () => {
            this.updateBoard();
        });
    },

    save: function () {
        let data = {
            title: $("#title").val(),
            content: $("#content").val(),
        }

        $.ajax({
            type: "POST",
            url: "/api/board/write",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function (res) {
            alert("글작성이 완료되었습니다.");
            location.href = "/board/list";
        }).fail(function (err) {
            alert(JSON.stringify(err));
        });
    },

    deleteBoard: function () {
        var result = confirm("삭제 하시겠습니까?");
        if(result == true){
            let id = $("#id").text();

            $.ajax({
                type: "DELETE",
                url: "/api/board/delete/" + id,
                dataType: "json"
            }).done(function (res) {
                alert("글삭제가 완료되었습니다.");
                location.href = "/board/list";
            }).fail(function (err) {
                alert(JSON.stringify(err));
            });
        }else{
            alert("취소");
        }
    },

    updateBoard: function () {
            let id = $("#id").text();

            let data = {
                title: $("#title").val(),
                content: $("#content").val()
            }

            $.ajax({
                type: "PUT",
                url: "/api/board/" + id + "/update/",
                data: JSON.stringify(data),
                contentType: "application/json; charset=utf-8",
                dataType: "json"
            }).done(function (res) {
                alert("글수정이 완료되었습니다.");
                location.href = "/board/list";
            }).fail(function (err) {
                alert(JSON.stringify(err));
            });
        },
}
index.init();