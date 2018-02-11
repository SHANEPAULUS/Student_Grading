<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:if test="${fn:length(studentList) > 0}">
   <table style="border: 1px solid black;">
      <tr>
         <th><spring:message code="Name"/></th>
         <th><spring:message code="Age"/></th>
         <th><spring:message code="Score"/></th>
      </tr>
      
      <c:forEach var="stud" items="${studentList}">
         <tr>
            <td><a href="<c:url value="/studentView.htm?pk=${stud.pk}&isOnStudentListView=true"/>" target="_blank">${stud.firstName}&#160;${stud.lastName}</a></td>
            <td>${stud.age}</td>
            <td>
               <c:choose>
                  <c:when test="${!empty stud.score}">
                     ${stud.score}
                  </c:when>
                  <c:otherwise>
                     <spring:message code="NotYetCaptured"/>
                  </c:otherwise>
               </c:choose>
            </td>
         </tr>
      </c:forEach>
   </table>
</c:if>