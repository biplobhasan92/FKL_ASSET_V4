<%-- 
    Document   : ip_list_192
    Created on : 08-Dec-2018, 16:56:08
    Author     : Hasan
--%>

<%@include file="linkingScriptAndCss.jsp" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

    <s:if test="%{#session.master == null && #session.admin == null}">
        <jsp:forward   page="index.jsp" />
    </s:if>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/validation.js"></script>
        <script src="js/sweetalert-master/dist/sweetalert.min.js"></script>
        <link rel="stylesheet" type="text/css" href="js/sweetalert-master/dist/sweetalert.css">
        <link href='style.css' rel='stylesheet' type='text/css'/>
        <link rel="icon" href="images/icon.gif" type="image/gif" sizes="16x16">
        <link href='css/button.css' rel='stylesheet' type='text/css'/>
        <title>FKL ASSET V4 | IP 192 Update</title>

        <s:head theme="ajax" debug="true"/>
        <style>
            label{
                text-align: right;
            }
        </style>
        <script>
            function resetfield(){
                 var getftatus = document.getElementById('ip_use_status').value;
                 if(getftatus === 'Not Used'){
                     document.getElementById('ip_user_name').value = "";
                     document.getElementById('ip_type').value = "";
                     document.getElementById('ip_user_dept').value = "";
                 }
            }
            
            function resetForm(){
                var getftatus = document.getElementById('form_status').value;
                 if(getftatus === 'Clear'){
                     document.getElementById('ip_no').value = "";
                     document.getElementById('ip_user_name').value = "";
                     document.getElementById('ip_type').value = "";
                     document.getElementById('ip_user_dept').value = "";
                     document.getElementById('ip_use_status').value = "";
                 }
            }
            
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
                        <legend align="center">Update 192 I.P Info</legend>
                    </div>
                    <div class="auth-form-body">
                        <s:form action="updateIp192" theme="simple" method="POST">
                            <table>
                                <thead>
                                    <tr>
                                        <th></th>
                                        <th>IP:</th>
                                        <th>Name:</th>
                                        <th>Dept:</th>
                                        <th>Type:</th>
                                        <th>PBX Ext.</th>
                                        <th>Status:</th>
                                        <th></th>
                                        <th>Clear</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><s:hidden name="ip_sl_no" id="ip_sl_no" /></td>
                                        <td><s:label value="">192.168. </s:label><s:textfield name="ip_no" id="ip_no" cssClass="userId" /></td>
                                        <td><s:textfield name="ip_user_name" id="ip_user_name"  cssClass="userId"/></td>
                                        <td><s:select list="%{deptList}" name="ip_user_dept"      id="ip_user_dept" 
                                              headerKey="" headerValue="---Select Dept---" cssClass="userId"></s:select></td>
                                        <td><s:select  name="ip_type"           id="ip_type"       list="%{productList}" headerKey="" headerValue="---Select Type---"  cssClass="select"/></td>
                                        <td><s:textfield name="pbx_extension"   id="pbx_extension"  cssClass="userId"/></td>
                                        <td><s:select  name="ip_use_status" onchange="resetfield()"       id="ip_use_status" list="{'Active', 'Not Used'}" headerKey="" headerValue="---Select Status---"  cssClass="select"/></td>
                                        <td><s:submit  value="Update" id="btn_ip_save_100"   cssClass="btn btn_ip_save_100 btn-primary btn-large btn_fix_size"/></td>
                                        <td><s:select  name="form_status" onchange="resetForm()" id="form_status" list="{'Clear'}" headerKey="" headerValue="---Select---"  cssClass="select"/></td>
                                        <td><s:submit  value="Back"  action="check_ip"      cssClass="btn btn-primary btn_fix_size"/></td>
                                    </tr>
                                </tbody>
                                <br/>
                            </table>
                        </s:form>
                    </div>
                </div>
            </center>
        </div>
    </body>
</html>