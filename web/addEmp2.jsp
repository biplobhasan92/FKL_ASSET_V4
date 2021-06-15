<%-- 
    Document   : entry
    Created on : Mar 3, 2017, 10:49:16 AM
    Author     : ASUS
--%>
<%@include file="linkingScriptAndCss.jsp" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    response.setHeader("Cache-Control", "no-store, must-revalidate");
    if (session.getAttribute("aname") == null) {
        response.sendRedirect("index.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <script src="js/validation.js"></script>
         <script src="js/sweetalert-master/dist/sweetalert.min.js"></script>
        <link rel="stylesheet" type="text/css" href="js/sweetalert-master/dist/sweetalert.css">
        <link href='style.css' rel='stylesheet' type='text/css'/>
         <link href='css/button.css' rel='stylesheet' type='text/css'/>
        <title>Entry Information</title>
        <script>
            document.getElementById("msuccess").setAttribute("style","display: none");
            document.getElementById("msuccess1").setAttribute("style","display: none");
        </script>
    </head>
    <body>
        <%@include file="mainMenu.jsp" %>
        <div class='fix main'>
            <div class="border"></div>
            <!--  #######################   mian menu  ##################################################################-->
            <center>
                <div id="msuccess" >
                    <div class="sweet-alert showSweetAlert visible" data-custom-class="" data-has-cancel-button="true" data-has-confirm-button="true" data-allow-outside-click="false" data-has-done-function="true" data-animation="pop" data-timer="null" style="display: block; margin-top: -179px;"><div class="sa-icon sa-error" style="display: none;">
                            <span class="sa-x-mark">
                                <span class="sa-line sa-left"></span>
                                <span class="sa-line sa-right"></span>
                            </span>
                        </div><div class="sa-icon sa-warning pulseWarning" style="display: block;">
                            <span class="sa-body pulseWarningIns"></span>
                            <span class="sa-dot pulseWarningIns"></span>
                        </div><div class="sa-icon sa-info" style="display: none;"></div><div class="sa-icon sa-success" style="display: none;">
                            <span class="sa-line sa-tip"></span>
                            <span class="sa-line sa-long"></span>

                            <div class="sa-placeholder"></div>
                            <div class="sa-fix"></div>
                        </div><div class="sa-icon sa-custom" style="display: none;"></div><h2>Add New Employee?</h2>
                        <p style="display: block;"><s:property value="message2"/></p>
                        <fieldset>
                            <input tabindex="3" placeholder="" type="text">
                            <div class="sa-input-error"></div>
                        </fieldset><div class="sa-error-container">
                            <div class="icon">!</div>
                            <p>Not valid!</p>
                        </div><div class="sa-button-container" align="center" >
                            <br/>
                            <table align="center" width="50%">
                                <tr width="80%">
                                    <td width="20%">
                                        <s:url id="addM" action="addM" ></s:url>
                                        <s:a href="%{addM}"><h4 align="center" style="font-size: 20px; color: #BFB389;">NO</h4></s:a>

                                        </td >

                                        <td width="20%">
                                        <s:url id="newEmp" action="newEmp" ></s:url>
                                        <s:a href="%{newEmp}"><h4 align="center" style="font-size: 20px; color: #BFB389;">YES</h4></s:a> 
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div></div>
        </center>
      </div>
    </body>
</html>

