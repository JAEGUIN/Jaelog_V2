'use strict';

let replyIndex = {
    init: function () {
        $("#reply-btn-save").on("click", () => {
            this.replySave();
        });
    },

    replySave: function () {
        let data = {
            content: $("#reply-content").val(),
        }
        let boardId = $("#boardId").val();
        console.log(data);
        console.log(boardId);
        $.ajax({
            type: "POST",
            url: `/api/board/${boardId}/reply`,
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "text"
        }).done(function (res) {
            alert("댓글작성이 완료되었습니다.");
            location.href = `/board/${boardId}`;
        }).fail(function (err) {
            alert(JSON.stringify(err));
        });
    },

    replyDelete: function confirmModal(boardId, replyId) {
        var result = confirm("삭제 하시겠습니까?");
        if(result == true){
            alert("삭제");
            $.ajax({
                        type: "DELETE",
                        url: `/api/board/${boardId}/reply/${replyId}`,
                        dataType: "text"
                    }).done(function (res) {
                        location.href = `/board/${boardId}`;
                    }).fail(function (err) {
                        alert(JSON.stringify(err));
                    });
        }else{
            alert("취소");
        }


    },

}
replyIndex.init();