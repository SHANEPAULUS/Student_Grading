<%@include file="../include/header.jsp"%>
   <title><spring:message code="AppName"/>&#160;-&#160;<spring:message code="Student"/>&#160;<spring:message code="View"/></title>
</head>
<body>

<div style="text-align: center">
   <h2><spring:message code="Students"/></h2>
   <hr>
   <br>
</div>

<div style="display: table; padding-bottom: 30px;">
   <div style="display: table-row;">
      <div class="navigationButton" style="display: table-cell;"><a href="<c:url value="/home.htm"/>"><spring:message code="Back"/></a></div>&#160;
      <div class="navigationButton" style="display: table-cell;"><a href="<c:url value="/studentSearch.htm"/>"><spring:message code="Search"/></a></div>
   </div>
</div>

<%@include file="includeStudentList.jsp"%>

<%@include file="../include/footer.jsp"%>