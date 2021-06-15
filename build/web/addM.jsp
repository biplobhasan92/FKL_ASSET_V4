<%-- 
    Document   : addM - First and main form of this application
    Created on : Mar 27, 2017, 2:45:56 PM
    Author     : Ahsan-IT
    Author     : Hasan Mobarak<biplobjugp40@gmail.com> (July 15, 2018)
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
    <s:if test="%{#session.master == null && #session.admin == null && #session.entry == null}">
        <jsp:forward   page="index.jsp" />
    </s:if>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/validation.js"></script>
        <script src="js/sweetalert-master/dist/sweetalert.min.js"></script>
        <link rel="stylesheet" type="text/css" href="js/sweetalert-master/dist/sweetalert.css">
        <link href='style.css' rel='stylesheet' type='text/css'/>
        <link rel="icon" href="images/icon.gif" type="image/gif" sizes="16x16">
        <link href='css/button.css' rel='stylesheet' type='text/css'/>
        <style>
            .btn_fix_size {
                width: 170px;
                height: 35px;
            }
            .ip_check {
                color: #C01D1D;
                font-size: 18px;
            }
        </style>
        <script>
            var count = 0;
            function isSave2(){
                var error = 'Yes';
                var error2 = '';
                var message = '';
                var ipCheck = 0;
                var ip         = document.getElementById('ip').value;
                var id         = document.getElementById('id').value;
                var dept       = document.getElementById('dept').value;
                var utype      = document.getElementById('utype').value;
                var mtype      = document.getElementById('mtype').value;
                var suplrwrnty = document.getElementById('suplrwrnty').value;
                var prdtlife   = document.getElementById('prdtlife').value;
                var cost       = document.getElementById('cost').value;
                var hdate      = dojo.widget.byId('hdate').getValue();
                var buydate    = dojo.widget.byId('buydate').getValue();

                if (utype === ""){
                    error2 = 'Yes';
                    message = 'Enter User Type \n';
                    document.getElementById("utype").focus();
                }else if (id === "" && dept === "") {
                    error2 = 'Yes';
                    message = 'Enter ID or Select Dept \n';
                } else if (mtype === "") {
                    error2 = 'Yes';
                    message = 'Enter Machine Type \n';
                    document.getElementById("mtype").focus();
                } else if (hdate === "") {
                    error2 = 'Yes';
                    message = 'Enter Handover Date \n';
                    document.getElementById("hdate").focus();
                } else if (suplrwrnty === "") {
                    error2 = 'Yes';
                    message = 'Enter Suppiler Warrenty In month \n';
                    document.getElementById("suplrwrnty").focus();
                } else if (prdtlife === "") {
                    error2 = 'Yes';
                    message = 'Enter Product Lifetime In month \n';
                    document.getElementById("prdtlife").focus();
                } else if (cost === "") {
                    error2 = 'Yes';
                    message = 'Enter Product Cost in Number \n';
                    document.getElementById("cost").focus();
                } else if (buydate === "") {
                    error2 = 'Yes';
                    message = 'Enter Buy Date \n';
                    document.getElementById("buydate").focus();
                } else if (ip === "") {
                    var status = confirm("Are You Sure Want To Save Without IP?");
                    if (status == true) {
                        error2 = '';
                    } else {
                        error2 = 'Yes';
                        ipCheck = 1;
                    }
                }
                if (error2 === 'Yes') {
                    if (ipCheck == 0) {
                        sweetAlert(message);
                    } else {
                        document.getElementById("ip").focus();
                    }
                }
                document.MM_returnValue = (error2 == '');
            }
            
            
            
            
            function qtyCheck(id, value){
                var status = !isNaN(value);
                if (status == false) {
                    alert("Invalid input!");
                    document.getElementById(id).value = "";
                }
            }
            
            
            
            
            function isSave(){
                var ip = document.getElementById('ip').value;
                if (ip === "" && count == 0) {
                    var status = confirm("Are You Sure Want To Save Without IP?");
                    if (status == true) {
                        count = 1;
                    } else {
                        count = 0;
                        document.getElementById("ip").focus();
                    }
                }
            }


        
            $(document).ready(function (){
                $('#ip').blur(function (event){
                    var ip = $('#ip').val();
                    $.ajax({
                        url: 'ajaxIpChck',
                        method: 'POST',
                        data: {ip: ip},
                        dataType: 'text',
                        success: function (responseText) {
                            $('#output').fadeIn();
                            $('#output').html(responseText);
                        }
                    });
                });
                

                $('.t').hover(function (event) {
                    var pos = $(this).position();
                    var newPos = (pos.top + 20) + 'px';
                    var newPos2 = (pos.left) + 'px';
                    var newWidth = $(this).width();
                    $('.test').css("display", "block");
                });


                $('.content').hover(function (event) {
                    $('.test').css("display", "none");
                });
            });

            function enable(){
                document.getElementById("tagLabel").removeAttribute("style");
                document.getElementById("tagDiv").setAttribute("style", "disply : block");
                document.getElementById("search").setAttribute("value", "Search");
            }

            var disable = document.getElementById("tagLabel");
            disable.onmouseover = function (){
                document.getElementById("tagLabel").setAttribute("style", "color: #9c2400");
                document.getElementById("tagDiv").setAttribute("style", "display: none");
                document.getElementById("search").setAttribute("value", "Show");

            }
        </script>

        <title>FKL ASSET V4 | Add Machine</title>

        <s:head theme="ajax" debug="true"/>

        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script>
            $(document).ready(function () {
                $('#ip').blur(function (event) {
                    var ip = $('#ip').val();
                    $.ajax({
                        url: 'ajaxIpChck',
                        method: 'POST',
                        data: {ip: ip},
                        dataType: 'text',
                        success: function (responseText) {
                            $('#output').fadeIn();
                            $('#output').html(responseText);
                        }
                    });
                });

                $('.t').hover(function (event) {
                    var pos = $(this).position();
                    var newPos = (pos.top + 20) + 'px';
                    var newPos2 = (pos.left) + 'px';
                    var newWidth = $(this).width();
                    $('.test').css("display", "block");
                });


                $('.content').hover(function (event) {
                    $('.test').css("display", "none");
                });
            });

            function enable() {
                document.getElementById("tagLabel").removeAttribute("style");
                document.getElementById("tagDiv").setAttribute("style", "disply : block");
                document.getElementById("search").setAttribute("value", "Search");
            }

            var disable = document.getElementById("tagLabel");
            disable.onmouseover = function () {
                document.getElementById("tagLabel").setAttribute("style", "color: #9c2400");
                document.getElementById("tagDiv").setAttribute("style", "display: none");
                document.getElementById("search").setAttribute("value", "Show");

            }
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

            <div class="container-fluid">
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
                                    <s:set    name="pid" value="pid"/>
                                    <s:hidden name="pid" value="%{pid}"/>
                                    <s:set    name="name" value="name"/>
                                    <s:hidden name="name" id="name" value="%{#session.aname}" />
                                    <%--<s:hidden name="name" value="%{name}"/>--%>
                                    <s:set    name="designation" value="designation"/>
                                    <s:hidden name="designation" value="%{designation}"/>
                                    <s:set    name="dept" value="dept"/>
                                    <%--<s:hidden name="dept" value="%{dept}"/>--%>

                                    <table border="0">
                                        <col width="150">
                                        <col width="180">
                                        <col width="150">
                                        <col width="180">
                                        <col width="150">
                                        <col width="180">
                                        <div id="msuccess1" style="display: none;">
                                            <div style="color: #9c2400;font-size: 15px; text-shadow: 0 1px 1px rgba(0, 0, 0, 0.75);opacity: 1; height: auto;">
                                                <%--<s:property value="message2"/>--%>
                                            </div>
                                        </div>

                                        <tr>
                                            <td>User Type:*</td>
                                            <td>
                                                <s:select name="utype" id="utype" list="{'Individual','Dept'}"
                                                          headerKey="" headerValue="---Select Type---" cssClass="select"  onchange="typeChange()"  />
                                            </td>
                                            <td>
                                                <div id="idlebel">Employee I.D.:*</div>
                                                <div id="deptlebel" style="display: none;">Dept. Name:*</div>
                                            </td>
                                            <td>
                                                <div id="idtype">
                                                    <s:textfield name="id" id="id"  cssClass="userId"/>
                                                </div>
                                                <div id="depttype" style="display: none;">
                                                    <s:select list="%{deptList}" name="dept" id="dept" 
                                                              headerKey="" headerValue="---Select Dept---" cssClass="userId"></s:select>
                                                    </div>
                                                </td>
                                                <td>IP Address:</td>
                                                <td>
                                                <s:textfield name="ip" id="ip" cssClass="userId"/>
                                                <div id="output" style="color: #9c2400;font-size: 15px; text-shadow: 0 1px 1px rgba(0, 0, 0, 0.75);opacity: 1; height: auto;"></div>
                                            </td>
                                            <td></td>
                                        </tr>

                                        <tr>
                                            <td>Hard Disk(GB):</td>
                                            <td><s:textfield name="hdd" id="hdd" cssClass="userId"/></td>
                                            <td>Mother Board:</td>
                                            <td><s:textfield name="mboard" id="mboard" cssClass="userId"/></td>
                                            <td>RAM(GB):</td>
                                            <td><s:textfield name="ram" id="ram" cssClass="userId"/></td>
                                            <td>
                                                <s:submit value="Save Machine" onclick="isSave2();return document.MM_returnValue"  cssClass="btn btn-primary btn-large btn_fix_size"/>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td>Processor:</td>
                                            <td><s:textarea name="chip" id="chip" cssClass="tarea"/></td>
                                            <td>Machine ID:</td>
                                            <td><s:textfield name="mid" id="mid" cssClass="userId"/></td>
                                            <td>Status:</td>
                                            <td><s:select name="pcstatus" id="pcstatus" list="{'NEW', 'ASSIGNED', 'RE-ASSIGNED', 'UPGRADE', 'REPAIRED', 'DAMAGED'}"
                                                      headerKey="" headerValue="---Select Status---"  cssClass="select"/></td>
                                            <td>
                                                <s:submit value="Update Machine" action="upM" cssClass="btn btn-primary btn-large btn_fix_size"/>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td>Internet Connection Status:</td>
                                            <td>
                                                <s:select name="nstatus" id="nstatus" list="{'Active', 'Inactive'}"
                                                    headerKey="" headerValue="---Select Status---" cssClass="select" />
                                            </td>
                                            <td>Product Type:*</td>
                                            <td>
                                                <s:select list="%{productList}" name="mtype" id="mtype" headerKey="" headerValue="---Select Type---" cssClass="select"></s:select>
                                            </td>
                                            <td>Monitor Description:*</td>
                                            <td>
                                                <s:textfield name="monitor_desc" id="monitor_desc" cssClass="userId"/> 
                                            </td>
                                            <td>
                                                <s:submit value="Create User" action="createUser" cssClass="btn btn-primary btn-large btn_fix_size"/>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td>Handover Date:*</td>
                                            <td class="Image_iso_entry_date">
                                                <s:datetimepicker  name="hdate" id="hdate" displayFormat="dd-MM-yyyy"  /> 
                                            </td>
                                            <td>Memo No:</td>
                                            <td><s:textfield name="memo" id="memo" cssClass="userId"/></td>
                                            <td>Supplier:</td>
                                            <td><s:textfield name="supplier" id="supplier" cssClass="userId"/></td>                                            
                                            <td>
                                                <s:submit value="Settings" action="settings" cssClass="btn btn-primary btn-large btn_fix_size"/> 
                                            </td>
                                        </tr>
                                        
                                        <tr>
                                            <td>Supplier warranty (In Month No):*</td>
                                            <td><s:textfield name="suplrwrnty" id="suplrwrnty" onkeyup="qtyCheck(this.id,this.value)" cssClass="userId"/></td>
                                            <td>Product Lifetime (In Month No):*</td>
                                            <td><s:textfield name="prdtlife" id="prdtlife" onkeyup="qtyCheck(this.id,this.value)" cssClass="userId"/></td>  
                                            <td>Product Cost:*</td>
                                            <td><s:textfield name="cost" id="cost" onkeyup="qtyCheck(this.id,this.value)"  cssClass="userId"/></td>                                            
                                            <td></td>
                                        </tr>
                                        
                                        <tr>
                                            <td>Product Purchase Date:*</td>
                                            <td class="Image_iso_entry_date">
                                                <s:datetimepicker  name="buydate" id="buydate" displayFormat="yyyy-MM-dd"  />
                                            </td>

                                            <td>DDN /REQ No:* </td>
                                            <td><s:textfield name="imgloc" id="imgloc" cssClass="userId"/></td>
                                            <td>Remarks:</td>
                                            <td><s:textarea name="remarks" id="remarks" cssClass="tarea"/></td>
                                        </tr>                                                                             
                                    </table>
                                    
                                    <div style="float: left; font-size: 17px; color: #9c2400" >
                                        <p> User Must fill (*) the field   </p>
                                    </div>
                                    <table>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                    </table>
                                </s:form>
                            </div>
                        </div>
                    </center>
                </div>
            </div>
        </div>
    </body>
</html>
