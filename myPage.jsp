<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/venus.css">
<link href="https://fonts.googleapis.com/css?family=Great+Vibes&amp;subset=latin-ext" rel="stylesheet">
<title>マイページ画面</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="top">
<h1>マイページ画面</h1>
</div>
<s:if test="familyName!=null && !familyName.isEmpty()">
	<s:form action="PurchaseHistoryAction">
	<table class="vertical-list-table">
		<tr>
		   <th scope="row"><s:label value="姓"/></th>
		   <td><s:property value="familyName"/></td>
		</tr>

		<tr>
		   <th scope="row"><s:label value="名"/></th>
		   <td><s:property value="firstName"/></td>
		</tr>

		<tr>
		   <th scope="row"><s:label value="ふりがな"/></th>
		   <td><s:property value="familyNameKana" /><span>　</span><s:property value="firstNameKana" /></td>
		</tr>

		<tr>
		   <th scope="row"><s:label value="性別"/></th>
		   <td><s:if test="sex==1">女性</s:if><s:else>男性</s:else></td>
		</tr>

		<tr>
		   <th scope="row"><s:label value="メールアドレス"/></th>
		   <td><s:property value="email"/></td>
		</tr>
	</table>
	<div class="submit_btn_box">
	<s:submit value="購入履歴" class="submit_btn" />
	</div>
	</s:form>
</s:if>
<s:else>
	<div class="info">
		ユーザー情報がありません。
	</div>
</s:else>

</body>
</html>