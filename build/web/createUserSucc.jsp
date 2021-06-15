<%-- 
    Document   : entry
    Created on : Mar 3, 2017, 10:49:16 AM
    Author     : ASUS
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@include file="linkingScriptAndCss.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    response.setHeader("Cache-Control", "no-store, must-revalidate");
    if (session.getAttribute("aname") == null){
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

            // document.getElementById("msuccess").setAttribute("style","display: none");
            // document.getElementById("msuccess1").setAttribute("style","display: none");

        </script>


    </head>
    <body>

        <%@include file="mainMenu.jsp" %>
        <div class='fix main'> <!--  main DIV is Start  -->   
                
            <div class="border"></div>
            <!--  #######################   mian menu  ##################################################################-->
                <center>
                    <div class='fix form'>
                        <div class="auth-form-header"> 
                            <legend align="center">User Management</legend>
                        </div>
                        <div class="auth-form-body">
                            <div id="msuccess"> 
                                <div class="sweet-alert showSweetAlert visible" data-custom-class="" data-has-cancel-button="false" data-has-confirm-button="true" data-allow-outside-click="false" data-has-done-function="false" data-animation="pop" data-timer="null" style="display: block; margin-top: -179px;"><div class="sa-icon sa-error" style="display: none;">
                                        <span class="sa-x-mark">
                                            <span class="sa-line sa-left"></span>
                                            <span class="sa-line sa-right"></span>
                                        </span>
                                    </div><div class="sa-icon sa-warning" style="display: none;">
                                        <span class="sa-body"></span>
                                        <span class="sa-dot"></span>
                                    </div><div class="sa-icon sa-info" style="display: none;"></div><div class="sa-icon sa-success animate" style="display: block;">
                                        <span class="sa-line sa-tip animateSuccessTip"></span>
                                        <span class="sa-line sa-long animateSuccessLong"></span>

                                        <div class="sa-placeholder"></div>
                                        <div class="sa-fix"></div>
                                    </div><div class="sa-icon sa-custom" style="display: none; background-image: url(&quot;example/images/thumbs-up.jpg&quot;); width: 80px; height: 80px;"></div><h2>Success!</h2>
                                    <p style="display: block;"><s:property value="message"/></p>
                                <fieldset>
                                    <input tabindex="3" placeholder="" type="text">
                                    <div class="sa-input-error"></div>
                                </fieldset><div class="sa-error-container">
                                    <div class="icon">!</div>
                                    <p>You need to write something!</p>
                                </div><div class="sa-button-container">
                                    <button class="cancel" tabindex="2" style="display: none; box-shadow: none;">Cancel</button>
                                    <div class="sa-confirm-button-container">
                                        <!--<button class="confirm"  onclick="addMErrClose()" tabindex="1" style="background-color: #BFB389; box-shadow: 0px 0px 2px rgba(140, 212, 245, 0.8), 0px 0px 0px 1px rgba(0, 0, 0, 0.05) inset;">OK</button>-->

                                        <s:url id="logout"      action="logout" ></s:url>
                                        <s:a href="%{logout}"  >
                                            <h4 style="font-size: 20px; color: #BFB389;">Back To Home</h4></s:a>
                                            <div class="la-ball-fall">
                                                <div></div>
                                                <div></div>
                                                <div></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        <s:form  theme="simple">
                            <table>
                                <tr>   

                                <tr>
                                    <td>User Name:</td>
                                    <td><s:textfield name="aname" id="aname" cssClass="userId"/></td>
                                    <td>
                                        <s:submit value="Search" action="searchAdmn" onmouseover="/addEmp()" cssClass="btn btn-primary btn-large">
                                            <s:param name="aname" value="aname" />
                                        </s:submit>
                                    </td>
                                </tr>

                                <tr>
                                    <td>User Password   :</td>
                                    <td><s:textfield name="password"  id="password" cssClass="userId"/></td>
                                </tr>         

                                <tr>        
                                    <td>User Right:</td>
                                    <%--<td><s:textfield name="dept" id="dept" cssClass="userId"/></td>--%>
                                    <td><s:select name="right" id="right" list="{'Entry User', 'Admin', 'Super Admin','Inactive'}"
                                              headerKey="" headerValue="---Select Type---" cssClass="select"/></td>
                                </tr>
                            </table>

                            <table>
                                <td align="center">
                                    <s:submit value="Save" onmouseover="/addEmp()" action="saveAdmn" cssClass="btn btn-primary btn-large"/>
                                </td>  
                                <td align="center">
                                    <s:submit value="Update" onmouseover="/addEmp()" action="upAdmn" cssClass="btn btn-primary btn-large"/>
                                </td>  

                            </table>
                        </s:form>
                    </div>
                </div>
            </center>


        </div>
    </body>
</html>

