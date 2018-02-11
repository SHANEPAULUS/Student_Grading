<%@include file="../include/header.jsp"%>
   <title><spring:message code="AppName"/>&#160;-&#160;<spring:message code="Student"/>&#160;<spring:message code="View"/></title>
   
   <style type="text/css">
      #studentViewTable tr td:nth-child(even){
         padding-left: 20px;
      }
   </style>
</head>
<body>

<div style="text-align: center;">
   <h2><spring:message code="Student"/>&#160;<spring:message code="View"/></h2>
   <hr>
   <br>
</div>

<div style="padding-bottom: 30px;">
   <div class="navigationButton" style="display: inline-block;">
      <c:choose>
         <c:when test="${isOnStudentListView == true}">
            <a href="<c:url value="/studentListView.htm"/>"><spring:message code="Back"/></a>
         </c:when>
         <c:otherwise>
            <a href="<c:url value="/home.htm"/>"><spring:message code="Back"/></a>
         </c:otherwise>
      </c:choose>
   </div>
   <div class="navigationButton" style="display: inline-block; padding-left: 5px;">
      <a href="<c:url value="/studentEdit.htm?pk=${student.pk}"/>"><spring:message code="Edit"/></a>
   </div>
   <div class="navigationButton" style="display: inline-block; padding-left: 5px;">
      <a href="<c:url value="/studentScoreCapture.htm?pk=${student.pk}"/>"><spring:message code="Capture"/>&#160;<spring:message code="Score"/></a>
   </div>
   <div class="navigationButton" style="display: inline-block; padding-left: 5px;">
      <a href="<c:url value="/deleteStudent.htm?pk=${student.pk}"/>"><spring:message code="Delete"/></a></div>
   </div>
</div>

<form:form modelAttribute="student">
   
   <table id="studentViewTable" style="border: 1px solid black;">
      <tr>
         <td><spring:message code="FirstName"/></td>
         <td>${student.firstName}</td>
      </tr>
      <tr>
         <td><spring:message code="LastName"/></td>
         <td>${student.lastName}</td>
      </tr>
      
      <c:if test="${!empty student.age}">
         <tr>
            <td><spring:message code="Age"/></td>
            <td>${student.age}</td>
         </tr>
      </c:if>
   </table>
</form:form>
</body>
</html>
