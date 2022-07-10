// (1) 회원정보 수정
function update(userId, event) {
    let data = $("#profileUpdate").serialize(); //profileUpdate ID를 가진 form태그에 담긴 값들을 serialize하여 저장

    console.log(data);

    $.ajax({
        type: "put",
        url : `/api/user/${userId}`,
        data: data,
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        dataType: "json"
    }).done(res=>{ // HttpStatus 상태코드 200번대
        console.log("성공", res);
        location.href = `/user/${userId}`;
    }).fail(error=>{ // HttpStatus 상태코드 200번대가 아닐 때
        console.log("update 실패");
    })

}