function post() {
    var questionId = $("#question_id").val();
    var content = $("#comment_content").val();
    $.ajax({
        type: "post",
        url: "/comment",
        contentType: "application/json",
        // 还要解析成JSON才行，不是简单拼接……
        data: JSON.stringify({
            "parentId": questionId,
            "content": content,
            "type": 1
        }),
        success: function (response) {
            if (response.code == 200){
                $("#comment_section").hide();
            }else{
                alert(response.message)
            }
            console.log(response)
        },
        dataType: "json"
    });
    console.log(questionId)
    console.log(content)
}