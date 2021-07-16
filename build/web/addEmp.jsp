<%-- 
    Document   : addEmp.jsp (Add Employee Page)
    Created on : Mar 3, 2017, 10:49:16 AM
    Author     : Hasan Mobarak
    Version    : 4.0

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
        <link rel="icon" href="images/icon.gif" type="image/gif" sizes="16x16">
        <link href='style.css' rel='stylesheet' type='text/css'/>
         <link href='css/button.css' rel='stylesheet' type='text/css'/>
        <title>FKL ASSET V4 | Add Employee</title>
        <script></script>
    </head>
    
    <body>
        <%@include file="mainMenu.jsp" %>
        <div class='fix main'>
            <div class="border"></div>
            <!--  #######################   mian menu  ##################################################################-->
            <center>
                <div style="color:#9c2400;font-size: 15px; text-shadow: 0 1px 1px rgba(0, 0, 0, 0.75);opacity: 1; height: auto;">
                    <s:property value="message"/>
                </div>
                <div class='fix form'>
                    <div class="auth-form-header"> 
                        <legend align="center">Add New Employee</legend>
                    </div>
                    <div class="auth-form-body">
                        <div id="msuccess1" style="display: none;"> 
                            <div style="color: #9c2400;font-size: 15px; text-shadow: 0 1px 1px rgba(0, 0, 0, 0.75);opacity: 1; height: auto;">
                                <s:property value="message2"/>
                            </div>
                        </div>

                        <s:form action="saveEmp" theme="simple">
                            <table>
                                <col width="150">
                                <col width="180">
                                <col width="150">
                                <col width="180">
                                <col width="150">
                                <col width="180">
                                <s:set name="oldId" value="oldId"/>
                                <s:hidden name="oldId" value="%{oldId}"/>
                                <s:set name="oldDept" value="oldDept"/>
                                <s:hidden name="oldDept" value="%{oldDept}"/>
                                <tr>
                                    <th>Employee Data</th>
                                </tr>
                                <tr>
                                    <td><s:label for="id" >Employee I.D.:</s:label></td>
                                    <td><s:textfield name="id" id="id"  cssClass="userId"/></td>
                                    <td>
                                        <s:submit value="Search" action="searchEmp" onmouseover="/addEmp()" cssClass="btn btn-primary btn-large">
                                            <s:param name="id" value="id" />
                                        </s:submit>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Employee Name:</td>
                                    <td><s:textfield name="name" id="name" cssClass="userId" /></td>
                                    <td>Employee Designation:</td>
                                    <td><s:textfield name="designation" id="designation" cssClass="userId"/></td>
                                    <td>Employee Department:</td>
                                    <td>
                                        <s:select list="%{deptList}" name="dept" id="dept" 
                                              headerKey="" headerValue="---Select Dept---" cssClass="userId"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>PBX Ext:</td>
                                    <td><s:textfield name="pvs_extension" id="pvs_extension" cssClass="userId"/></td>
                                </tr>
                                <tr></tr>
                            </table>
                                
                            <table>
                                <tr>
                                    <td align="center">
                                        <s:submit value="Delete" onmouseover="/addEmp()" action="deleteEmp" cssClass="btn btn-primary btn-large"/>
                                    </td> 
                                    <td align="center">
                                        <s:submit value="Save" onmouseover="/addEmp()" action="saveEmp" cssClass="btn btn-primary btn-large"/>
                                    </td>
                                    <td align="center">
                                        <s:submit value="Update" onmouseover="/addEmp()" action="upEmp" cssClass="btn btn-primary btn-large"/>
                                    </td>
                                </tr>
                            </table>
                        </s:form>
                    </div>
                </div>
            </center>
        </div>
    </body>
</html>

