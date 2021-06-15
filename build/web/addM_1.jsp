<%-- 
    Document   : addM
    Created on : Mar 27, 2017, 2:45:56 PM
    Author     : Ahsan-IT
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
        
        <title>Entry</title>
        
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
                    $.ajax({
                        
                        url:'ajaxIpChck',
                        method:'POST',
                        data:{ip:ip},
                        dataType:'text',
                        success: function(responseText) {
                           
                           $('#output').fadeIn();
                           $('#output').html(responseText);         
                         }
                        
                    });
                    
        
                });
                
                
                $('.t').hover(function(event){
                    
                    var pos = $(this).position();
                    var newPos=(pos.top+20)+'px';
                    var newPos2=(pos.left)+'px';
                    var newWidth=$(this).width();
                    
                    
                    
                    //$('.test').text(newPos+"-------"+newPos2+"-------"+newWidth);
                    
                    
                    $('.test').css("display","block");
                    
                    
                }
                        
                
                
                        
                
                
                
                );
        
        
                $('.content').hover(function(event){
                    $('.test').css("display","none");
                    
                }
                );
                
                
                
            });
            
            
            
            
            
            
            
        </script>
       
        
    </head>
    <body>
        <%@include file="mainMenu.jsp" %>
        <div class='fix main'> <!--  main DIV is Start  -->   
                
            <div class="border"></div>
            <!--  #######################   mian menu  ##################################################################-->
                    
          <div class="test">
              <ul style="list-style: none">
                  <li class="submenu"><s:a href="%{showPerson}">Total Individual Records</s:a></li>
                <li class="submenu"><s:a href="%{showPerson}">Total Other Records</s:a></li>
              </ul>
                                    
          </div>
        
         
      <div class="content"> 
      <center>
          
          
        
           <div style="color: #9c2400;font-size: 15px; text-shadow: 0 1px 1px rgba(0, 0, 0, 0.75);opacity: 1; height: auto;">
            <s:property value="message"/>
          </div>
            
          
          
          <div class='fix form'>
          
          <div class="auth-form-header"> 
         
          <legend align="center">Add/Assign New Machine</legend>
                  
                  </div>
                  
         <div class="auth-form-body">
          
             <s:form name="myForm" action="saveM" theme="simple">
                 
                 
                 
              

              <s:set name="pid" value="pid"/>
              <s:hidden name="pid" value="%{pid}"/>
              
              <%--<s:set name="id" value="id"/>
                <s:hidden name="id" value="%{id}"/>--%>

              <s:set name="name" value="name"/>
              <s:hidden name="name" value="%{name}"/>
              
               <s:set name="designation" value="designation"/>
              <s:hidden name="designation" value="%{designation}"/>
              
               <s:set name="dept" value="dept"/>
              <s:hidden name="dept" value="%{dept}"/>
              
              
              
              
                  <table border="0">
                      
                   <col width="150">
                   
                    <col width="180">
                    <col width="150">
                    <col width="180">
                    <col width="150">
                    <col width="180">
                      
                    
                              <div id="msuccess1" style="display: none;">
                             <div style="color: #9c2400;font-size: 15px; text-shadow: 0 1px 1px rgba(0, 0, 0, 0.75);opacity: 1; height: auto;">
                             <s:property value="message2"/>
                             </div></div>
                         
                      </tr>

                      
                      
                     
                      
                     
                       
                       <tr>
                             
                             
                           
                             <td>
                                 <div id="idlebel">Employee I.D.:</div>
                                 <div id="deptlebel" style="display: none;">Dept. Name:</div>
                             
                             </td>
                             <td>
                                 <div id="idtype"><s:textfield name="id" id="id"  cssClass="userId"/></div>
                                 <div id="depttype" style="display: none;"><s:select list="%{deptList}" name="dept" id="dept" 
                                       headerKey="" headerValue="---Select Dept---" cssClass="userId"></s:select></div>
                             
                             
                             </td>
                             
                             <td>IP Address:</td>
                             <td>
                                 <s:textfield name="ip" id="ip" cssClass="userId"/>
                                 <div id="output" style="color: #9c2400;font-size: 15px; text-shadow: 0 1px 1px rgba(0, 0, 0, 0.75);opacity: 1; height: auto;"></div>
                             </td>
                             
                             <td>Hard Disk(GB:</td>
                             <td><s:textfield name="hdd" id="hdd" cssClass="userId"/></td>
                             
                             
                             
                             
                             
                             
                             
                             
                      </tr>

                      <tr>
                            
                      </tr>
                      
                      
                       <tr>
                             
                      </tr>
                      

                      <tr>
                             
                             
                             <td>Mother Board:</td>
                             <td><s:textfield name="mboard" id="mboard" cssClass="userId"/></td>
                             
                             <td>RAM(GB):</td>
                             <td><s:textfield name="ram" id="ram" cssClass="userId"/></td>
                             
                             <td>Processor:</td>
                             <td><s:textarea name="chip" id="chip" cssClass="tarea"/></td>
                             
                             
                             
                             
                             
                             
                             
                      </tr>
                      
                      <tr>
                            <td>Machine ID:</td>
                             <td><s:textfield name="mid" id="mid" cssClass="userId"/></td>
                             
                             <td>Status:</td>
                             <td><s:select name="pcstatus" id="pcstatus" list="{'NEW', 'RE-ASSIGNED', 'UPGRADE', 'REPAIRED', 'DAMAGED'}"
                                     headerKey="" headerValue="---Select Status---"  cssClass="select"/></td>
                             
                              <td>Internet Connection Status:</td>
                             <td><s:select name="nstatus" id="nstatus" list="{'Active', 'Inactive'}"
                                     headerKey="" headerValue="---Select Status---" cssClass="select"/></td>
                             
                             
                             
                      </tr>
                      
                      <tr>
                          
                          
                          <td>User Type:</td>
                            <td>
                                
                                <s:select name="utype" id="utype" list="{'Individual','Dept'}"
                                       headerKey="" headerValue="---Select Type---" cssClass="select"  onchange="typeChange()"  /></td>
                          
                          
                          
                          <td>Product Type:</td>
                            <td>
                                
                                <%--<s:select name="mtype" id="mtype" list="{'Desktop', 'Laptop', 'Printer', 'Camera', 'Scanner','Plotter'}"
                                       headerKey="" headerValue="---Select Type---" cssClass="select"  onchange="typeChange()"  />--%>
                                
                                
                                <s:select list="%{productList}" name="mtype" id="mtype" 
                                       headerKey="" headerValue="---Select Type---" cssClass="select"></s:select>
                            
                            
                            
                            
                            
                            </td>
                             
                           
                            
                            <td>Handover Date:</td>
                             <td style="min-height: 35px; margin-left: 5px;  padding: 7px 3px; background-position: right center;border: 1px solid #cccccc; -webkit-border-radius: 3px;-moz-border-radius: 3px;border-radius: 3px;box-shadow: inset 0 1px 2px inset 0 1px 1px rgba(0, 0, 0, 0.075);-moz-box-sizing: border-box; box-sizing: border-box;transition: all 0.15s ease-in;-webkit-transition: all 0.15s ease-in 0; vertical-align: middle;
                                margin-top: 3px;margin-bottom: 3px; height: 15px;  width: 150px;  display: inline-block;  font-size: 13px;   font-weight: normal;  
                                line-height: 10px ;  ">
                                 
                                 <s:datetimepicker  name="hdate" id="hdate" displayFormat="dd-MM-yyyy"  />
                                 
                             </td>
                             
                             
                            
                            
                             
                            
                             
                             
                      </tr>
                      
                      
                      <tr>
                          
                          <td>Memo No:</td>
                             <td><s:textfield name="memo" id="memo" cssClass="userId"/></td>
                             
                          <td>Supplier:</td>
                            <td><s:textfield name="supplier" id="supplier" cssClass="userId"/></td> 
                            
                          <td>Supplier Warrenty (In Month No):</td>
                             <td><s:textfield name="suplrwrnty" id="suplrwrnty" cssClass="userId"/></td>
                             
                             
                          
                             
                             
                        </tr>
                        
                             
                          
                      
                      
                       <tr>
                           
                           
                            <td>Product Lifetime (In Month No):</td>
                             <td><s:textfield name="prdtlife" id="prdtlife" cssClass="userId"/></td>  
                           
                           
                        <td>Product Cost:</td>
                        <td><s:textfield name="cost" id="cost"  cssClass="userId"/></td>
                             
                        <td>Product Purchase Date:</td>
                             <td style="min-height: 35px; margin-left: 5px; padding: 7px 3px; background-position: right center;border: 1px solid #cccccc; -webkit-border-radius: 3px;-moz-border-radius: 3px;border-radius: 3px;box-shadow: inset 0 1px 2px inset 0 1px 1px rgba(0, 0, 0, 0.075);-moz-box-sizing: border-box; box-sizing: border-box;transition: all 0.15s ease-in;-webkit-transition: all 0.15s ease-in 0; vertical-align: middle;
                                margin-top: 3px;margin-bottom: 3px; height: 15px;  width: 150px;  display: inline-block;  font-size: 13px;   font-weight: normal;  
                                line-height: 10px ;  ">
                                 
                                 <s:datetimepicker  name="buydate" id="buydate" displayFormat="yyyy-MM-dd"  />
                                 
                             </td>
                             
                        
                           
                             
                      </tr>
                      <%--<td>Mother Board:</td>
                             <td><s:textfield name="mboard" id="mboard" cssClass="userId"/></td>
                      <td>Mother Board:</td>
                             <td><s:textfield name="mboard" id="mboard" cssClass="userId"/></td>
                        <td>Mother Board:</td>
                             <td><s:textfield name="mboard" id="mboard" cssClass="userId"/></td>
                             
                             
                      
                      
                       <tr>
                             
                             
                             
                             
                             
                             
                    </tr>--%>
                      
                    
                      <tr>
                          
                          <td>Image(ISO) Entry Date:</td>
                        
                             <td style="min-height: 35px; margin-left: 5px;  padding: 7px 3px; background-position: right center;border: 1px solid #cccccc; -webkit-border-radius: 3px;-moz-border-radius: 3px;border-radius: 3px;box-shadow: inset 0 1px 2px inset 0 1px 1px rgba(0, 0, 0, 0.075);-moz-box-sizing: border-box; box-sizing: border-box;transition: all 0.15s ease-in;-webkit-transition: all 0.15s ease-in 0; vertical-align: middle;
                                margin-top: 3px;margin-bottom: 3px; height: 15px;  width: 150px;  display: inline-block;  font-size: 13px;   font-weight: normal;  
                                line-height: 10px ;">
                                 
                                 <s:datetimepicker  name="imgdate" id="imgdate" displayFormat="dd-MM-yyyy"  />
                                 
                             </td>
                        
                             
                        <td>Image(ISO) Location:</td>
                             <td><s:textfield name="imgloc" id="imgloc" cssClass="userId"/></td>
                             
                         <td>Remarks:</td>
                             <td><s:textarea name="remarks" id="remarks" cssClass="tarea"/></td>
                          
                           
                             
                            
                      </tr>
                      
                      <tr>
                          
                            
                            
                            
                      </tr>
                      
                      </table>
                      
                      
                      

                     
                      <table>
                      
                          
                          
                          
                          <tr>
                              
                            <td>
                             
                              <s:submit value="Update Machine" action="upM" cssClass="btn btn-primary btn-large"/>
                            </td>  
                              
                              
                             <td>
                             
                                 <s:submit value="Save"  onmouseover="isSave()" cssClass="btn btn-primary btn-large"/>
                             </td>
                          
                           <td>
                             
                              <s:submit value="Settings" action="settings" cssClass="btn btn-primary btn-large"/>
                          </td>
                          
                      </tr> 
                      </table>
                       <table>
                      <tr>
                      
                      
                             <div align="center"> 
                              <s:submit value="Create User" action="createUser" cssClass="btn btn-primary btn-large"/></div>
                          </tr>
                      
                      
                      
                      
                  </table>

          </s:form>
                  
          </div>
                  
                  
         
             
              
        </div>
      
       </center>
      </div> 
            
            
      </div>
    </body>
    
    <script>
     
    
    /*var enable=document.getElementById("search");
    enable.onmouseover= function (){
            document.getElementById("mlabel").removeAttribute("style")
            document.getElementById("fklid").removeAttribute("disabled");
        
        }*/
   
        
    function enable (){
            document.getElementById("tagLabel").removeAttribute("style");
            //document.getElementById("tagDiv").removeAttribute("style");
            document.getElementById("tagDiv").setAttribute("style","disply : block");
            document.getElementById("search").setAttribute("value","Search");
            //document.getElementById("fklid").removeAttribute("disabled");
            //document.getElementById("fklid").style.disply="none";
            //document.getElementById("tag").setAttribute("style","disply : block");
        
        }   
        
     
    
    var disable=document.getElementById("tagLabel");
    disable.onmouseover= function () {
            document.getElementById("tagLabel").setAttribute("style","color: #9c2400");
            document.getElementById("tagDiv").setAttribute("style","display: none");
            document.getElementById("search").setAttribute("value","Show");
         
        }
     
    </script>
    
    
</html>
