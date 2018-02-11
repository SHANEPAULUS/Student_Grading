<%@include file="../include/header.jsp"%>
   <title><spring:message code="AppName"/>&#160;-&#160;<spring:message code="Student"/>&#160;<spring:message code="Edit"/></title>
   
   <c:url value="/resources/css/student_grading.css" var="mainStyles"/>
   <link href="${mainStyles}" rel="stylesheet"/>
</head>
<body>

<h2><spring:message code="Student"/>&#160;<spring:message code="Edit"/></h2>
<hr>
<br>

<form:form modelAttribute="student">
   
   <div>
      <div class="navigationButton" style="display: inline-block;">
         <c:choose>
            <c:when test="${cameFromStudentPage == true}">
               <a href="<c:url value="/studentView.htm?pk=${cameFromStudentPk}"/>"><spring:message code="Back"/></a>
            </c:when>
            <c:otherwise>
               <a href="<c:url value="/"/>"><spring:message code="Back"/></a>
            </c:otherwise>
         </c:choose>
      </div>
      
      <input class="navigationButton" type="submit" value="<spring:message code="Save"/>"/>
   </div>

   <div style="padding: 10px;">
      <form:errors path="*"/>
   </div>
   
   <table>
      <tr>
         <td><spring:message code="FirstName"/></td>
         <td><form:input path="firstName" maxlength="30"/></td>
      </tr>
      <tr>
         <td><spring:message code="LastName"/></td>
         <td><form:input path="lastName" maxlength="30"/></td>
      </tr>
      <tr>
         <td><spring:message code="Age"/></td>
         <td><form:input path="age"/></td>
      </tr>
   </table>
</form:form>

<%@include file="../include/footer.jsp"%>