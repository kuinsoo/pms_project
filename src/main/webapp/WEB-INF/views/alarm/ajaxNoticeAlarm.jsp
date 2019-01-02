<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${noticeMap.noticeList}" var="noticeMember" varStatus="i">
	 <li>
	     <i class="icon-star icons"></i>
	     <a href="/noticeView?post_id=${noticeMember.post_id}"><span class="colorRed">${noticeMember.post_title}</span></a>가 등록 되었습니다!
	 </li>
</c:forEach>