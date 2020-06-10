<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** BoardList Spring Paging 1. **</title>
<link rel="stylesheet" type="text/css" href="resources/jqLib/myStyle.css">
<script src="resources/jqLib/jquery-3.2.1.min.js"></script>
<script src="resources/jqLib/axTest01.js"></script>
</head>
<body>
<h2>** BoardList Spring Paging 1. **</h2>
<img  src="resources/image/bar.gif"><br>
<table width=800 border="0">
<tr align="center" height=30 bgcolor="PowderBlue">
	<td>Seq</td><td>Title</td><td>ID</td>
	<td>RegDate</td><td>Count</td>
</tr>
<c:forEach var="mm" items="${Banana}">
	<tr align="center" height=30>
	<td>${mm.seq}</td>
	<td  align="left">
		<!-- 댓글의 들여쓰기 -->
		<c:if test="${mm.indent>0}">
			<c:forEach begin="1" end="${mm.indent}">
				<span>&nbsp;&nbsp;</span>
			</c:forEach>
			<span style="color:orange">re..</span>
		</c:if>
		
		<!--  조회수 증가   -->
		<c:if test="${logID!=null}">
		    <!-- 조회수 증가를 위해 글쓴이의 id 도 포함   -->
			<a href="bdetail?seq=${mm.seq}&id=${mm.id}">${mm.title}</a>
		</c:if>
		<c:if test="${logID==null}">
			${mm.title}
		</c:if>
	</td>
	<td>${mm.id}</td>
	<td>${mm.regdate}</td><td>${mm.cnt}</td>
	</tr>
</c:forEach>
</table>

<c:if test="${message != null}">
 => ${message}<br>
</c:if>
<hr>
<c:if test="${logID!=null}">
	<a href="binsertf">[새글등록]</a>&nbsp;
</c:if>
<a href="home">Home</a><br>

<!-- Paging 추가 
=> totalPageNo 까지 pageNo 를 출력함
   현재 Page 는 link 안되고, 나머지 Page는 클릭시에  요청 처리되어야함. 	
-->
<hr>
<div align="center">
<c:forEach  var="i"  begin="1" end="${totalPageNo}">
	<c:choose>
		<c:when test="${i==currPage}">
			<font size="5" color="Orange">${i}</font>
		</c:when>
		<c:otherwise>
			<a href="plist?currPage=${i}">${i}</a>
		</c:otherwise>
	</c:choose>
</c:forEach>
</div>
</body>
</html>