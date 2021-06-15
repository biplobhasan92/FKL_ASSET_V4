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
        if (session.getAttribute("aname") == null) {
            response.sendRedirect("index.jsp");
        }
%>
<!DOCTYPE html>
<html>
    <s:if test="%{#session.aname == null }">
        <jsp:forward   page="index.jsp" />
    </s:if>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <script src="js/validation.js"></script>
         <script src="js/sweetalert-master/dist/sweetalert.min.js"></script>
        <link rel="stylesheet" type="text/css" href="js/sweetalert-master/dist/sweetalert.css">
        <link href='style.css' rel='stylesheet' type='text/css'/>
         <link href='css/button.css' rel='stylesheet' type='text/css'/>
        <title>Entry Information</title>
        <script>
            
            window.onload.document.getElementById("msuccess1").setAttribute("style","display: none");
            
        </script>
        
        
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
          
          <s:url id="newEmp" action="newEmp" ></s:url>
                <s:a href="%{newEmp}"  ><h4 style="font-size: 20px; color: #BFB389;">Back To Home</h4></s:a>
          <div class="la-ball-fall">
          <div></div>
          <div></div>
          <div></div>
        </div>
      </div>
    </div>
  </div>
                 
             </div>
    
    <div id="msuccess1" style="display: none;"> 
                             <div style="color: #9c2400;font-size: 15px; text-shadow: 0 1px 1px rgba(0, 0, 0, 0.75);opacity: 1; height: auto;">
                             <s:property value="message2"/>
                             </div></div>
             
          
          <s:form action="saveEmp" theme="simple">
              

              <%--<s:set name="id" value="id"/>
              <s:hidden name="id" value="%{id}"/>--%>
              
              <table>
                  
                <col width="150">
                <col width="180">
                <col width="150">
                <col width="180">
                <col width="150">
                <col width="180">
                      
                    
                  <tr>   
                      <th>Employee Data</th>
                      <tr>
                          <td><s:label for="id" >Employee I.D.:</s:label></td>
                             <td><s:textfield name="id" id="id"  cssClass="userId"/></td>
                             
                             <td >
                                 <s:submit value="Search" action="searchEmp" onmouseover="/addEmp()" cssClass="btn btn-primary btn-large">
                                <s:param name="id" value="id" />
                             </s:submit>
                             </td>
                         
                             
                      
                         
                      </tr>

                      <tr>
                             <td>Employee Name:</td>
                             <td><s:textfield name="name" id="name" cssClass="userId"/></td>
                             
                             <td>Employee Designation:</td>
                             <td><s:textfield name="designation" id="designation" cssClass="userId"/></td>
                             
                             
                             
                             
                             
                             
                             
                             <td>Employee Department:</td>
                             <%--<td><s:textfield name="dept" id="dept" cssClass="userId"/></td>--%>
                             <td><s:select list="%{deptList}" name="dept" id="dept" 
                                       headerKey="" headerValue="---Select Dept---" cssClass="userId"></s:select></td>
                             
                             <%-- <td><s:select name="dept" id="dept" list="%{eDeptList}" 
                                    cssClass="select"/></td>--%>
                             
                             
                             
                      </tr>


                      <tr>
                             
                      </tr>


                      <tr>
                             
                      </tr>
                      
                      
                     
                      
                      
                      
                      </table>
                      
                      
                      

                     
                      <table>
                      
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

