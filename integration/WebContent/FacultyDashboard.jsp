<%-- 
    Document   : FacultyDashboard
    Created on : Nov 24, 2013, 12:38:37 PM
    Author     : heinz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Faculty Dashboard</title>
    </head>
    
    <body>
    <div class="option_table_wrapper">
	<form action="FacultyDetails" method="GET">
            <input type="submit" value="View/Edit Profile" />               
        </form>
	<form action="AddReadCourse" method="GET">
            
            <input type="submit" value="Add Courses" />               
        </form>        
        
    </div>
    </body>
</html>
