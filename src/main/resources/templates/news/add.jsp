<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/classes/templates/core/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻添加</title>
</head>
<body>
	<h1>新闻添加</h1>
	<form id="form1" action="/javaweb/news/saveAdd" method="post">
		<table>
			<tr>
				<td>新闻标题</td>
				<td><input type="text" id="title" name="title" /></td>
			</tr>
			<tr>
				<td>关键字</td>
				<td><input type="text" id="keywords" name="keywords" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="提交" /></td>
			</tr>
		</table>
	</form>
	<hr />
	<a href="${ctx}/news/view">新闻浏览</a>&nbsp;&nbsp;
	<a href="${ctx}/news/add">新闻添加</a>&nbsp;&nbsp;
	<a href="${ctx}/news/modify">新闻修改</a>&nbsp;&nbsp;
	<a href="${ctx}/news/delete">新闻删除</a>&nbsp;&nbsp;

	<script type="text/javascript">
		function submitnews() {
			var title = $('#title').val();
			var keywords = $('#keywords').val();
			document.getElementId('table1').submit();
		}
	</script>
</body>
</html>