<%-- 
    Document   : selectProf
    Created on : Nov 20, 2016, 5:45:42 PM
    Author     : Heta
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Select Professor you want to meet : </title>
    </head>
    <body>
        
        
        <h1>Hi, ${printme}</h1>
        
        <form:form method="post" commandName="pr">
         <form:select path="pname">
            <form:option value="" label="...." />
            <form:options items="${profList}"/>
            
            <input type="submit">
         </form:select>   
            
        </form:form>
        
    </body>
</html>
