<%-- 
    Document   : index
    Created on : Mar 3, 2017, 7:00:24 AM
    Author     : ASUS
--%>

<%@include file="linkingScriptAndCss.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/validation.js"></script>
        <script src="js/sweetalert-master/dist/sweetalert.min.js"></script>
        <link rel="stylesheet" type="text/css" href="js/sweetalert-master/dist/sweetalert.css">
        <link rel="icon" href="images/icon.gif" type="image/gif" sizes="16x16">
        <link href='style.css' rel='stylesheet' type='text/css'/>
        <link href='css/button.css' rel='stylesheet' type='text/css'/>
        <title>FKL ASSET V4 | User Log-In</title>
    </head>
    <body>
        <div class='fix main'>
            <center>
                <br/><br/>
                <div class='im3'>
                    <img src='img.gif' />
                </div>
                
                <h3 style="font-family: 'Capriola', cambria;">FKL IT Asset Management Application</h3>
                <div class='fix form'>
                    
                    <div class="auth-form-header">
                        <legend align="center">Log-In</legend>
                    </div>
                    
                    <div class="auth-form-body">
                        <s:form action="login" theme="simple">
                            <table>
                                <tr>
                                    <td>Name :</td>
                                    <td><s:textfield name="aname" id="aname" cssClass="userId"/></td>
                                </tr>
                                <tr>
                                    <td>Password :</td>
                                    <td><s:password key="password" name="password"  id="password" cssClass="userId"/></td>
                                </tr>
                            </table>
                            <table align="center">
                                <tr>
                                    <td>
                                        <br/>
                                        <s:submit value="Log In"  cssClass="btn btn-primary btn-large"/>
                                    </td>
                                    <td>

                                    </td>
                                </tr>
                            </table>
                        </s:form>
                    </div>
                </div>
                <br/>
                <div style="color: #000;font-size: 15px; text-shadow: 0 1px 1px rgba(0, 0, 0, 0.75);opacity: 1;">
                    <s:property value="message"/>
                </div>
                <br/>
            </center>
        </div>
    </body>
</html>