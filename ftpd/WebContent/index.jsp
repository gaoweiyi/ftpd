<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,java.net.*,
    java.text.*,java.io.*,
    com.inputabc.ftpd.service.*,com.inputabc.ftpd.service.impl.*,
    org.springframework.web.context.*,com.inputabc.ftpd.constant.*,
    com.inputabc.ftpd.entity.*"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String basePath = C.configCache.get("basePath").getObjectValue().toString();
	pageContext.setAttribute("basePath",basePath);

%>
<!-- ###### -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="viewport" content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<title>${mainPath } - 的索引</title>
<!-- <link rel="stylesheet" href="res/css/w3.css"> -->
<script type="text/javascript" src="res/js/jquery-1.11.0.min.js"></script>
<style>
	a{
		color:#2c3e50;
		font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Helvetica, Arial, sans-serif, 'Apple Color Emoji', 'Segoe UI Emoji', 'Segoe UI Symbol';
		
	}
	body{
		color:#2c3e50;
		font-family:system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Helvetica, Arial, sans-serif, 'Apple Color Emoji', 'Segoe UI Emoji', 'Segoe UI Symbol';
		font-size:14px
	}
</style>
</head>
<body>
	<div id="header">
		<h1 id="title">Index of ${mainPath }</h1>
		<script type="text/javascript">
			var title = $("#title").text();
			var path = title.substring("Index of ".length);
			var singlePathArr = path.split("/");
			var newPathDisplay = "";//显示到标题上的路径html代码，是一些超链接
			var currentSinglePath = "";
			var currentSinglePathHtml;
			//if(singlePathArr[1].length!=0){//Windows系统下打开
				$.each(singlePathArr,function(index,ele){
					if(index==0)
						return;
					currentSinglePath+="/"+ele;
					currentSinglePathHtml = "<a href='fnodeController.do?openDir&path="+encodeURIComponent(currentSinglePath.substring(1))+"' style='text-decoration:none'>"+"/"+ele+"</a>";
					newPathDisplay+=currentSinglePathHtml;
				})
				$("#title").html("Index of "+newPathDisplay);
		//	}//Windows系统下打开
		</script>
	</div>
	<div id="container">
		<table>
			<tr>
				<th><a href="fnodeController.do?reloadDir&isChildPath=${isChildPath }&sortMethod=1&path=${mainPath }">名称</a>&nbsp;&nbsp;</th>
				<th><a href="fnodeController.do?reloadDir&isChildPath=${isChildPath }&sortMethod=2&path=${mainPath }">修改日期</a>&nbsp;&nbsp;</th>
				<th><a href="fnodeController.do?reloadDir&isChildPath=${isChildPath }&sortMethod=3&path=${mainPath }">类型</a>&nbsp;&nbsp;</th>
				<th><a href="fnodeController.do?reloadDir&isChildPath=${isChildPath }&sortMethod=4&path=${mainPath }">大小</a>&nbsp;&nbsp;</th>
			</tr>
			<tr>                         
				<th colspan="4"><hr></th>
			</tr>
			<c:if test="${isChildPath }">
				<tr>
					<td colspan="4">
						<img src="res/img/icon/back.gif"/>
						<a href="fnodeController.do?backDir&currentPath=${mainPath }">返回上一页</a>
					</td>
				</tr>
			</c:if>
			
			<c:forEach items="${fnodes }" var="fnode" varStatus="sta">
				<%
					String mainPathEncoded = URLEncoder.encode(((FNode)pageContext.getAttribute("fnode")).getMainPath(), "UTF-8");
					pageContext.setAttribute("mainPathEncoded", mainPathEncoded);
				%>
				<tr>
					<td>
						<img src="res/img/icon/${fnode.imageName }.gif">
						<c:choose>
							<c:when test="${fnode.type==1 }">
								<a href="fnodeController.do?openDir&path=${mainPathEncoded}">${fnode.name}/</a>
							</c:when>
							<c:otherwise>
								<a id="${fnode.name }" href="javascript:;" name="dlFileLink" onclick="dlFile('${mainPathEncoded }')">${fnode.name }</a>
								<script type="text/javascript">
									$("#container [id='${fnode.name}']").attr('href',"fnodeController.do?dlFile&path="+'${mainPathEncoded }'.replace("+","%2B"));;
								</script>
							</c:otherwise>
						</c:choose>
						&nbsp;&nbsp;
					</td>
					<td>
						${fnode.modified }
						&nbsp;&nbsp;
					</td>
					<td>
						<c:choose>
							<c:when test="${fnode.type==1 }">
								文件夹
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${fnode.ex ==null or fnode.ex eq \"\"}">
										文件
									</c:when>
									<c:otherwise>
										${fnode.ex }&nbsp;文件
									</c:otherwise>
								</c:choose>
																
							</c:otherwise>
						</c:choose>
						&nbsp;&nbsp;
					</td>
					<td>
						<c:choose>
							<c:when test="${fnode.type==1 }">
								-
							</c:when>
							<c:otherwise>
								${fnode.displaySize }
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="4"><hr></td>
			</tr>
		</table>
	</div>
	
	<div id="footer">
		<address>Your ip is ${pageContext.request.remoteHost }</address>
	</div>
	<script type="text/javascript">
		var basePath = "${basePath}";
		function dlFile(mainPath){
			location.href = "fnodeController.do?dlFile&path="+mainPath.replace("+","%2B");
		}
		
	</script>
</body>
</html>
