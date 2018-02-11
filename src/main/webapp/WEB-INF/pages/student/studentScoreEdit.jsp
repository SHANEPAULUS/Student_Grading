<%@include file="../include/header.jsp"%>
<title><spring:message code="AppName"/>&#160;-&#160;<spring:message code="Student"/>&#160;<spring:message code="Edit"/></title>

<script type="text/javascript">
   function submitScoreEdit(pk){
      var urlQuery = "pk=" + pk;
      var newScore = this.document.getElementById("studentScore").value;
      var oldScore = "${oldScore}" != null ? "${oldScore}" : null;
      
      urlQuery += "&newScore=" + newScore;
      
      if(oldScore != null){
         urlQuery += "&oldScore=" + oldScore;
      }
      
      window.location = "<c:url value="/submitStudentScore.htm?"/>" + urlQuery;
   }
</script>

</head>
<body>

<div style="text-align: center; padding-bottom: 15px;">
   <h2><spring:message code="Student"/>&#160;<spring:message code="Score"/>&#160;<spring:message code="Edit"/></h2>
   <hr>
   <br>
</div>

<form:form modelAttribute="student">

<div>
   <div class="navigationButton" style="display: inline-block;">
      <a href="<c:url value="/studentView.htm?pk=${student.pk}"/>"><spring:message code="Back"/></a>
   </div>
   <div class="navigationButton" style="display: inline-block; padding-left: 15px;">
      <a href="javascript:submitScoreEdit(${student.pk});"><spring:message code="Save"/></a>
   </div>
   
</div>

<div style="display: table; padding-top: 30px;">
   <div style="display: table-row;">
      <div style="display: table-cell;"><spring:message code="Score"/></div>
      <div style="display: table-cell; padding-left: 20px;"><form:input id="studentScore" path="score" maxlength="3" cssStyle="width: 50px;"/></div>
   </div>
</div>

</form:form>

<%@include file="../include/footer.jsp"%>