<%-- 
    Document   : addM
    Created on : Mar 27, 2017, 2:45:56 PM
    Author     : Ahsan-IT, Hasan Mobarak
--%>

<%@taglib prefix="s" uri="/struts-tags" %>
<%@include file="linkingScriptAndCss.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    response.setHeader("Cache-Control", "no-store, must-revalidate");
    if (session.getAttribute("aname") == null){
        response.sendRedirect("index.jsp");
    }
%>

<!DOCTYPE html>
<html>
    <%--
    <s:if test="%{#session.master == null && #session.admin == null && #session.entry == null}">
        <jsp:forward   page="index.jsp" />
    </s:if> --%>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href='style.css' rel='stylesheet' type='text/css'/>
        <link href='css/button.css' rel='stylesheet' type='text/css'/>
        <link rel="icon" href="icon.gif" type="image/icon.gif" sizes="16x16">
        <link rel="icon" href="images/icon.gif" type="image/gif" sizes="16x16">
        <title>FKL ASSET V4</title>
    </head>
    <body>
        
        
        <%@include file="mainMenu.jsp" %>
        <div class='fix main'>
         
           <div class='fix menu'>
			
            <div id='cssmenu' >
                
                
                    
                <ul>
                        <li><div class='im3'><img src='img.gif' /></div></li>
                        <s:url id="addM" action="addM" ></s:url>
                        <s:url id="searchEntry" action="searchEntry" ></s:url>
                        <s:url id="showPerson" action="showPerson" ></s:url>
                        <s:url id="openReport" action="openReport" ></s:url>
                        <s:url id="newEmp" action="newEmp" ></s:url>
                        <s:url id="logout" action="logout" ></s:url>
                       
                        <li><s:a href="%{addM}">New Entry</s:a></li>
                            <li><s:a href="%{searchEntry}">Search/Update</s:a></li>
                            <li><s:a href="%{showPerson}">Total Machine Records</s:a></li>
                            <li><s:a href="%{openReport}">View Reports</s:a></li>
                            <li><s:a href="%{newEmp}">Add Employee</s:a></li>
                            <li><s:a href="%{logout}">Log Out</s:a></li>
                    </ul> 
                   
                    
            </div>
               
               <div class="border"></div>
			
          </div>
        
        
      <center>
          
          
        
           <div style="color: #9c2400;font-size: 15px; text-shadow: 0 1px 1px rgba(0, 0, 0, 0.75);opacity: 1; height: auto;">
            <s:property value="message"/>
          </div>
            
          
          
          <div class='fix form'>
          
          <div class="auth-form-header"> 
         
          <legend align="center">Search/Update/Assign Machine</legend>
                  
                  </div>
                  
         <div class="auth-form-body">
          
          <s:form action="saveM1" theme="simple">
              

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
              
              <%--<s:set name="fklid" value="fklid"/>
                <s:hidden name="fklid" value="%{fklid}"/>--%>
              
              
              
              
                  <table>
                   <col width="150">
                    <col width="180">
                    <col width="150">
                    <col width="180">
                    <col width="150">
                    <col width="180">
                      
                    
                          
                      
                      <tr>
                             <td style="color: #9c2400" id="tagLabel">Machine Tag NO:</td>
                             <td><s:textfield name="fklid" id="fklid"  cssClass="userId"/></td>
                             
                             
                             <td id="tagDiv" style="display: none;" >
                             <s:submit value="Search" action="searchM2" cssClass="btn btn-primary btn-large">
                                <s:param name="id" value="id" />
                             </s:submit>
                             </td>
                             
                             <div style="color: #9c2400;font-size: 15px; text-shadow: 0 1px 1px rgba(0, 0, 0, 0.75);opacity: 1; height: auto;">
                             <s:property value="message2"/>
                             </div>
                         
                      </tr>

                      
                      
                     
                      
                     
                       
                       <tr id="tagDivo">
                             
                             
                           
                             <td>Employee I.D.:</td>
                             <td><s:textfield name="id" id="id" cssClass="userId"/></td>
                             
                             <td>IP Address:</td>
                             <td><s:textfield name="ip" id="ip" cssClass="userId"/></td>
                             
                             <td>Hard Disk(GB:</td>
                             <td><s:textfield name="hdd" id="hdd" cssClass="userId"/></td>
                             
                             
                             
                             
                             
                             
                             
                             
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
                            <td>Product Type:</td>
                             <td><s:select name="mtype" id="mtype" list="{'Desktop', 'Laptop', 'Printer', 'Camera', 'Scanner'}"
                                     headerKey="" headerValue="---Select Type---" cssClass="select"/></td>
                             
                            <td align="center">
                             
                              <s:submit value="New Type" action="addType" cssClass="btn btn-primary btn-large"/>
                            </td>
                             
                             
                             
                      </tr>
                      
                      
                      </table>
                      
                      
                      

                     
                      <table>
                      
                          
                          <tr>
                              
                            <td align="center">
                             
                              <s:submit value="Update Machine" action="upM" cssClass="btn btn-primary btn-large"/>
                            </td>
                              
                              
                             <td align="center">
                             
                              <s:submit value="Save" cssClass="btn btn-primary btn-large"/>
                          </td>
                          
                          <td align="center">
                             
                              <s:submit value="Add Employee" action="newEmp" cssClass="btn btn-primary btn-large"/>
                          </td>
                          
                         
                          
                          
                          
                      </tr>
                  </table>

          </s:form>
                  
          </div>
                  
                  
         
             
              
        </div>
      
       </center>
            
            
      </div>
       <script>
     
    
    /*var enable=document.getElementById("search");
    enable.onmouseover= function (){
            document.getElementById("mlabel").removeAttribute("style")
            document.getElementById("fklid").removeAttribute("disabled");
        
        }*/
   
        
    function enable (){
            document.getElementById("tagLabel").removeAttribute("style");
            //document.getElementById("tagDiv").removeAttribute("style");
            //document.getElementById("tagDiv").setAttribute("style","disply : block");
            //document.getElementById("search").setAttribute("value","Search");
            document.getElementById("fklid").removeAttribute("disabled");
            //document.getElementById("fklid").style.disply="none";
            //document.getElementById("tag").setAttribute("style","disply : block");
        
        } 
        
     
        
     
    
    var disable=document.getElementById("tagLabel");
    disable.onmouseover= function () {
            document.getElementById("tagLabel").removeAttribute("style");
            document.getElementById("tagDiv").removeAttribute("style");
            //document.getElementById("fklid").removeAttribute("disabled");
            //document.getElementById("tagDiv").setAttribute("style","disply : block");
            //document.getElementById("tagLabel").setAttribute("style","color: #9c2400");
            //document.getElementById("tagDiv").setAttribute("style","display: none");
            //document.getElementById("search").setAttribute("value","Show");
         
        }
        
        
        
    var disable2=document.getElementById("tagDivo");
    disable2.onmouseover= function () {
            //document.getElementById("tagLabel").removeAttribute("style");
            //document.getElementById("tagDiv").removeAttribute("style");
            //document.getElementById("fklid").removeAttribute("disabled");
            //document.getElementById("tagDiv").setAttribute("style","disply : block");
            document.getElementById("tagLabel").setAttribute("style","color: #9c2400");
            document.getElementById("tagDiv").setAttribute("style","display: none");
            //document.getElementById("search").setAttribute("value","Show");
         
        }
     
    </script>    
          
     
    </body>
</html>
