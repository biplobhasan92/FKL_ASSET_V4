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
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/validation.js"></script>
        <script src="js/sweetalert-master/dist/sweetalert.min.js"></script>
        <link rel="stylesheet" type="text/css" href="js/sweetalert-master/dist/sweetalert.css">
        <link href='style.css' rel='stylesheet' type='text/css'/>
        <link href='css/button.css' rel='stylesheet' type='text/css'/>
        <title>Entry</title>
        <script>
            window.onload.document.getElementById("msuccess1").setAttribute("style","display: none");
        </script>
       <s:head theme="ajax" debug="true"/>
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

                        <legend align="center">Add/Assign New Machine</legend>

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
                                        <!--<button class="confirm"  onclick="addMErrClose()" tabindex="1" style="background-color: #BFB389; box-shadow: 0px 0px 2px rgba(140, 212, 245, 0.8), 0px 0px 0px 1px rgba(0, 0, 0, 0.05) inset;">OK</button>-->

                                        <s:url id="addM" action="addM" ></s:url>
                                        <s:a href="%{addM}"  ><h4 style="font-size: 20px; color: #BFB389;">Back To Home</h4></s:a>
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




                                <s:property value="message2"/></div>


                        </div> 




                        <s:form action="saveM"  theme="simple">


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
                                    <td>

                                        <%--<s:select name="mtype" id="mtype" list="{'Desktop', 'Laptop', 'Printer', 'Camera', 'Scanner','Plotter'}"
                                               headerKey="" headerValue="---Select Type---" cssClass="select"  onchange="typeChange()"  />--%>


                                        <s:select list="%{productList}" name="mtype" id="mtype" 
                                                  headerKey="" headerValue="---Select Type---" cssClass="select" onchange="typeChange()"></s:select>





                                        </td>



                                        <td>Handover Date:</td>
                                        <td style="min-height: 35px; margin-left: 5px;  padding: 7px 3px; background-position: right center;border: 1px solid #cccccc; -webkit-border-radius: 3px;-moz-border-radius: 3px;border-radius: 3px;box-shadow: inset 0 1px 2px inset 0 1px 1px rgba(0, 0, 0, 0.075);-moz-box-sizing: border-box; box-sizing: border-box;transition: all 0.15s ease-in;-webkit-transition: all 0.15s ease-in 0; vertical-align: middle;
                                margin-top: 3px;margin-bottom: 3px; height: 15px;  width: 150px;  display: inline-block;  font-size: 13px;   font-weight: normal;  
                                line-height: 10px ;  ">

                                        <s:datetimepicker  name="hdate" id="hdate" displayFormat="dd-MM-yyyy"  />

                                    </td>

                                    <td>Memo No:</td>
                                    <td><s:textfield name="memo" id="memo" cssClass="userId"/></td>






                                </tr>


                                <tr>



                                    <td>Supplier:</td>
                                    <td><s:textfield name="supplier" id="supplier" cssClass="userId"/></td> 

                                    <td>Supplier Warrenty (In Month No):</td>
                                    <td><s:textfield name="suplrwrnty" id="suplrwrnty" cssClass="userId"/></td>

                                    <td>Product Lifetime (In Month No):</td>
                                    <td><s:textfield name="prdtlife" id="prdtlife" cssClass="userId"/></td>



                                </tr>





                                <tr>


                                    <td>Product Cost:</td>
                                    <td><s:textfield name="cost" id="cost" cssClass="userId"/></td>

                                    <td>Product Purchase Date:</td>
                                    <td style="min-height: 35px; margin-left: 5px; padding: 7px 3px; background-position: right center;border: 1px solid #cccccc; -webkit-border-radius: 3px;-moz-border-radius: 3px;border-radius: 3px;box-shadow: inset 0 1px 2px inset 0 1px 1px rgba(0, 0, 0, 0.075);-moz-box-sizing: border-box; box-sizing: border-box;transition: all 0.15s ease-in;-webkit-transition: all 0.15s ease-in 0; vertical-align: middle;
                                margin-top: 3px;margin-bottom: 3px; height: 15px;  width: 150px;  display: inline-block;  font-size: 13px;   font-weight: normal;  
                                line-height: 10px ;  ">

                                        <s:datetimepicker  name="buydate" id="buydate" displayFormat="yyyy-MM-dd"  />

                                    </td>




                                </tr>


                                <tr>

                                    <td>Image(ISO) Entry Date:</td>

                                    <td style="min-height: 35px; margin-left: 5px;  padding: 7px 3px; background-position: right center;border: 1px solid #cccccc; -webkit-border-radius: 3px;-moz-border-radius: 3px;border-radius: 3px;box-shadow: inset 0 1px 2px inset 0 1px 1px rgba(0, 0, 0, 0.075);-moz-box-sizing: border-box; box-sizing: border-box;transition: all 0.15s ease-in;-webkit-transition: all 0.15s ease-in 0; vertical-align: middle;
                                margin-top: 3px;margin-bottom: 3px; height: 15px;  width: 150px;  display: inline-block;  font-size: 13px;   font-weight: normal;  
                                line-height: 10px ;  ">

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

                                    <td align="center">

                                        <s:submit value="Update Machine" action="upM" cssClass="btn btn-primary btn-large"/>
                                    </td>  


                                    <td align="center">

                                        <s:submit value="Save" onmouseover="/addME()" cssClass="btn btn-primary btn-large"/>
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
