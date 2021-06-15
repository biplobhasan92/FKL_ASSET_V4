<%-- 
    Document   : entry
    Created on : Mar 3, 2017, 10:49:16 AM
    Author     : Hasan Mobarak
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
        <title>FKL ASSET V4 | Report History</title>
        <script src="js/sweetalert-master/dist/sweetalert.min.js"></script>
        <link rel="stylesheet" type="text/css" href="js/sweetalert-master/dist/sweetalert.css">
        <link href='style.css' rel='stylesheet' type='text/css'/>
        <link rel="icon" href="images/icon.gif" type="image/gif" sizes="16x16">
        <link href='css/button.css' rel='stylesheet' type='text/css'/>
        <style>
            .btn_fix_size {
                width: 130px;
                height: 30px;
                font-family: arial;
            }
        </style>
        <title>View Report</title>
        
          <s:head theme="ajax" debug="true"/>
        
    </head>
    <body onLoad="searchItem2()">
      <%@include file="mainMenu.jsp" %>
        <div class='fix main'> <!--  main DIV is Start  -->   
                
            <div class="border"></div>
            <!--  #######################   mian menu  ##################################################################-->
        
        
      <center>
          
          
          <div class='fix form'>
          
          <div class="auth-form-header">    
              <legend align="center">Report Viewer</legend>
                   </div>
                  
              <div class="auth-form-body">
          
          <s:form name="myForm"  theme="simple" target="_blank">
              

              <%--<s:set name="pid" value="pid"/>
                <s:hidden name="pid" value="%{pid}"/>--%>
              
              
                  

                 

                  <table>
                      <tr>
                             <td>For Employee Wise Report Enter ID        :</td>
                             <td><s:textfield name="id" id="id" cssClass="userId"/></td>
                             
                             
                             <td >
                                 <s:submit value="Click" onmouseover="report4()"  action="showReportHis1" cssClass="btn btn-primary btn_fix_size">
                                <s:param name="id" value="id" />
                             </s:submit></td>
                             
                              <td >
                             <div style="color: #9c2400;font-size: 15px; text-shadow: 0 1px 1px rgba(0, 0, 0, 0.75);opacity: 1; height: auto;">
                             <s:property value="message2"/>
                             </div>
                             
                             
                             
                             </tr>
                             
                             <tr>
                                 
                                  <td>For IP Wise Report Enter IP        :</td>
                             <td><s:textfield name="ip" id="ip" cssClass="userId"/></td>
                                 
                                 
                             </tr>
                             
                             <tr>
                                 
                                  <td>For Tag Wise Report Enter Tag        :</td>
                             <td><s:textfield name="fklid" id="fklid" cssClass="userId"/></td>
                                 
                                 
                             </tr>
                                 
                             <tr> 
                            <td>Start Date:</td>
                             <td style="min-height: 35px; margin-left: 5px;  padding: 7px 3px; background-position: right center;border: 1px solid #cccccc; -webkit-border-radius: 3px;-moz-border-radius: 3px;border-radius: 3px;box-shadow: inset 0 1px 2px inset 0 1px 1px rgba(0, 0, 0, 0.075);-moz-box-sizing: border-box; box-sizing: border-box;transition: all 0.15s ease-in;-webkit-transition: all 0.15s ease-in 0; vertical-align: middle;
                                margin-top: 3px;margin-bottom: 3px; height: 15px;  width: 150px;  display: inline-block;  font-size: 13px;   font-weight: normal;  
                                line-height: 10px ;  ">
                                 
                                 <s:datetimepicker  name="date1" id="date1" displayFormat="yyyy-MM-dd"  />
                                 
                             </td> 
                             
                             
                             <td >
                                 <s:submit value="View Report" onmouseover="report4()"  action="showReportHis2" cssClass="btn btn-primary btn_fix_size">
                                
                             </s:submit></td>
                             
                             
                             
                             </tr>
                             
                             <tr> 
                            <td>End Date:</td>
                             <td style="min-height: 35px; margin-left: 5px;  padding: 7px 3px; background-position: right center;border: 1px solid #cccccc; -webkit-border-radius: 3px;-moz-border-radius: 3px;border-radius: 3px;box-shadow: inset 0 1px 2px inset 0 1px 1px rgba(0, 0, 0, 0.075);-moz-box-sizing: border-box; box-sizing: border-box;transition: all 0.15s ease-in;-webkit-transition: all 0.15s ease-in 0; vertical-align: middle;
                                margin-top: 3px;margin-bottom: 3px; height: 15px;  width: 150px;  display: inline-block;  font-size: 13px;   font-weight: normal;  
                                line-height: 10px ;  ">
                                 
                                 <s:datetimepicker  name="date2" id="date2" displayFormat="yyyy-MM-dd"  />
                                 
                             </td> 
                             
                             
                             
                             </tr>

                             
                  </table>
                                 <div align="center">
                                 <br/>
                                 <br/>
                                 <p style="color: #9c2400">Note : For first 3 report use 'click' button. Don't Fill First 3 Text Field at a time </p>
                             </div>
                  <br/>

              
          </s:form>
                  
                  
         </div>      
          
          </div>
                 


                          
                      
          
           
         
                  
        
          
             <div style="color: #000;font-size: 15px; text-shadow: 0 1px 1px rgba(0, 0, 0, 0.75);opacity: 1;height: auto;">
                <s:property value="message"/>
            </div>
            
              







      </center>
            
            
     </div>
            
            <script>
               
    
    function subdept(){
        
        document.myForm.action = "showSubdept";
        document.myForm.submit();
        
    }
    /*repositorySearch.RedirectAction.createRunResourceAction = function(resource, inNewTab) {
                if (!resource) {
                    resource = resource ? resource : repositorySearch.model.getSelectedResources()[0];
                }

                var factoryMethod = repositorySearch.runActionFactory[resource.typeSuffix()];

                if (factoryMethod) {
                   //return factoryMethod(resource, inNewTab);  this was the original 
                    return factoryMethod(resource, true);
                } else {
                    return new repositorySearch.Action(function() {
                        alert("Run action for resource type '" + resource.resourceType + "' is not implemented!");
                    });
                }
            };*/  
                
                
                
            </script>        
    </body>
    
</html>
