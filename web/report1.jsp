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
        <link rel="icon" href="images/icon.gif" type="image/gif" sizes="16x16">
        <link href='style.css' rel='stylesheet' type='text/css'/>
        <link href='css/button.css' rel='stylesheet' type='text/css'/>
        <title>FKL ASSET V4 | Report</title>
    </head>
    <body>
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
          
          <s:form name="myForm" action="showReport2" theme="simple">
                  <table>
                      <tr>
                             <td>For Employee Wise Report Enter ID        :</td>
                             <td><s:textfield name="id" id="id" cssClass="userId"/></td>
                             
                             
                             <td >
                                 <s:submit value="View Report" onmouseover="report4()"  action="showReport2" cssClass="btn btn-primary btn-large">
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
                             <td>For Dept. Wise Report Enter Dept.        :</td>
                             <%--<td><s:textfield name="dept" id="dept" cssClass="userId"/></td>--%>
                             
                             <td><s:select list="%{mdeptList}" name="mdept" id="mdept" 
                                       headerKey="" headerValue="---Select Dept---" cssClass="userId"  onchange="/subdept()"   ></s:select></td>
                             
                             
                              <td >
                             <s:submit value="Show SubDept" onmouseover="/report2()" action="showSubdept"  cssClass="btn btn-primary btn-large">
                                <s:param name="dept" value="dept" />
                             </s:submit>
                             </td>
                             
                             <td >
                             <s:submit value="View Report" onmouseover="/report2()" action="showReport3"  cssClass="btn btn-primary btn-large">
                                <s:param name="dept" value="dept" />
                             </s:submit>
                             </td>
                             </tr>
                             
                             
                             <tr>
                             <td>For Sub Dept. Wise Report Enter Sub Dept.        :</td>
                             <%--<td><s:textfield name="dept" id="dept" cssClass="userId"/></td>--%>
                             
                             <td><s:select list="%{subDeptList}" name="dept" id="dept" 
                                       headerKey="" headerValue="---Select Sub Dept---" cssClass="userId"></s:select></td>
                             
                             
                             <td >
                             <s:submit value="View Report" onmouseover="/report2()" action="showReport7" cssClass="btn btn-primary btn-large">
                                <s:param name="dept" value="dept" />
                             </s:submit>
                             </td>
                             </tr>
                             
                             
                             <tr>
                             <td>For Product Type Wise Report Enter Product Type        :</td>
                             <%--<td><s:textfield name="dept" id="dept" cssClass="userId"/></td>--%>
                             
                             <td><s:select name="mtype" id="mtype" list="{'Desktop', 'Laptop', 'Printer', 'Camera', 'Scanner'}"
                                       headerKey="" headerValue="---Select Type---" cssClass="userId"></s:select></td>
                             
                             
                             <td >
                             <s:submit value="View Report" onmouseover="checkDept()" action="showReport4" cssClass="btn btn-primary btn-large">
                                <s:param name="mtype" value="mtype" />
                             </s:submit>
                             </td>
                             </tr>
                             
                             <tr>
                             
                             <td>For Product Wise Report Enter Product ID        :</td>
                             <td><s:textfield name="pid" id="pid" cssClass="userId"/></td>
                             
                              
                             <td >
                                 <s:submit value="View Report" onmouseover="/report3()" action="productReport" cssClass="btn btn-primary btn-large">
                                <s:param name="pid" value="pid" />
                             </s:submit></td>
                             
                              <td >
                              </tr>
                             
                             
                             
                             <tr>
                             <td>For All Dept.Wise Report Click here      :</td>
                             <td >
                             
                             <s:submit value="View Report" action="viewReport" cssClass="btn btn-primary btn-large"/>
                             </td>
                             
                             
                              <td >
                             
                             <s:submit value="Excel Report" action="viewReportex" cssClass="btn btn-primary btn-large"/>
                             </td>
                             
                             
                             </tr>
                             
                             <tr>
                             <td>For All Product Report Click here      :</td>
                             <td >
                             
                             <s:submit value="View Report" action="allProductReport" cssClass="btn btn-primary btn-large"/>
                             </td>
                             
                             
                            
                             
                             
                             
                             </tr>
                             
                             
                             
                             
                     
                  </table>

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
