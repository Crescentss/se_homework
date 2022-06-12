<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function getValue()
  {
  var x=document.getElementById("myHeader")
  alert("ss")
  x.select();
  bool = document.execCommand("Copy");
  alert("复制成功");
  }
</script>
</head>
<body>
<textarea cols="20" rows="10" id="myHeader">This is a header</textarea>
<input type="button" onclick="getValue()" value="点击复制代码"/>
</body>
</html>