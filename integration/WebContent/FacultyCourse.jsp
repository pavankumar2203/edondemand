<%-- 
    Document   : FacultyCourse
    Created on : Nov 26, 2013, 10:04:41 PM
    Author     : heinz
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Select/Add Course</title>
    </head>
    
    <body>
    <input type="hidden" name="alist" value="<%= request.getAttribute("readResult")%>">
    <div class="option_table_wrapper">
	<form action="AddReadCourse" method="POST">
            <select name="course" class="selecter_links">
		<option value="">Select</option>            
                <c:forEach var="item" items="${alist}">
                     <option><c:out value="${item}"/></option>
                </c:forEach>   
            </select>
                
            Course ID: <input type="text" name = "ID">                
            Course Name: <input type="text" name = "name">
            Description: <input type="text" name = "comments">
            
            <input class="btn" type="submit" value="Submit" />               
        </form>              
    </div>
    </body>
</html>
