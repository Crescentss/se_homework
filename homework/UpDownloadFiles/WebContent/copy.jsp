<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
String text = (String)request.getSession().getAttribute("text");
if(text!=null){
System.out.println("jsp:"+text);
%>
<script type="text/javascript">
setTimeout(function () {
	var text=document.getElementById("demo")
	text.select();
	if(document.execCommand("Copy")){
		alert("复制成功");
	};
}, 300);
</script>
<%} %>
<body>
<form action="CopyServlet" method="post" name="form1">
	<textarea cols="20" rows="10" name="text"></textarea>
	<input type="submit" value="粘贴"/>
</form>
<form action="PasteServlet" method="post" name="form2">
	<input type="submit" onclick="getValue" value="复制"/>
</form>
<textarea rows="10" cols="10" id="demo" style="opacity: 0;position: absolute;"><%=text %></textarea>
</body>
</html>