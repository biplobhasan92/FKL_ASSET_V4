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
        <link href='style.css' rel='stylesheet' type='text/css'/>
        <link href='css/button.css' rel='stylesheet' type='text/css'/>
        <link rel="icon" href="images/icon.gif" type="image/gif" sizes="16x16">
        <title>FKL ASSET V4 | Search & Update</title>
    </head>
    <body>
        <%@include file="mainMenu.jsp" %>
        <div class='fix main'> <!--  main DIV is Start  -->
        <div class="border"></div>
            <!--  #######################   mian menu  ##################################################################-->
      <center>
           <div style="color: #9c2400;font-size: 15px; text-shadow: 0 1px 1px rgba(0, 0, 0, 0.75);opacity: 1; height: auto;">
            <s:property value="message"/>
          </div>
            
          
          
          <div class='fix form'>
          
          <div class="auth-form-header"> 
         
          <legend align="center">Search/Update Machine</legend>
                  
                  </div>
                  
         <div class="auth-form-body">
          
          <s:form action="updateM" theme="simple">
              

              <s:set name="pid" value="pid"/>
              <s:hidden name="pid" value="%{pid}"/>
              
              <s:set name="id" value="id"/>
              <s:hidden name="id" value="%{id}"/>

              <s:set name="name" value="name"/>
              <s:hidden name="name" value="%{name}"/>
              
               <s:set name="designation" value="designation"/>
              <s:hidden name="designation" value="%{designation}"/>
              
               <s:set name="dept" value="dept"/>
              <s:hidden name="dept" value="%{dept}"/>
              
              
              
              
              
              
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
                             <s:submit value="Search" action="searchM2" id="search" cssClass="btn btn-primary btn-large">
                                <s:param name="id" value="id" />
                             </s:submit>
                             </td>
                             
                             <div style="color: #9c2400;font-size: 15px; text-shadow: 0 1px 1px rgba(0, 0, 0, 0.75);opacity: 1; height: auto;">
                             <s:property value="message2"/>
                             </div>
                         
                      </tr>

                      
                      
                     
                      
                      
                       
                       <tr id="tagDivo">
                             
                             
                             <td>IP Address:</td>
                             <td><s:textfield name="ip" id="ip" cssClass="userId"/></td>
                             
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
                            <td>Product Type:</td>
                             <td><s:select name="mtype" id="mtype" list="{'Desktop', 'Laptop', 'Printer', 'Camera', 'Scanner'}"
                                     headerKey="" headerValue="---Select Status---" cssClass="select"/></td>
                             
                            <td align="center">
                             
                              <s:submit value="New Type" action="addType" cssClass="btn btn-primary btn-large"/>
                            </td>
                             
                             
                             
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
                          
                            
                            
                            
                      </tr>
                      
                     
                      
                      
                      </table>
                      
                      
                      

                     
                      <table>
                      
                          
                          <tr>
                             <td align="center">
                             
                              <s:submit value="Update" cssClass="btn btn-primary btn-large"/>
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

