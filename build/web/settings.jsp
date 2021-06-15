<%-- 
    Document   : entry
    Created on : Mar 3, 2017, 10:49:16 AM
    Author     : ASUS
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="linkingScriptAndCss.jsp" %>
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
        <link rel="icon" href="images/icon.gif" type="image/gif" sizes="16x16">
        <title>FKL ASSET V4 | Settings</title>
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
                    <div style="color:#9c2400;font-size: 15px; text-shadow: 0 1px 1px rgba(0, 0, 0, 0.75);opacity: 1; height: auto;">
                        <s:property value="message"/>
                    </div>


                <div class='fix form'>
                    <div class="auth-form-header"> 
                        <legend align="center">Settings</legend>
                    </div>

                    <div class="auth-form-body">
                        <div id="msuccess1" style="//display: none;"> 
                            <div style="color: #9c2400;font-size: 15px; text-shadow: 0 1px 1px rgba(0, 0, 0, 0.75);opacity: 1; height: auto;">
                                <s:property value="message2"/>
                            </div>
                        </div>
                        <s:form  theme="simple">
                            <table>
                                <th>ADD New Department</th>      
                                <tr>
                                    <td>Enter Dept Name:</td>
                                    <td><s:textfield name="nDept" id="nDept" cssClass="userId"/></td>
                                    <td>

                                    </td>
                                </tr>
                                <tr>
                                    <td>Enter Dept Code:</td>
                                    <td><s:textfield name="nDeptCode" id="nDeptCode" cssClass="userId"/></td>
                                    <td>
                                        <s:submit value="Add New Department" onmouseover="/addEmp()" action="saveNewDept" cssClass="btn btn-primary btn-large"/>
                                    </td>
                                </tr>  

                                <tr>

                                </tr>

                                <th>ADD New Product Item</th>

                                <tr>        
                                    <td>Enter Machine Type:</td>
                                    <td><s:textfield name="mtype" id="mtype" cssClass="userId"/></td>
                                    <td>
                                        <s:submit value="Add New Item" onmouseover="/addEmp()" action="saveNewItem" cssClass="btn btn-primary btn-large"/>
                                    </td>
                                </tr>
                                <tr>

                                </tr>
                            </table>
                        </s:form>
                    </div>
                </div>
            </center>
        </div>                
    </body>
</html>

