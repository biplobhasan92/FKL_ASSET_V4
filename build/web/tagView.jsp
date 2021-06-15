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
        <title>FKL ASSET V4 | View Tag</title>
        
         <s:head theme="ajax" debug="true"/>
         
         <script>
            
            //window.onload.document.getElementById("msuccess1").setAttribute("style","display: none");
            
            var count=0;
            
            function isSave(){
                
            
            var ip=document.getElementById('ip').value;
                if(ip==="" && count==0){
                    
                    
                    //document.getElementById("msuccess9").removeAttribute("style");
                    //return false;
                    
                    var status= confirm("Are You Sure Want To Save Without IP?");
                    
                    if(status==true){
                        
                        count=1;
                        
                    }else{
                        
                        count=0;
                        document.getElementById("ip").focus();
                        
                    }
                        
                        //alert("Yes");
                         //document.myForm.action ="saveM";
                         //document.myForm.submit();
                         
                        
                        
                    //}



                }
            }
            
            
        </script>
         
         <script src="http://code.jquery.com/jquery-latest.js">   
        </script>
        <script>
            
            
            
            
            $(document).ready(function() {
                //$('#load').hide();
                $('#ip').blur(function(event) {
                    //$('#output').hide();
                    //$('#load').fadeIn();
                    var ip=$('#ip').val();
                    var fklid=$('#fklid').val();
                    $.ajax({
                        
                        url:'ajaxIpChck2',
                        method:'POST',
                        data:{ip:ip, fklid:fklid},
                        dataType:'text',
                        success: function(responseText) {
                           
                           $('#output').fadeIn();
                           $('#output').html(responseText);         
                         }
                        
                    });
                    
        
                });
            });
            
            
            
            
            
            
            
        </script>
    </head>
    <body>
        <%@include file="mainMenu.jsp" %>
        <div class='fix main'>         
      <center>                  
          <div class='fix form'>          
          <div class="auth-form-header">          
            <legend align="center"><s:property value="fklid"/></legend>                  
          </div>
                  
         <div class="auth-form-body">
          
          <s:form action="updateEntry" theme="simple">                          
              <s:set name="fklid" value="fklid"/>
              <s:hidden name="fklid" value="%{fklid}"/>              
                  <table>
                   <col width="150">
                    <col width="180">
                    <col width="150">
                    <col width="180">
                    <col width="150">
                    <col width="180">                                                                    
                      <th>Employee Data</th>
                      <tr>
                            <td>Employee I.D.:</td>
                            <td><s:textfield name="id" disabled="true" id="id" cssClass="userId"/></td>                         
                      </tr>

                      <tr>
                            <td>Employee Name:</td>
                            <td><s:textfield name="name" disabled="true" id="name" cssClass="userId"/></td>                             
                            <td>Employee Designation:</td>
                            <td><s:textfield name="designation" disabled="true" id="designation" cssClass="userId"/></td>                             
                            <td>Employee Department:</td>
                            <td><s:textfield name="dept" disabled="true" id="dept" cssClass="userId"/></td>
                      <tr>
                             
                      </tr>


                      <tr>
                             
                      </tr>
                      
                      
                     
                      
                      <tr>
                          
                          <td><h4>Machine Details</h4></td></tr>
                       
                       <tr>
                             <td>Machine ID:</td>
                             <td><s:textfield name="mid" id="mid"  disabled="true"  cssClass="userId"/></td>
                             
                             <td>IP Address:</td>
                             <td>
                                 <s:textfield name="ip" id="ip"  disabled="true"  cssClass="userId"/>
                                 <div id="output" style="color: #9c2400;font-size: 15px; text-shadow: 0 1px 1px rgba(0, 0, 0, 0.75);opacity: 1; height: auto;"></div>
                             
                             </td>
                             
                             <td style="/*color: #9c2400*/">Machine Tag NO:</td>
                             <td><s:textfield name="fklid" id="fklid" disabled="true" cssClass="userId"/></td>
                             
                             
                             
                             
                             
                             
                      </tr>

                      <tr>
                            
                      </tr>
                      
                      
                       <tr>
                             
                      </tr>
                      

                      <tr>
                             <td>Hard Disk(GB:</td>
                             <td><s:textfield name="hdd" id="hdd"  disabled="true"  cssClass="userId"/></td>
                             
                             <td>Mother Board:</td>
                             <td><s:textfield name="mboard" id="mboard"  disabled="true"  cssClass="userId"/></td>
                             
                             <td>RAM(GB):</td>
                             <td><s:textfield name="ram" id="ram"  disabled="true"  cssClass="userId"/></td>
                             
                             
                             
                             
                             
                             
                             
                      </tr>
                      
                      
                      <tr>
                             
                      </tr>
                      
                      
                       <tr>
                             
                      </tr>
                      
                      
                       <tr>
                             <td>Processor:</td>
                             <td><s:textarea name="chip" id="chip"  disabled="true"  cssClass="tarea"/></td>
                             
                             <td>Status:</td>
                             <td><s:select  disabled="true"  name="pcstatus" id="pcstatus" list="{'NEW', 'RE-ASSIGNED', 'UPGRADE', 'REPAIRED', 'DAMAGED'}"
                                     headerKey="" headerValue="---Select Status---"  cssClass="select"/></td>
                             
                             <td>Internet Connection Status:</td>
                             <td><s:select  disabled="true"  name="nstatus" id="nstatus" list="{'Active', 'Inactive'}"
                                     headerKey="" headerValue="---Select Status---" cssClass="select"/></td>
                             
                             
                             
                      </tr>
                      
                      
                      <tr>
                            <td>Product Type:</td>
                             <td>
                                 <s:select disabled="true" list="%{productList}" name="mtype" id="mtype" 
                                       headerKey="" headerValue="---Select Type---" cssClass="select" ></s:select>                                                                                       
                             </td>
                                                                                     
                            <td>Handover Date:</td>
                            <td><s:textfield disabled="true" name="hdate" id="hdate" cssClass="userId"/></td>
                            
                             
                             
                             
                      </tr>
                      
                    
                      <tr>
                          
                          <td>Image(ISO) Entry Date:</td>
                          <td><s:textfield disabled="true" name="imgdate" id="imgdate" cssClass="userId"/></td>
                        
                             <%--<td style="min-height: 35px;padding: 7px 3px; background-position: right center;border: 1px solid #cccccc; -webkit-border-radius: 3px;-moz-border-radius: 3px;border-radius: 3px;box-shadow: inset 0 1px 2px inset 0 1px 1px rgba(0, 0, 0, 0.075);-moz-box-sizing: border-box; box-sizing: border-box;transition: all 0.15s ease-in;-webkit-transition: all 0.15s ease-in 0; vertical-align: middle;
                                margin-top: 3px;margin-bottom: 3px; height: 15px;  width: 150px;  display: inline-block;  font-size: 13px;   font-weight: normal;  
                                line-height: 10px ;  ">
                                 
                                 <s:datetimepicker  name="imgdate" id="imgdate" displayFormat="dd-MM-yyyy"  />
                                 
                             </td>--%>
                        
                             
                            <td>Image(ISO) Location:</td>
                             <td><s:textfield disabled="true" name="imgloc" id="imgloc" cssClass="userId"/></td>
                          
                             
                             <td>Remarks:</td>
                             <td><s:textarea disabled="true" name="remarks" id="remarks" cssClass="tarea"/></td>
                           
                             
                            
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

