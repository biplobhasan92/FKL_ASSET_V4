<%-- 
    Document   : entry
    Created on : Mar 3, 2017, 10:49:16 AM
    Author     : Hasan Mobarak
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
     
     <s:if test="%{#session.aname == null}">

             <jsp:forward   page="index.jsp" />

	</s:if>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/validation.js"></script>
        <script src="js/sweetalert-master/dist/sweetalert.min.js"></script>
        <link rel="stylesheet" type="text/css" href="js/sweetalert-master/dist/sweetalert.css">
        <link rel="icon" href="images/icon.gif" type="image/gif" sizes="16x16">
        <link href='style.css' rel='stylesheet' type='text/css'/>
        <link href='css/button.css' rel='stylesheet' type='text/css'/>
        <title>FKL ASSET V4 | Search & Update</title>
        <s:head theme="ajax" debug="true"/>
        <script>
      
        
         var count=0;
            
            
             function isDelete(){
                
                 var error='Yes';
                 var error2='';
                 var message='';
                 var ipCheck=0;
                
                var pcstatus = document.getElementById('pcstatus').value;
                var remarks = document.getElementById('remarks').value;

                if (pcstatus === "") {

                    error2 = 'Yes';
                    message = 'Select Status \n';
                    document.getElementById("pcstatus").focus();

                } else if (remarks === "") {

                    error2 = 'Yes';
                    message = 'Enter Remarks \n';
                    document.getElementById("remarks").focus();

                }


                if (error2 === 'Yes') {

                    sweetAlert(message);

                }

                document.MM_returnValue = (error2 == '');



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
                        <legend align="center">Delete Information</legend>
                    </div>
                    <div class="auth-form-body">
                        <s:form action="deletePdata" theme="simple">
                            <s:set name="fklid" value="fklid"/>
                            <s:hidden name="fklid" value="%{fklid}"/>
                            <s:hidden id="name" name="name" value="%{#session.aname}" />
                            <s:set name="id" value="id"/>
                            <s:hidden name="id" value="%{id}"/>

                            <table>
                                <col width="150">
                                <col width="180">
                                <col width="150">
                                <col width="180">
                                <col width="150">
                                <col width="180">

                                <h4>Are you sure want to delete this record? if so, please change Machine Status and add a remarks</h4>

                                <th></th>
                                <tr>
                                    <td>Dept. Name:</td>
                                    <td><s:select list="%{deptList}" name="dept" id="dept" 
                                              headerKey="" headerValue="---Select Dept---" disabled="true"  cssClass="userId"></s:select></td>



                                    <div style="color: #9c2400;font-size: 15px; text-shadow: 0 1px 1px rgba(0, 0, 0, 0.75);opacity: 1; height: auto;">
                                    <s:property value="message"/>
                                </div>

                                <div style="color: #9c2400;font-size: 15px; text-shadow: 0 1px 1px rgba(0, 0, 0, 0.75);opacity: 1; height: auto;">
                                    <s:property value="message2"/>
                                </div>

                                </tr>

                                <tr>

                                </tr>


                                <tr>

                                </tr>

                                <tr>

                                    <td><h4>Machine Details</h4></td></tr>

                                <tr>
                                    <td>Machine ID:</td>
                                    <td><s:textfield name="mid" id="mid" disabled="true"  cssClass="userId"/></td>

                                    <td>IP Address:</td>
                                    <td><s:textfield name="ip" id="ip" disabled="true"  cssClass="userId"/></td>

                                    <td style="/*color: #9c2400*/">Machine Tag NO:</td>
                                    <td><s:textfield name="fklid" id="fklid" disabled="true" cssClass="userId"/></td>
                                </tr>

                                <tr>

                                </tr>


                                <tr>

                                </tr>





                                <tr>

                                </tr>


                                <tr>

                                </tr>
                                <tr>
                                    <td>Status:</td>
                                    <td><s:select name="pcstatus" id="pcstatus" list="{'NEW', 'RE-ASSIGNED', 'UPGRADE', 'REPAIRED', 'DAMAGED'}"
                                              headerKey="" headerValue="---Select Status---"    cssClass="select"/></td>

                                    <td>Internet Connection Status:</td>
                                    <td><s:select name="nstatus" id="nstatus" list="{'Active', 'Inactive'}"
                                              headerKey="" headerValue="---Select Status---" disabled="true"  cssClass="select"/></td>
                                </tr>
                                <tr>
                                    <td>Product Type:</td>
                                    <td><s:select name="mtype" id="mtype" list="{'Desktop', 'Laptop', 'Printer', 'Camera', 'Scanner','Plotter'}"
                                              headerKey="" headerValue="---Select Type---"  disabled="true"  cssClass="select"/></td>



                                    <td>Handover Date:</td>
                                    <td><s:textfield name="hdate" id="hdate"  disabled="true"  cssClass="userId"/></td>

                                </tr>


                                <tr>
                                    <td>Image(ISO) Entry Date:</td>
                                    <td><s:textfield name="imgdate" id="imgdate"  disabled="true"  cssClass="userId"/></td>

                                    <td>Image(ISO) Location:</td>
                                    <td><s:textfield name="imgloc" id="imgloc"  disabled="true"  cssClass="userId"/></td>


                                    <td>Remarks:</td>
                                    <td><s:textarea name="remarks" id="remarks" cssClass="tarea"/></td>
                                </tr>
                                <tr>

                                </tr>
                            </table>
                            <table>
                                <tr>
                                    <td align="center">
                                        <s:submit value="Delete" onclick="isDelete();return document.MM_returnValue" cssClass="btn btn-primary btn-large"/>
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

