<%-- 
    Document   : DisplayTime
    Created on : Dec 13, 2016, 11:57:48 AM
    Author     : Heta
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Select Date and Time</title>
    </head>
    <script type="text/javascript">
    function J1()
    {
        document.getElementById('datePicker').valueAsDate = new Date();
    }
    function J2()
    {
        //alert("helo");
        document.getElementById('divtime').style.display="block";
        
    }
    function bookap()
    {
        alert("helo");
    }
     </script>
    <body onload="javascript:J1()">
        <h1>${profname}</h1>
        
     <form:form method="POST" name="aptform">
         
        <input type="date" id="datePicker" onchange="J2()" name="datePicker">     
        
        <div id="divtime" style="display: none;" >
            <p> select time</p>
            <input type="label" id="l1" name="l1" value="9:30">
        </div>
        
       <input type="submit" value="Book an Appointment">
        
     </form:form>
    </body>
</html>