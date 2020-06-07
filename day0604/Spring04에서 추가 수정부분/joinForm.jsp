<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Member Join Form **</title>
<script src="resources/jqLib/jquery-3.2.1.min.js"></script>
<script src="resources/jqLib/memberCheck.js"></script>
<!-- 
** 입력값 확인 하기
=> join, update, login 
=> 외부문서 (memberCheck.js) 에 작성 후 활용
=> 처리방식 : inCheck05 방식 ( focusout(), submit 적용) -->
<script>
// 1) 개별적 오류 확인을 위한 switch 변수 정의
var iCheck=false;

// 2) 개별적 focusout 이벤트리스너 function 작성 : JQuery,
$(function(){
	$('#id').focus();
	$('#id').focusout(function(){
		iCheck=idCheck();
	}); // id_focusout
	
}); // ready	

// 3) 전체적으로 입력 오류 가 없음을 확인하고 submit 여부를 판단

function inCheck() {
	if (iCheck==true)	
		return true;  
	else {
		alert('입력 오류 확인을 하지 않은 항목이 있습니다. 확인 후 전송 하세요~~ '); 	
		return false;
	} // else
} // inCheck()

</script>

<style>
	span {
		color:red; font-style:italic; font-size:x-small; 
	}
</style>

</head>
<body>
<h3>** Member Join Form_inCheck **</h3>
<h3>
<form action="join" method="post">
<table>
	<tr height="40"><td bgcolor="yellow">I D</td>
	<td><input type="text" name="id" id=id size="10"><br>
		<span  id="iMessage"></span></td>
	</tr>
	<tr height="40"><td bgcolor="yellow">Password</td>
	<td><input type="password" name="password" size="10"></td>
	</tr>
	<tr height="40"><td bgcolor="yellow">Name</td>
	<td><input type="text" name="name" value="홍길동" size="10"></td>
	</tr>
	<tr height="40"><td bgcolor="yellow">Level</td>
	<td><select name="lev" id="lev">
		<option value="A">VIP</option>
		<option value="B">나무</option>
		<option value="C">잎새</option>
		<option value="D" selected="selected">새싹</option>
	</select></td>
	</tr>
	<tr height="40"><td bgcolor="yellow">BirthDay</td>
	<td><input type="date" name="birthd" id="birthd" ></td>
	</tr>
	<tr height="40"><td bgcolor="yellow">Point</td>
	<td><input type="text" name="point" value="1000" size="10"></td>
	</tr>
	<tr height="40"><td bgcolor="yellow">Weight</td>
	<td><input type="text" name="weight" value="75.77" size="10"></td>
	</tr>
	<tr height="40"><td bgcolor="yellow">추천인</td>
	<td><input type="text" name="rid"></td>
	</tr>
	<tr height="40"><td></td>
	<td><input type="submit" value="가입" onclick="return inCheck()">&nbsp;&nbsp;
	    <input type="reset"  value="취소">
	</tr>
</table>
</form></h3>
<a href="home"> [Home]</a>
</body>
</html>