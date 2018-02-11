<%@include file="../include/header.jsp"%>
   <title><spring:message code="Student"/>&#160;<spring:message code="Search"/></title>
   
   <script type="text/javascript">
      function submitSearch(){
         /*var studentName = this.document.getElementById("studentNameSearch").value;
         window.location = "<c:url value="/studentSearch.htm?studentName="/>" + studentName;*/
      }
   </script>
</head>
<body>

<div style="padding-bottom: 15px;">
   <h2><spring:message code="Search"/>&#160;<spring:message code="Student"/></h2>
   <hr>
   <br>
   
   <%@include file="../include/notificationMessage.jsp"%>
</div>

<div style="display: table;">
   <div style="display: table-row;">
      <div class="navigationButton" style="display: table-cell;">
         <a href="<c:url value="/studentListView.htm"/>"><spring:message code="Back"/></a>
      </div>
   </div>
</div>

<div style="padding-top: 15px; display: table;">
   <div style="display: table-row;">
      <div style="display: table-cell; padding-right: 15px;">
         <spring:message code="Student"/>&#160;<spring:message code="Name"/>
      </div>
      <div style="display: table-cell; padding-right: 15px;">
         <input type="text" id="studentNameSearch" width="150px;"/>
      </div>
      <div class="navigationButton" style="display: table-cell;">
         <a href="javascript:submitSearch();"><spring:message code="Search"/></a>
      </div>
   </div>
</div>
<br>

<%@include file="includeStudentList.jsp"%>

<%@include file="../include/footer.jsp"%>
