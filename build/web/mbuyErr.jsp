<%-- 
    Document   : entry
    Created on : Mar 3, 2017, 10:49:16 AM
    Author     : ASUS
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
         <link href='css/button.css' rel='stylesheet' type='text/css'/>
         <script>
            
            window.onload.document.getElementById("msuccess1").setAttribute("style","display: none");
            
        </script>
        
        <title>Product Information</title>
        
        <s:head theme="ajax" debug="true"/>
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
         
          <legend align="center">Product Information</legend>
                  
                  </div>
                  
         <div class="auth-form-body">
             
             
         <div id="msuccess">
                 
                <div class="sweet-alert showSweetAlert visible" data-custom-class="" data-has-cancel-button="false" data-has-confirm-button="true" data-allow-outside-click="false" data-has-done-function="false" data-animation="pop" data-timer="null" style="display: block; margin-top: -179px;"><div class="sa-icon sa-error animateErrorIcon" style="display: block;">
      <span class="sa-x-mark animateXMark">
        <span class="sa-line sa-left"></span>
        <span class="sa-line sa-right"></span>
      </span>
    </div><div class="sa-icon sa-warning pulseWarning" style="display: none;">
      <span class="sa-body pulseWarningIns"></span>
      <span class="sa-dot pulseWarningIns"></span>
    </div><div class="sa-icon sa-info" style="display: none;"></div><div class="sa-icon sa-success" style="display: none;">
      <span class="sa-line sa-tip"></span>
      <span class="sa-line sa-long"></span>

      <div class="sa-placeholder"></div>
      <div class="sa-fix"></div>
    </div><div class="sa-icon sa-custom" style="display: none;"></div><h2>Error!</h2>
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
          <button class="confirm"  onclick="mbuyCloseE()" tabindex="1" style="background-color: #BFB389; box-shadow: 0px 0px 2px rgba(140, 212, 245, 0.8), 0px 0px 0px 1px rgba(0, 0, 0, 0.05) inset;">OK</button><div class="la-ball-fall">
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
             
          
          <s:form action="updateProduct" theme="simple">
              

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
                      
                      <tr>
                          <td><s:label for="id" >Product ID:</s:label></td>
                             <td><s:textfield name="pid" id="pid"  cssClass="userId"/></td>
                             
                             <td >
                             <s:submit value="Search" action="searchProduct" cssClass="btn btn-primary btn-large">
                                <s:param name="pid" value="pid" />
                             </s:submit>
                             </td>
                         
                             
                             
                             
                         
                      </tr>

                      <tr>
                             <td>Memo No:</td>
                             <td><s:textfield name="memo" id="memo" cssClass="userId"/></td>
                            
                            <td>Product Cost:</td>
                             <td><s:textfield name="cost" id="cost" cssClass="userId"/></td>
                             
                             <td>Supplier:</td>
                            <td><s:textfield name="supplier" id="supplier" cssClass="userId"/></td> 
                             
                        
                             
                            
                             
                             
                      </tr>
                      
                      
                      <tr>
                          
                          <td>Product Purchase Date:</td>
                             <td style="min-height: 35px;padding: 7px 3px; background-position: right center;border: 1px solid #cccccc; -webkit-border-radius: 3px;-moz-border-radius: 3px;border-radius: 3px;box-shadow: inset 0 1px 2px inset 0 1px 1px rgba(0, 0, 0, 0.075);-moz-box-sizing: border-box; box-sizing: border-box;transition: all 0.15s ease-in;-webkit-transition: all 0.15s ease-in 0; vertical-align: middle;
                                margin-top: 3px;margin-bottom: 3px; margin-left:  5px; height: 15px;  width: 150px;  display: inline-block;  font-size: 13px;   font-weight: normal;  
                                line-height: 10px ;  ">
                                 
                                 <s:datetimepicker  name="buydate" id="buydate" displayFormat="yyyy-MM-dd"  />
                                 
                             </td>
                             
                          
                            
                          <td>Supplier Warrenty (In Month No):</td>
                             <td><s:textfield name="suplrwrnty" id="suplrwrnty" cssClass="userId"/></td>
                             
                             <td>Product Lifetime (In Month No):</td>
                             <td><s:textfield name="prdtlife" id="prdtlife" cssClass="userId"/></td>
                          
                             
                             
                        </tr>
                        
                             
                             
                      
                      
                       <tr>
                           
                           
                        
                             
                        
                           
                             
                      </tr>


                      <tr>
                             
                      </tr>


                      <tr>
                             
                      </tr>
                      
                      
                     
                      
                      
                      
                      </table>
                      
                      
                      

                     
                      <table>
                      
                          
                          <tr>
                             
                          
                          <td align="center">
                             
                              <s:submit value="Update" onmouseover="mbuy()" cssClass="btn btn-primary btn-large"/>
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

