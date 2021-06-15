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
        
        <script>
            
            window.onload.document.getElementById("msuccess1").setAttribute("style","display: none");
            
        </script>
        
        
        <title>Search/Update</title>
        
         <s:head theme="ajax" debug="true"/>
        
    </head>
    <body>
        <%@include file="mainMenu.jsp" %>
        <div class='fix main'> <!--  main DIV is Start  -->   
                
            <div class="border"></div>
            <!--  #######################   mian menu  ##################################################################-->
        
        
      <center>
          
          
        
           
            
          
          
          <div class='fix form'>
          
          <div class="auth-form-header"> 
         
          <legend align="center">Search/Update Information</legend>
                  
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
                                      <p style="display: block;"><s:property value="message2"/></p>
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
          
          <s:url id="showPerson" action="showPerson" ></s:url>
                <s:a href="%{showPerson}"  ><h4 style="font-size: 20px; color: #BFB389;">Back To Home</h4></s:a>
          <div class="la-ball-fall">
          <div></div>
          <div></div>
          <div></div>
        </div>
      </div>
    </div>
  </div>
                                      
    </div>
          
          <s:form action="updateEntry" theme="simple">
              

              <%--<s:set name="pid" value="pid"/>
              <s:hidden name="pid" value="%{pid}"/>
              
              <s:set name="ip" value="ip"/>
              <s:hidden name="ip" value="%{ip}"/>--%>
              
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
                             <td><s:textfield name="id" id="id" cssClass="userId"/></td>
                         
                             <td >
                                 <s:submit value="Search" onmouseover="/searchEntryS()" action="searchData" cssClass="btn btn-primary btn-large">
                                <s:param name="id" value="id" />
                             </s:submit>
                             </td>
                             
                             <div style="color: #9c2400;font-size: 15px; text-shadow: 0 1px 1px rgba(0, 0, 0, 0.75);opacity: 1; height: auto;">
                            <s:property value="message"/>
                            </div>
                            
                            <div id="msuccess1"> 
                              
                              <div style="color: #9c2400;font-size: 15px; text-shadow: 0 1px 1px rgba(0, 0, 0, 0.75);opacity: 1; height: auto;">
                             
                                 
                                 
                                 
                                 <s:property value="message2"/></div>
                                 
                               
                             </div>
                         
                      </tr>

                      <%--<tr>
                             <td>Employee Name:</td>
                             <td><s:textfield name="name" id="name" cssClass="userId"/></td>
                             
                             <td>Employee Designation:</td>
                             <td><s:textfield name="designation" id="designation" cssClass="userId"/></td>
                             
                             <td>Employee Department:</td>
                             <%--<td><s:textfield name="dept" id="dept" cssClass="userId"/></td>--%>
                             <%--<td><s:select list="%{deptList}" name="dept" id="dept" 
                                       headerKey="" headerValue="---Select Dept---" cssClass="userId"></s:select></td>
                             
                             
                  </tr>--%>


                      <tr>
                             
                      </tr>


                      <tr>
                             
                      </tr>
                      
                      
                     
                      
                      <tr>
                          
                          <td><h4>Machine Details</h4></td></tr>
                       
                       <tr>
                             <td>Machine ID:</td>
                             <td><s:textfield name="mid" id="mid" cssClass="userId"/></td>
                             
                             <td>IP Address:</td>
                             <td><s:textfield name="ip" id="ip" cssClass="userId"/></td>
                             
                             <td style="/*color: #9c2400*/">Machine Tag NO:</td>
                             <td><s:textfield name="fklid" id="fklid" disabled="true" cssClass="userId"/></td>
                             
                             
                             
                             
                             
                             
                      </tr>

                      <tr>
                            
                      </tr>
                      
                      
                       <tr>
                             
                      </tr>
                      

                      <tr>
                             <td>Hard Disk(GB:</td>
                             <td><s:textfield name="hdd" id="hdd" cssClass="userId"/></td>
                             
                             <td>Mother Board:</td>
                             <td><s:textfield name="mboard" id="mboard" cssClass="userId"/></td>
                             
                             <td>RAM(GB):</td>
                             <td><s:textfield name="ram" id="ram" cssClass="userId"/></td>
                             
                             
                             
                             
                             
                             
                             
                      </tr>
                      
                      
                      <tr>
                             
                      </tr>
                      
                      
                       <tr>
                             
                      </tr>
                      
                      
                       <tr>
                             <td>Processor:</td>
                             <td><s:textarea name="chip" id="chip" cssClass="tarea"/></td>
                             
                             <td>Status:</td>
                             <td><s:select name="pcstatus" id="pcstatus" list="{'NEW', 'RE-ASSIGNED', 'UPGRADE', 'REPAIRED', 'DAMAGED'}"
                                     headerKey="" headerValue="---Select Status---"  cssClass="select"/></td>
                             
                             <td>Internet Connection Status:</td>
                             <td><s:select name="nstatus" id="nstatus" list="{'Active', 'Inactive'}"
                                     headerKey="" headerValue="---Select Status---" cssClass="select"/></td>
                             
                             
                             
                      </tr>
                      
                      
                      <tr>
                            <td>Product Type:</td>
                             <td>
                                 <%--<s:select name="mtype" id="mtype" list="{'Desktop', 'Laptop', 'Printer', 'Camera', 'Scanner'}"
                                     headerKey="" headerValue="---Select Type---" cssClass="select"/>--%>
                                 
                                 <s:select list="%{productList}" name="mtype" id="mtype" 
                                       headerKey="" headerValue="---Select Type---" disabled="true" cssClass="select" ></s:select>
                             
                             
                             
                             </td>
                             
                            
                            
                            <td>Handover Date:</td>
                            <td><s:textfield name="hdate" id="hdate" cssClass="userId"/></td>
                            <%--<td style="min-height: 35px;padding: 7px 3px; background-position: right center;border: 1px solid #cccccc; -webkit-border-radius: 3px;-moz-border-radius: 3px;border-radius: 3px;box-shadow: inset 0 1px 2px inset 0 1px 1px rgba(0, 0, 0, 0.075);-moz-box-sizing: border-box; box-sizing: border-box;transition: all 0.15s ease-in;-webkit-transition: all 0.15s ease-in 0; vertical-align: middle;
                                margin-top: 3px;margin-bottom: 3px; height: 15px;  width: 150px;  display: inline-block;  font-size: 13px;   font-weight: normal;  
                                line-height: 10px ;  ">
                                 
                            <s:datetimepicker  name="hdate" id="hdate" displayFormat="dd-MM-yyyy"  />--%>
                                 
                             </td>
                             
                             
                             
                      </tr>
                      
                    
                      <tr>
                          
                          <td>Image(ISO) Entry Date:</td>
                          <td><s:textfield name="imgdate" id="imgdate" cssClass="userId"/></td>
                        
                             <%--<td style="min-height: 35px;padding: 7px 3px; background-position: right center;border: 1px solid #cccccc; -webkit-border-radius: 3px;-moz-border-radius: 3px;border-radius: 3px;box-shadow: inset 0 1px 2px inset 0 1px 1px rgba(0, 0, 0, 0.075);-moz-box-sizing: border-box; box-sizing: border-box;transition: all 0.15s ease-in;-webkit-transition: all 0.15s ease-in 0; vertical-align: middle;
                                margin-top: 3px;margin-bottom: 3px; height: 15px;  width: 150px;  display: inline-block;  font-size: 13px;   font-weight: normal;  
                                line-height: 10px ;  ">
                                 
                                 <s:datetimepicker  name="imgdate" id="imgdate" displayFormat="dd-MM-yyyy"  />
                                 
                             </td>--%>
                        
                             
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
                             <td align="center">
                             
                                 <s:submit value="Update" onmouseover="/searchEntryU()" cssClass="btn btn-primary btn-large"/>
                          </td>
                          
                          <td align="center">
                             
                             
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

