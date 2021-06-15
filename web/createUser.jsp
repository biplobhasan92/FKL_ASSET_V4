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
        <link rel="icon" href="images/icon.gif" type="image/gif" sizes="16x16">
         <link href='css/button.css' rel='stylesheet' type='text/css'/>
        <title>FKL ASSET V4 | Entry Information</title>
        <script>
            function cnfrmPass(cnfrmVal){
                var newPass = document.getElementById('newPass').value;
                var lbl_msg = document.getElementById('lbl_msg');
                var isTrue = false;
                if(cnfrmVal===newPass){
                    lbl_msg.style.color = 'green';
                    lbl_msg.innerHTML = 'ok';
                    isTrue = true;
                }else{                    
                    lbl_msg.style.color = 'red';
                    lbl_msg.innerHTML = 'not matched';
                    isTrue = false;
                }
                return isTrue;
            }
            
            
            function isConfirm(){
                var lbl_msg = document.getElementById('lbl_msg');
                if(lbl_msg.innerHTML != 'ok'){
                    alert('password not Confirmed !');
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
                <div style="color:#9c2400;font-size: 15px; text-shadow: 0 1px 1px rgba(0, 0, 0, 0.75);opacity: 1; height: auto;">
                    <s:property value="message"/>
                </div>

                <div class='fix form'>          
                    <div class="auth-form-header">
                        <legend align="center">User Management (Test)</legend>                  
                    </div>                  

                    <div class="auth-form-body">
                        <div id="msuccess1" style="display: none;"> 
                            <div style="color: #9c2400;font-size: 15px; text-shadow: 0 1px 1px rgba(0, 0, 0, 0.75);opacity: 1; height: auto;">
                                <s:property value="message2"/>
                            </div>
                        </div>

                        <s:form  theme="simple">
                            <div style="height: 20px" >
                                    <label id="lbl_msg" ></label>
                                </div>
                            <table>  
                                <%--<input type="hidden"  value="${sessionScope.emp_id}" id="emp_id" name="emp_id"/> --%>
                                <td><s:hidden id="emp_id" name="emp_id" value="%{#session.emp_id}" /></td>
                                <%--<td><s:hidden name="aname" id="aname" value="%{#session.aname}" /></td>--%>

                                <tr>
                                    <td>User Name:</td>
                                    <td><s:textfield name="aname" id="aname" cssClass="userId" value="%{#session.aname}" /></td>                 
                                </tr>  
                     
                                <tr>
                                    <td>User Password   :</td>
                                    <td><s:password  name="password" id="password" cssClass="userId"/></td>                             
                                </tr>
                                
                                <tr>
                                    <td>New Password  :</td>
                                    <td><s:password name="newPass"  id="newPass" cssClass="userId"/></td>                             
                                </tr>
                                
                                <tr>
                                    <td>Confirm Password   :</td>
                                    <td><s:password name="confrmPass" onkeyup="cnfrmPass(this.value)" id="confrmPass" cssClass="userId"/></td>                                   
                                </tr>
                            </table>

                            <table>                    
                                <td align="center">                             
                                    <s:submit value="save" onmouseover="/addEmp()" action="cgPass" cssClass="btn btn-primary btn-large"/>                                  
                                </td>                                
                                <td align="center">                             
                                    <%--<s:submit value="save" onmouseover="/addEmp()" action="upAdmn" cssClass="btn btn-primary btn-large"/> --%>
                                </td>                                
                            </table>
                        </s:form>                  
                    </div>                                                                        
                </div>      
            </center>                        
        </div>
    </body>
</html>

