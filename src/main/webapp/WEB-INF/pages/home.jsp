<%@include file="include/header.jsp"%>
   <title><spring:message code="Welcome"/>&#160;to&#160;<spring:message code="AppName"/></title>
   
</head>
<body>
<div style="text-align: center">
   <h2><spring:message code="Welcome"/>&#160;to&#160;<spring:message code="AppName"/></h2>
   <hr>
</div>
<br>

<%@include file="include/notificationMessage.jsp"%>

<table>
   <tr>
      <td class="navigationButton"><a href="<c:url value="/studentEdit.htm?pk=${NEW_OBJECT_PK}"/>"><spring:message code="Create"/>&#160;<spring:message code="Student"/></a></td>
   </tr>
   
   <c:if test="${hasStudentsCaptured == true}">
      <tr>
         <td class="navigationButton"><a href="<c:url value="/studentListView.htm"/>"><spring:message code="View"/>&#160;<spring:message code="All"/>&#160;<spring:message code="Students"/></a> </td>
      </tr>
   </c:if>
</table>

<%@include file="include/footer.jsp"%>