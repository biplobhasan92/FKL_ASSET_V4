<%-- 
    Document   : addAttachFailed
    Created on : 05-Dec-2020, 15:02:21
    Author     : Hasan
--%>

<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="linkingScriptAndCss.jsp" %>

<!DOCTYPE html>
<html>
    <s:if test="%{#session.master == null && #session.admin == null && #session.entry == null}">
        <jsp:forward   page="index.jsp" />
    </s:if>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>File Upload Error</title>
    </head>

    <body>
        <%@include file="mainMenu.jsp" %>   
        <div>
            <h2 style="color: red">There has been an error in uploading the file.</h2>
        </div>
        
        <div style="margin-top: 40px; font-size: 30px; color: #990033;">
            <s:property value="msg" />
        </div>
   </body>
</html>
