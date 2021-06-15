<%-- 
    Document   : entry
    Created on : Mar 3, 2017, 10:49:16 AM
    Author     : ASUS
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="linkingScriptAndCss.jsp" %>
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
        <link href='css/button.css' rel='stylesheet' type='text/css'/>
        <title>FKL ASSET V4 | Search & Update</title>
        
         <s:head theme="ajax" debug="true"/>
         
         
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
         
         
        <script>
            
            //window.onload.document.getElementById("msuccess1").setAttribute("style","display: none");
            
            var count=0;
            
            
            
             function isSave2(){
                
                var error='Yes';
                var error2='';
                var message='';
                var ipCheck=0;
                var pcstatusCheck=0;
                var nstatusCheck=0;
                var ipCheckNeeded=1;
                var pcstatusCheckNeeded=1;
                var nstatusCheckNeeded=1;
                
                var ip=document.getElementById('ip').value;
                
                
                var mtype = document.getElementById('mtype').value;
                
                var pcstatus = document.getElementById('pcstatus').value;
                
                var nstatus = document.getElementById('nstatus').value;
                
                
               //alert(buydate);
               
                if(mtype===""){
                    
                   error2='Yes';
                   message ='Select Product Type \n';
                   document.getElementById("mtype").focus();
                
                }else if(pcstatus==="" || ip==="" || nstatus===""){
                    
                    
                    //document.getElementById("msuccess9").removeAttribute("style");
                    //return false;
                    if(pcstatus==="" && pcstatusCheckNeeded==1){
                        
                        
                        var status1= confirm("Are You Sure Want To Update Without Status?");
                       
                        
                    
                        if(status1==true){

                            error2='';
                            
                        }else{

                            error2='Yes';
                            pcstatusCheck=1;
                            ipCheckNeeded=0;
                            nstatusCheckNeeded=0;

                        }
                        
                        
                    }
                    
                    
                    
                    if(nstatus==="" && nstatusCheckNeeded==1){
                    
                    
                        //document.getElementById("msuccess9").removeAttribute("style");
                        //return false;
                        //alert("yuu");
                        var status2= confirm("Are You Sure Want To Update Without Internet Status?");

                        if(status2==true){

                            error2='';

                        }else{

                            error2='Yes';
                            nstatusCheck=1;
                            ipCheckNeeded=0;
                            pcstatusCheckNeeded=0;

                        }
                                
                    }
                    
                    
                    if(ip==="" && ipCheckNeeded==1){
                    
                    
                        //document.getElementById("msuccess9").removeAttribute("style");
                        //return false;

                        var status= confirm("Are You Sure Want To Update Without IP?");

                        if(status==true){

                            error2='';

                        }else{

                            error2='Yes';
                            ipCheck=1;
                            pcstatusCheckNeeded=0;
                            nstatusCheckNeeded=0;
                            
                        }

                    }   
                    
                
                }
               
               
                if(error2==='Yes'){
                    
                    if(ipCheck==0 && pcstatusCheck==0 && nstatusCheck==0){
                    
                        sweetAlert(message);
                    
                    }else{
                        
                        if(ipCheck==1){
                            
                            document.getElementById("ip").focus();
                            
                        }else if(pcstatusCheck==1){
                            
                            document.getElementById("pcstatus").focus();
                            
                        }else if(nstatusCheck==1){
                            
                            document.getElementById("nstatus").focus();
                            
                        }
                        
                    }
                    
                    
                }
                
                document.MM_returnValue = (error2 == '');
                
                /*  
        
                if(ip===""){
                    
                    
                    //document.getElementById("msuccess9").removeAttribute("style");
                    //return false;
                    
                    var status= confirm("Are You Sure Want To Save Without IP?");
                    
                    if(status==true){
                        
                        error='';
                        
                    }
                    
                    if (error) {
                        document.getElementById("ip").focus();
                    }
                    document.MM_returnValue = (error == '');
                
                }
                    
        
              */  
               
                
                
        
            }
            
            
            
            function isSave3(){
                
                var error='Yes';
                var ip=document.getElementById('ip').value;
                if(ip===""){
                    
                    
                    //document.getElementById("msuccess9").removeAttribute("style");
                    //return false;
                    
                    var status= confirm("Are You Sure Want To Save Without IP?");
                    
                    if(status==true){
                        
                        error='';
                        
                    }
                    
                    if (error) {
                        document.getElementById("ip").focus();
                    }
                    document.MM_returnValue = (error == '');
                
                }
        
            }   
             
            
            
            
            
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
         
         
        
    </head>
    <body>
           <%@include file="mainMenu.jsp" %>
        <div class='fix main'> <!--  main DIV is Start  -->   
                
            <div class="border"></div>
            <!--  #######################   mian menu  ##################################################################-->
        
        
            <center>
                <div class='fix form'>
                    <div class="auth-form-header"> 
                        <legend align="center">Search/Update Information(Dept)</legend>
                    </div>
                    <div class="auth-form-body">
                        <div class="container-fluid">
                        <div class="row">
                            <div class="col-lg-9">
                                <s:form action="updateEntryP" theme="simple">
                                    <s:set name="fklid" value="fklid"/>
                                    <s:hidden name="fklid" value="%{fklid}"/>
                                    <s:hidden id="name" name="name" value="%{#session.aname}" />
                                    <table>
                                        <col width="150">
                                        <col width="180">
                                        <col width="150">
                                        <col width="180">
                                        <col width="150">
                                        <col width="180">

                                        <th></th>
                                        <tr>
                                            <td>Dept. Name:</td>
                                            <td><s:select list="%{deptList}" name="dept" id="dept" 
                                                      headerKey="" headerValue="---Select Dept---" cssClass="userId"></s:select>
                                            </td>
                                            <div style="color: #9c2400;font-size: 15px; text-shadow: 0 1px 1px rgba(0, 0, 0, 0.75);opacity: 1; height: auto;">
                                                <s:property value="message"/>
                                            </div>

                                            <div style="color: #9c2400;font-size: 15px; text-shadow: 0 1px 1px rgba(0, 0, 0, 0.75);opacity: 1; height: auto;">
                                                <s:property value="message2"/>
                                            </div>



                                        <tr>
                                            <td><h4>Machine Details</h4></td>
                                        </tr>

                                        <tr>
                                            <td>Machine ID:</td>
                                            <td><s:textfield name="mid" id="mid" cssClass="userId"/></td>

                                            <td>IP Address:</td>
                                            <td>
                                                <s:textfield name="ip" id="ip" cssClass="userId"/>
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

                                        </tr>


                                        <tr>

                                        </tr>


                                        <tr>
                                            <td>Status:</td>
                                            <td><s:select name="pcstatus" id="pcstatus" list="{'NEW', 'ASSIGNED', 'RE-ASSIGNED', 'UPGRADE', 'REPAIRED', 'DAMAGED'}"
                                                      headerKey="" headerValue="---Select Status---"  cssClass="select"/></td>

                                            <td>Internet Connection Status:</td>
                                            <td><s:select name="nstatus" id="nstatus" list="{'Active', 'Inactive'}"
                                                      headerKey="" headerValue="---Select Status---" cssClass="select"/></td>
                                        </tr>

                                        <tr>
                                            <td>Product Type:</td>
                                            <td>
                                                <s:select list="%{productList}" name="mtype" id="mtype" 
                                                          headerKey="" headerValue="---Select Type---"  cssClass="select" ></s:select>
                                                </td>
                                                <td>Handover Date:</td>
                                                <td><s:textfield name="hdate" id="hdate" cssClass="userId"/></td>
                                            </td>
                                        </tr>


                                        <tr>
                                            <td>Image(ISO) Entry Date:</td>
                                            <td><s:textfield name="imgdate" id="imgdate" cssClass="userId"/></td>
                                            <td>DDN /REQ No:*</td>
                                            <td><s:textfield name="imgloc" id="imgloc" cssClass="userId"/></td>
                                            <td>Remarks:</td>
                                            <td><s:textarea name="remarks" id="remarks" cssClass="tarea"/></td>
                                        </tr>

                                        <tr>

                                        </tr>

                                    </table>

                                    <table>
                                        <tr>
                                            <td align="center">
                                                <s:submit value="Update"  onclick="isSave2();return document.MM_returnValue"  cssClass="btn btn-primary btn-large"/>
                                            </td>
                                            <td align="center">
                                                <%--<s:submit value="Machine Update" action="upM" cssClass="btn btn-primary btn-large"/>--%>
                                            </td>
                                        </tr>
                                    </table>
                                </s:form>
                            </div>
                            
                            <div class="col-lg-3">
                                <img width="200" height="200" id="images" name="images" alt="N/A" src="<s:property value="images" />" />
                            </div>
                        </div>
                    </div>
                    </div>
                </div>
            </center>
      </div>
    </body>
</html>

