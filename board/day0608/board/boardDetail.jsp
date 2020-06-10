<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** BoardDetail Spring_ver01 **</title>
<link rel="stylesheet" type="text/css" href="resources/jqLib/myStyle.css">
</head>
<body>
<h2>** BoardDetail Spring_ver01 **</h2>
<table>
	<tr height="40"><td bgcolor="yellow">Seq</td>
		<td>${Detail.seq}</td></tr>
	<tr height="40"><td bgcolor="yellow">Title</td>
		<td>${Detail.title}</td></tr>
	<tr height="40"><td bgcolor="yellow">Id</td>
		<td>${Detail.id}</td></tr>
	<tr height="40"><td bgcolor="yellow" >Content</td>
		<td><textarea rows="10" cols="40" readonly="readonly">${Detail.content}</textarea></td>
	</tr>
	<tr height="40"><td bgcolor="yellow">Regdate</td>
		<td>${Detail.regdate}</td></tr>
	<tr height="40"><td bgcolor="yellow">Count</td>
		<td>${Detail.cnt}</td></tr>
</table>
<hr>
<c:if test="${logID!=null}">
	<a href="binsertf">[새글등록]</a>&nbsp;
</c:if>
<c:if test="${logID==Detail.id}">
	<a href="bdetail?seq=${Detail.seq}&code=U">[글수정]</a>&nbsp;
	<a href="bdelete?seq=${Detail.seq}">[글삭제]</a><br>
</c:if>

<a href="blist">[BoardList]</a>&nbsp;
<a href="home">Home</a><br>
</body>
</html>