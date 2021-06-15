
<%-- 
    Document   : entry
    Created on : Mar 3, 2017, 10:49:16 AM
    Author : Hasan Mobarak
--%>


<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true" %> 
<%@include file="linkingScriptAndCss.jsp" %>

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
        <link rel="icon" href="images/icon.gif" type="image/gif" sizes="16x16">
        <link rel="stylesheet" type="text/css" href="js/sweetalert-master/dist/sweetalert.css">
        <link href='style.css' rel='stylesheet' type='text/css'/>
        <link href='css/button.css' rel='stylesheet' type='text/css'/>
        <title>FKL ASSET V4 | View Reprot</title>                
        <style>      
           .output{background-color: #f6f6f6; margin-left: 2px;  }
           .output.ul{}
           .output.ul.li{cursor: pointer; padding: 2px;}
           .btn_fix_size {width: 170px;height: 30px;}            
        </style>
        
        <script src="http://code.jquery.com/jquery-latest.js">
        </script>
        <script>
            $(document).ready(function(){
                $('#mdept').change(function(event){
                    $('#output').empty();                    
                    var dept_name=$('#mdept').val();
                    $.ajax({
                        url:'ajaxData',
                        method:'POST',
                        data:{dept_name:dept_name},
                        dataType:'text',
                        success: function(responseText){
                           $('#output').fadeIn();
                           $('#output').html(responseText);         
                        }
                    });
                });
            });
        </script>                
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
            <table>
                <tr>
                    <td>For Employee Wise Report Enter ID :</td>
                    <td><s:textfield name="id" id="id" cssClass="userId"/></td>
                        <td>
                            <s:submit value="Click" onmouseover="report4()"  action="showReport2" cssClass="btn btn-primary btn-large btn_fix_size">
                                <s:param name="id" value="id" />
                            </s:submit>
                        </td>
                        <td>
                            <div style="color: #9c2400;font-size: 15px; text-shadow: 0 1px 1px rgba(0, 0, 0, 0.75);opacity: 1; height: auto;">
                                <s:property value="message2"/>
                            </div>
                        </td>

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
                             <td>For Dept. Wise Report Enter Dept. :</td>
                             
                             <td>
                                <s:select list="%{mdeptList}" name="mdept" id="mdept" 
                                       headerKey="" headerValue="---Select Dept---" cssClass="userId"  onchange="/searchItem2()"   ></s:select>
                             </td>
                             
                             <td>
                                <s:submit value="View Report" onmouseover="/report2()" action="showReport3"  cssClass="btn btn-primary btn-large btn_fix_size">
                                    <s:param name="dept" value="dept" />
                                </s:submit>
                             </td>
                             </tr>
                             
                             
                             <td>For Sub Dept. Wise Report Enter Sub Dept. :</td>
                             
                             <td>
                                 <div id="output">
                                     
                                      <select id="dept" name="dept" class="userId" >
                                     <option value="">---Select Sub Dept---</option>
                                      </select>
                                 </div> 
                                 
                             </td>

                             <td>
                             <s:submit value="View Report" onmouseover="/report2()" action="showReport7" cssClass="btn btn-primary btn-large btn_fix_size">
                                <s:param name="dept" value="dept" />
                             </s:submit>
                             </td>
                             
                        
                             
                             <tr>
                             <td>For Product Type Wise Report Enter Product Type :</td>
                             
                             <td>
                                 <s:select list="%{productList}" name="mtype" id="mtype" 
                                       headerKey="" headerValue="---Select Type---" cssClass="select" ></s:select>                                                          
                             </td>
                             
                             
                             <td >
                             <s:submit value="View Report" onclick="/checkDept()" action="showReport4" cssClass="btn btn-primary btn-large btn_fix_size">
                                <s:param name="mtype" value="mtype" />
                             </s:submit>
                             </td>
                             </tr>
                             
                             <tr>
                             
                             <td>For Product Wise Report Enter Product ID        :</td>
                             <td><s:textfield name="pid" id="pid" cssClass="userId"/></td>
                             
                              
                             <td >
                                 <s:submit value="View Report" onmouseover="/report3()" action="productReport" cssClass="btn btn-primary btn-large btn_fix_size">
                                <s:param name="pid" value="pid" />
                             </s:submit></td>
                             
                              <td >
                              </tr>
                             
                             
                             
                            <tr>
                                <td>For All Dept.Wise Report Click here :</td>
                                <td>                             
                                    <s:submit value="View Report" action="viewReport" cssClass="btn btn-primary btn-large btn_fix_size"/>
                                </td>
                                <td>                             
                                    <s:submit value="Excel Report" action="viewReportex" cssClass="btn btn-primary btn-large btn_fix_size"/>
                                </td>                                                      
                            </tr>
                             

                            <tr>
                                <td>For All Product Report Click here :</td>
                                <td>
                                    <s:submit value="View Report" action="allProductReport" cssClass="btn btn-primary btn-large btn_fix_size"/>
                                </td>                            
                            </tr>
                            
                            <tr>
                                <td>Department wise IT Asset Quantity :</td>
                                <td>
                                    <s:submit value="Asset Top Sheet" action="assetTopSheet" cssClass="btn btn-primary btn-large btn_fix_size" />
                                </td>                            
                            </tr>
                            
                            <tr>
                                <td>Department wise All IT Asset Records :</td>
                                <td>
                                    <s:submit value="All IT Asset" action="allITAsset" cssClass="btn btn-primary btn-large btn_fix_size" />
                                </td>                            
                            </tr>
                        </table>
                             <div align="center">
                                 <br/>
                                 <br/>
                                 <p style="color: #9c2400">Note : For first 3 report use 'click' button. Don't Fill First 3 Text Field at a time </p>
                             </div>
                  <br/>
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
