<%-- 
    Document   : index
    Created on : Mar 3, 2017, 7:00:24 AM
    Author     : ASUS
--%>

<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="linkingScriptAndCss.jsp" %>
<%@ page import ="java.sql.*" %>
<%
    String user = request.getParameter("aname");
    String pwd = request.getParameter("password");

    session.setAttribute("user", user);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/validation.js"></script>
        <script src="js/sweetalert-master/dist/sweetalert.min.js"></script>
        <link rel="icon" href="images/icon.gif" type="image/gif" sizes="16x16">
        <link rel="stylesheet" type="text/css" href="js/sweetalert-master/dist/sweetalert.css">
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
                <h3 style="font-family: 'Capriola', cambria;">FKL IT Inventory Management Application</h3>

                <div class='fix form'>
                    <div class="auth-form-header"> 
                        <legend align="center">Log-In</legend>
                    </div>
                    <div class="auth-form-body">

                        <s:form action="login" theme="simple">
                            <table>
                                <tr>
                                    <td>Name    :</td>
                                    <td><s:textfield name="aname" id="aname" cssClass="userId"/></td>
                                </tr>

                                <tr>
                                    <td>Password   :</td>
                                    <td><s:password key="password" name="password"  id="password" cssClass="userId"/></td>
                                </tr>
                            </table>

                            <table align="center">
                                <tr>
                                    <td>
                                        <br/>
                                        <s:submit value="Log In" onmouseover="log()" cssClass="btn btn-primary btn-large"/>
                                    </td>

                                    <td>

                                    </td>
                                </tr>
                            </table>
                        </s:form>
                    </div>
                </div>

                <div id="msuccess"> 
                    <div class="sweet-alert showSweetAlert visible" data-custom-class="" data-has-cancel-button="false" data-has-confirm-button="true" data-allow-outside-click="false" data-has-done-function="false" data-animation="pop" data-timer="null" style="display: block; margin-top: -179px;">
                        
                        <div class="sa-icon sa-error animateErrorIcon" style="display: block;">
                            <span class="sa-x-mark animateXMark">
                                <span class="sa-line sa-left"></span>
                                <span class="sa-line sa-right"></span>
                            </span>
                        </div>
                        
                        <div class="sa-icon sa-warning pulseWarning" style="display: none;">
                            <span class="sa-body pulseWarningIns"></span>
                            <span class="sa-dot pulseWarningIns"></span>
                        </div><div class="sa-icon sa-info" style="display: none;"></div>
                        
                        <div class="sa-icon sa-success" style="display: none;">
                            <span class="sa-line sa-tip"></span>
                            <span class="sa-line sa-long"></span>

                            <div class="sa-placeholder"></div>
                            <div class="sa-fix"></div>
                        </div>
                        
                        <div class="sa-icon sa-custom" style="display: none;"></div><h2>Error!</h2>
                        <p style="display: block;"><s:property value="message"/></p>
                        <fieldset>
                            <input tabindex="3" placeholder="" type="text">
                            <div class="sa-input-error"></div>
                        </fieldset>
                        
                        <div class="sa-error-container">
                            <div class="icon">!</div>
                            <p>You need to write something!</p>
                        </div>
                        
                        <div class="sa-button-container">
                            <button class="cancel" tabindex="2" style="display: none; box-shadow: none;">Cancel</button>
                            <div class="sa-confirm-button-container">
                                <button class="confirm"  onclick="logClose()" tabindex="1" style="background-color: #BFB389; box-shadow: 0px 0px 2px rgba(140, 212, 245, 0.8), 0px 0px 0px 1px rgba(0, 0, 0, 0.05) inset;">OK</button><div class="la-ball-fall">
                                    <div></div>
                                    <div></div>
                                    <div></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <br/>
                <div id="msuccess1" >

                    <div style="color: #000;font-size: 15px; text-shadow: 0 1px 1px rgba(0, 0, 0, 0.75);opacity: 1;">
                        <s:property value="message"/>
                    </div></div> 
                <br/>
            </center>
        </div>
    </body>
</html>

