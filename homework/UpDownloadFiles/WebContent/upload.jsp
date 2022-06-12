<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
String files[] = (String[])request.getSession().getAttribute("files");
int count = 0;
if(files!=null){
	for(int i=0;i<20;i++){
		if(files[i]!=null){
			count++;
		}
	}
}
%>
<body>
<form action="UploadServlet" method="post" enctype="multipart/form-data">
<table width="600px" align="center">
	<tr>
		<td>上传文件</td>
		<td><input type="file" name="myfile"></td>
	</tr>
	<tr>
		<td><input type="submit" value="上传"/></td>
	</tr>
</table>
<br><br><br>
<table width="600px" align="center">
	<tr>
		<td>文件ID</td>
		<td>文件名</td>
		<td>文件类型</td>
		<td>操作</td>
	</tr>
	<%for(int i=0;i<count;i++){ %>
	<tr>
		<td><%=i+1 %></td>
		<td><%=files[i] %></td>
		<td><%=files[i].substring(files[i].lastIndexOf(".")+1) %></td>
		<td><a href="DownloadServlet?filename=<%=files[i] %>">下载</a></td>
	</tr>
	<%} %>
</table>
</form>
</body>
</html>