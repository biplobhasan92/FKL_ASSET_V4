<%-- 
    Document   : ip_list_withVlan
    Created on : Nov 25, 2018, 10:50:06 AM
    Author     : Hasan Mobarak
--%>

<%@include file="linkingScriptAndCss.jsp" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    response.setHeader("Cache-Control", "no-store, must-revalidate");
    if (session.getAttribute("aname") == null){
        response.sendRedirect("index.jsp");
    }
%>


<!DOCTYPE HTML">
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>FKL ASSET V4 | I.P List With V-LAN</title>

        <script>
            function alertSuccess(var str){
                alert(str);
            } 
            function alertFailde(var str){
                alert(str);
            }
        </script>
        
        <style>
            h1, .v_lan{
                text-align: center;
            }
            .btn_ip_save_100{

            }
            .btn_fix_size {
                width: 170px;
                height: 35px;
            }
        </style>
    </head>

    <body>
        <%@include file="mainMenu.jsp" %>
        <div class='fix main'> <!--  main DIV is Start  -->   
                
            <div class="border"></div>
            <!--  #######################   mian menu  ##################################################################-->
            <div style="text-align: center">
                <h1>IP List with V-LAN</h1>
                <s:if test="sucssMesg != null">
                    <font color="green">
                        <s:property value="sucssMesg"/>
                    </font>
                </s:if>
                <s:if test="errMesg != null">
                   <font color="red">
                    <s:property value="errMesg"/>
                    </font>
                </s:if>
            </div>
            <br/>
            <div class="container-fluid">
                <!-- Nav tabs -->
                <ul class="nav nav-tabs" role="tablist" id="myTab">
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#home">100</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#menu1">101</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#menu2">102</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#menu3">103</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#menu4">104</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#menu5">105</a>
                    </li>
                     <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#menu6">106</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#menu7">107</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#menu8">108</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#menu9">109</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#menu10">110</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#menu92">192</a>
                    </li>
                </ul>
                <!-- Tab panes -->
                <div class="tab-content">
                    <div id="home" class="tab-pane active"><br>
                        <p class="v_lan">IP V-Lan 100</p>
                        <br/>
                        <table id="myTable" class="table table-striped table-bordered" style="width:100%">
                            <thead>
                                <tr>
                                   <th>SL</th>
                                    <th>I.P</th>
                                    <th>User Name</th>
                                    <th>Dept</th>
                                    <th>Type</th>
                                    <th>Status</th>
                                    <th>PBX Ext.</th>
                                    <th>Edit</th>
                                </tr>
                            </thead>

                            <tbody>
                                <s:iterator value="ipListVlan100">
                                    <tr>
                                        <td><s:property value="ip_sl_no"/></td>
                                        <td><s:property value="ip_no"/></td>
                                        <td><s:property value="ip_user_name"/></td>
                                        <td><s:property value="ip_user_dept"/></td>
                                        <td><s:property value="ip_type"/></td>
                                        <td><s:property value="ip_use_status"/></td>
                                        <td><s:property value="pbx_extension"/></td>
                                        <td>
                                            <a href="updateIpData100.action?ip_no=<s:property value="ip_no"/>">Edit</a>
                                        </td>
                                    </tr>
                                </s:iterator>
                            </tbody>
                        </table>
                    </div>
                    
                    <div id="menu1" class="container-fluid tab-pane fade"><br>
                        <p class="v_lan">IP V-Lan 101</p>
                        <br/>
                        <table id="myTable101" class="table table-striped table-bordered" style="width:100%">
                            <thead>
                                <tr>
                                    <th>SL</th>
                                    <th>I.P</th>
                                    <th>User Name</th>
                                    <th>Dept</th>
                                    <th>Type</th>
                                    <th>Status</th>
                                    <th>PBX Ext.</th>
                                    <th>Edit</th>
                                </tr>
                            </thead>

                            <tbody>
                                <s:iterator value="ipListVlan101">
                                    <tr>
                                       <td><s:property  value="ip_sl_no"/></td>
                                        <td><s:property value="ip_no"/></td>
                                        <td><s:property value="ip_user_name"/></td>
                                        <td><s:property value="ip_user_dept"/></td>
                                        <td><s:property value="ip_type"/></td>
                                        <td><s:property value="ip_use_status"/></td>
                                        <td><s:property value="pbx_extension"/></td>
                                        <td>
                                            <a href="updateIpData101.action?ip_no=<s:property value="ip_no"/>"> Edit </a>
                                        </td>
                                    </tr>
                                </s:iterator>
                            </tbody>
                        </table>
                    </div>
                    
                    <div id="menu2" class="container-fluid tab-pane fade"><br>
                        <p class="v_lan">IP V-Lan 102</p>
                        <table id="myTable102" class="table table-striped table-bordered" style="width:100%">
                            <thead>
                                <tr>
                                    <th>SL</th>
                                    <th>I.P</th>
                                    <th>User Name</th>
                                    <th>Dept</th>
                                    <th>Type</th>
                                    <th>Status</th>
                                    <th>PBX Ext.</th>
                                    <th>Edit</th>
                                </tr>
                            </thead>

                            <tbody>
                                <s:iterator value="ipListVlan102">
                                    <tr>
                                        <td><s:property value="ip_sl_no"/></td>
                                        <td><s:property value="ip_no"/></td>
                                        <td><s:property value="ip_user_name"/></td>
                                        <td><s:property value="ip_user_dept"/></td>
                                        <td><s:property value="ip_type"/></td>
                                        <td><s:property value="ip_use_status"/></td>
                                        <td><s:property value="pbx_extension"/></td>
                                        <td>
                                            <a href="updateIpData102.action?ip_no=<s:property value="ip_no"/>"> Edit </a>
                                        </td>
                                    </tr>
                                </s:iterator>
                            </tbody>
                        </table>
                    </div>
                    <div id="menu3" class="container-fluid tab-pane fade"><br>
                        <p class="v_lan">IP V-Lan 103</p>
                        <table id="myTable103" class="table table-striped table-bordered" style="width:100%">
                            <thead>
                                <tr>
                                    <th>SL</th>
                                    <th>I.P</th>
                                    <th>User Name</th>
                                    <th>Dept</th>
                                    <th>Type</th>
                                    <th>Status</th>
                                    <th>PBX Ext.</th>
                                    <th>Edit</th>
                                </tr>
                            </thead>

                            <tbody>
                                <s:iterator value="ipListVlan103">
                                    <tr>
                                        <td><s:property value="ip_sl_no"/></td>
                                        <td><s:property value="ip_no"/></td>
                                        <td><s:property value="ip_user_name"/></td>
                                        <td><s:property value="ip_user_dept"/></td>
                                        <td><s:property value="ip_type"/></td>
                                        <td><s:property value="ip_use_status"/></td>
                                        <td><s:property value="pbx_extension"/></td>
                                        <td>
                                            <a href="updateIpData103.action?ip_no=<s:property value="ip_no"/>"> Edit </a>
                                        </td>
                                    </tr>
                                </s:iterator>
                            </tbody>
                        </table>
                    </div>
                    <div id="menu4" class="container-fluid tab-pane fade"><br>
                        <p class="v_lan">IP V-Lan 104</p>
                        <table id="myTable104" class="table table-striped table-bordered" style="width:100%">
                            <thead>
                                <tr>
                                     <th>SL</th>
                                    <th>I.P</th>
                                    <th>User Name</th>
                                    <th>Dept</th>
                                    <th>Type</th>
                                    <th>Status</th>
                                    <th>PBX Ext.</th>
                                    <th>Edit</th>
                                </tr>
                            </thead>

                            <tbody>
                                <s:iterator value="ipListVlan104">
                                    <tr>
                                        <td><s:property value="ip_sl_no"/></td>
                                        <td><s:property value="ip_no"/></td>
                                        <td><s:property value="ip_user_name"/></td>
                                        <td><s:property value="ip_user_dept"/></td>
                                        <td><s:property value="ip_type"/></td>
                                        <td><s:property value="ip_use_status"/></td>
                                        <td><s:property value="pbx_extension"/></td>
                                        <td>
                                            <a href="updateIpData104.action?ip_no=<s:property value="ip_no"/>"> Edit </a>
                                        </td>
                                    </tr>
                                </s:iterator>
                            </tbody>
                        </table>
                    </div>
                    <div id="menu5" class="container-fluid tab-pane fade"><br>
                        <p class="v_lan">IP V-Lan 105</p>
                        <table id="myTable105" class="table table-striped table-bordered" style="width:100%">
                            <thead>
                                <tr>
                                    <th>SL</th>
                                    <th>I.P</th>
                                    <th>User Name</th>
                                    <th>Dept</th>
                                    <th>Type</th>
                                    <th>Status</th>
                                    <th>PBX Ext.</th>
                                    <th>Edit</th>
                                </tr>
                            </thead>

                            <tbody>
                                <s:iterator value="ipListVlan105">
                                    <tr>
                                        <td><s:property value="ip_sl_no"/></td>
                                        <td><s:property value="ip_no"/></td>
                                        <td><s:property value="ip_user_name"/></td>
                                        <td><s:property value="ip_user_dept"/></td>
                                        <td><s:property value="ip_type"/></td>
                                        <td><s:property value="ip_use_status"/></td>
                                        <td><s:property value="pbx_extension"/></td>
                                        <td>
                                            <a href="updateIpData105.action?ip_no=<s:property value="ip_no"/>"> Edit </a>
                                        </td>
                                    </tr>
                                </s:iterator>
                            </tbody>
                        </table>
                    </div>
                    <div id="menu6" class="container-fluid tab-pane fade"><br>
                        <p class="v_lan">IP V-Lan 106</p>
                        <table id="myTable106" class="table table-striped table-bordered" style="width:100%">
                            <thead>
                                <tr>
                                    <th>SL</th>
                                    <th>I.P</th>
                                    <th>User Name</th>
                                    <th>Dept</th>
                                    <th>Type</th>
                                    <th>Status</th>
                                    <th>PBX Ext.</th>
                                    <th>Edit</th>
                                </tr>
                            </thead>

                            <tbody>
                                <s:iterator value="ipListVlan106">
                                    <tr>
                                        <td><s:property value="ip_sl_no"/></td>
                                        <td><s:property value="ip_no"/></td>
                                        <td><s:property value="ip_user_name"/></td>
                                        <td><s:property value="ip_user_dept"/></td>
                                        <td><s:property value="ip_type"/></td>
                                        <td><s:property value="ip_use_status"/></td>
                                        <td><s:property value="pbx_extension"/></td>
                                        <td>
                                            <a href="updateIpData106.action?ip_no=<s:property value="ip_no"/>"> Edit </a>
                                        </td>
                                    </tr>
                                </s:iterator>
                            </tbody>
                        </table>
                    </div>
                    <div id="menu7" class="container-fluid tab-pane fade"><br>
                        <p class="v_lan">IP V-Lan 107</p>
                        <table id="myTable107" class="table table-striped table-bordered" style="width:100%">
                            <thead>
                                <tr>
                                   <th>SL</th>
                                    <th>I.P</th>
                                    <th>User Name</th>
                                    <th>Dept</th>
                                    <th>Type</th>
                                    <th>Status</th>
                                    <th>PBX Ext.</th>
                                    <th>Edit</th>
                                </tr>
                            </thead>

                            <tbody>
                                <s:iterator value="ipListVlan107">
                                    <tr>
                                        <td><s:property value="ip_sl_no"/></td>
                                        <td><s:property value="ip_no"/></td>
                                        <td><s:property value="ip_user_name"/></td>
                                        <td><s:property value="ip_user_dept"/></td>
                                        <td><s:property value="ip_type"/></td>
                                        <td><s:property value="ip_use_status"/></td>
                                        <td><s:property value="pbx_extension"/></td>
                                        <td>
                                            <a href="updateIpData107.action?ip_no=<s:property value="ip_no"/>"> Edit </a>
                                        </td>
                                    </tr>
                                </s:iterator>
                            </tbody>
                        </table>
                    </div>
                    <div id="menu8" class="container-fluid tab-pane fade"><br>
                        <p class="v_lan">IP V-Lan 108</p>
                        <table id="myTable108" class="table table-striped table-bordered" style="width:100%">
                            <thead>
                                <tr>
                                   <th>SL</th>
                                    <th>I.P</th>
                                    <th>User Name</th>
                                    <th>Dept</th>
                                    <th>Type</th>
                                    <th>Status</th>
                                    <th>PBX Ext.</th>
                                    <th>Edit</th>
                                </tr>
                            </thead>

                            <tbody>
                                <s:iterator value="ipListVlan108">
                                    <tr>
                                        <td><s:property value="ip_sl_no"/></td>
                                        <td><s:property value="ip_no"/></td>
                                        <td><s:property value="ip_user_name"/></td>
                                        <td><s:property value="ip_user_dept"/></td>
                                        <td><s:property value="ip_type"/></td>
                                        <td><s:property value="ip_use_status"/></td>
                                        <td><s:property value="pbx_extension"/></td>
                                        <td>
                                            <a href="updateIpData108.action?ip_no=<s:property value="ip_no"/>"> Edit </a>
                                        </td>
                                    </tr>
                                </s:iterator>
                            </tbody>
                        </table>
                    </div>
                    <div id="menu9" class="container-fluid tab-pane fade"><br>
                        <p class="v_lan">IP V-Lan 109</p>
                        <table id="myTable109" class="table table-striped table-bordered" style="width:100%">
                            <thead>
                                <tr>
                                    <th>SL</th>
                                    <th>I.P</th>
                                    <th>User Name</th>
                                    <th>Dept</th>
                                    <th>Type</th>
                                    <th>Status</th>
                                    <th>PBX Ext.</th>
                                    <th>Edit</th>
                                </tr>
                            </thead>

                            <tbody>
                                <s:iterator value="ipListVlan109">
                                    <tr>
                                        <td><s:property value="ip_sl_no"/></td>
                                        <td><s:property value="ip_no"/></td>
                                        <td><s:property value="ip_user_name"/></td>
                                        <td><s:property value="ip_user_dept"/></td>
                                        <td><s:property value="ip_type"/></td>
                                        <td><s:property value="ip_use_status"/></td>
                                        <td><s:property value="pbx_extension"/></td>
                                        <td>
                                            <a href="updateIpData109.action?ip_no=<s:property value="ip_no"/>"> Edit </a>
                                        </td>
                                    </tr>
                                </s:iterator>
                            </tbody>
                        </table>
                    </div>
                    
                    <div id="menu10" class="container-fluid tab-pane fade"><br>
                        <p class="v_lan">IP V-Lan 110</p>
                        <table id="myTable110" class="table table-striped table-bordered" style="width:100%">
                            <thead>
                                <tr>
                                    <th>SL</th>
                                    <th>I.P</th>
                                    <th>User Name</th>
                                    <th>Dept</th>
                                    <th>Type</th>
                                    <th>Status</th>
                                    <th>PBX Ext.</th>
                                    <th>Edit</th>
                                </tr>
                            </thead>

                            <tbody>
                                <s:iterator value="ipListVlan110">
                                    <tr>
                                        <td><s:property value="ip_sl_no"/></td>
                                        <td><s:property value="ip_no"/></td>
                                        <td><s:property value="ip_user_name"/></td>
                                        <td><s:property value="ip_user_dept"/></td>
                                        <td><s:property value="ip_type"/></td>
                                        <td><s:property value="ip_use_status"/></td>
                                        <td><s:property value="pbx_extension"/></td>
                                        <td>
                                            <a href="updateIpData110.action?ip_no=<s:property value="ip_no"/>"> Edit </a>
                                        </td>
                                    </tr>
                                </s:iterator>
                            </tbody>
                        </table>
                    </div>
                    
                    <div id="menu92" class="container-fluid tab-pane fade"><br>
                        <p class="v_lan">IP V-Lan 192</p>
                        <table id="myTable192" class="table table-striped table-bordered" style="width:100%">
                            <thead>
                                <tr>
                                    <th>SL</th>
                                    <th>I.P</th>
                                    <th>User Name</th>
                                    <th>Dept</th>
                                    <th>Type</th>
                                    <th>Status</th>
                                    <th>PBX Ext.</th>
                                    <th>Edit</th>
                                </tr>
                            </thead>

                            <tbody>
                                <s:iterator value="ipListVlan192">
                                    <tr>
                                        <td><s:property value="ip_sl_no"/></td>
                                        <td><s:property value="ip_no"/></td>
                                        <td><s:property value="ip_user_name"/></td>
                                        <td><s:property value="ip_user_dept"/></td>
                                        <td><s:property value="ip_type"/></td>
                                        <td><s:property value="ip_use_status"/></td>
                                        <td><s:property value="pbx_extension"/></td>
                                        <td>
                                            <a href="updateIpData192.action?ip_sl_no=<s:property value="ip_sl_no"/>"> Edit </a>
                                        </td>
                                    </tr>
                                </s:iterator>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <br/>
        <div style="color: #000;font-size: 15px; text-shadow: 0 1px 1px rgba(0, 0, 0, 0.75);opacity: 1;">
            <s:property value="message"/>
        </div>
        <br/>
        
        <script type="text/javascript" language="javascript" class="init">

           $(document).ready(function(){
                $('a[data-toggle="tab"]').on('show.bs.tab', function(e) {
                    localStorage.setItem('activeTab', $(e.target).attr('href'));
                });

                var activeTab = localStorage.getItem('activeTab');
                if(activeTab){
                    $('#myTab a[href="' + activeTab + '"]').tab('show');
                }
            });
            
            
            $(document).ready(function() {
            $('#myTable').DataTable({
                    "deferRender": true,
                    "order": [[0, "asc"]],
                    "paging": false
                    /*
                    "dom" : 'Bfrtip',
                    "buttons" : [
                        'excelHtml5',
                        'csvHtml5',
                        'pdfHtml5'
                    ],
                    rowCallback: function(row, data, index) {
                        if (data[5].toUpperCase() == "ACTIVE") {
                          $(row).find('td:eq(1)').css('color', '#cc0000');
                        }
                    } */
                });
            } );
            
            $(document).ready(function() {
                
            } );
            
           $(document).ready(function() {
                
            } ); 
            
            $(document).ready(function() {
                
            } );
           
           $(document).ready(function() {
                
            } );
            
            $(document).ready(function() {
                
            } );
            
            $(document).ready(function() {
                
            } );
            
            $(document).ready(function() {
                
            } );
            
            $(document).ready(function() {
                
            } );
            
            
            $(document).ready(function(){
                
                $('#myTable101').DataTable({
                    "deferRender": true,
                    "order": [[0, "asc"]],
                    "paging": false,
                    rowCallback: function(row, data, index) {
                        if (data[5].toUpperCase() == "ACTIVE") {
                          $(row).find('td:eq(1)').css('color', '#cc0000');
                        }
                    }
                });
                
                $('#myTable102').DataTable({
                    "deferRender": true,
                    "order": [[0, "asc"]],
                    "paging": false,
                    rowCallback: function(row, data, index) {
                        if (data[5].toUpperCase() == "ACTIVE") {
                          $(row).find('td:eq(1)').css('color', '#cc0000');
                        }
                    }
                });
                
                $('#myTable103').DataTable({
                    "deferRender": true,
                    "order": [[0, "asc"]],
                    "paging": false,
                    rowCallback: function(row, data, index) {
                        if (data[5].toUpperCase() == "ACTIVE") {
                          $(row).find('td:eq(1)').css('color', '#cc0000');
                        }
                    }
                });
                
                $('#myTable104').DataTable({
                    "deferRender": true,
                    "order": [[0, "asc"]],
                    "paging": false,
                    rowCallback: function(row, data, index) {
                        if (data[5].toUpperCase() == "ACTIVE") {
                          $(row).find('td:eq(1)').css('color', '#cc0000');
                        }
                    }
                });
                
                $('#myTable105').DataTable({
                    "deferRender": true,
                    "order": [[0, "asc"]],
                    "paging": false,
                    rowCallback: function(row, data, index) {
                        if (data[5].toUpperCase() == "ACTIVE") {
                          $(row).find('td:eq(1)').css('color', '#cc0000');
                        }
                    }
                });
                
                $('#myTable106').DataTable( {
                    "deferRender": true,
                    "order": [[0, "asc"]],
                    "paging": false,
                    rowCallback: function(row, data, index) {
                        if (data[5].toUpperCase() == "ACTIVE") {
                          $(row).find('td:eq(1)').css('color', '#cc0000');
                        }
                    }
                });
                
                $('#myTable107').DataTable({
                    "deferRender": true,
                    "order": [[0, "asc"]],
                    "paging": false,
                    rowCallback: function(row, data, index) {
                        if (data[5].toUpperCase() == "ACTIVE") {
                          $(row).find('td:eq(1)').css('color', '#cc0000');
                        }
                    }
                });
                
                $('#myTable108').DataTable( {
                    "deferRender": true,
                    "order": [[0, "asc"]],
                    "paging": false,
                    rowCallback: function(row, data, index) {
                        if (data[5].toUpperCase() == "ACTIVE") {
                          $(row).find('td:eq(1)').css('color', '#cc0000');
                        }
                    }
                });
                
                
                $('#myTable109').DataTable({
                    "deferRender": true,
                    "order": [[0, "asc"]],
                    "paging": false,
                    rowCallback: function(row, data, index) {
                        if (data[5].toUpperCase() == "ACTIVE") {
                          $(row).find('td:eq(1)').css('color', '#cc0000');
                        }
                    }
                });
                
                
                $('#myTable110').DataTable({
                    "deferRender": true,
                    "order": [[0, "asc"]],
                    "paging": false,
                    rowCallback: function(row, data, index) {
                        if (data[5].toUpperCase() == "ACTIVE") {
                          $(row).find('td:eq(1)').css('color', '#cc0000');
                        }
                    }
                });
                
                
                $('#myTable192').DataTable({
                    "deferRender": true,
                    "order": [[0, "asc"]],
                    "paging": false,
                    rowCallback: function(row, data, index) {
                        if (data[5].toUpperCase() == "ACTIVE") {
                          $(row).find('td:eq(1)').css('color', '#cc0000');
                        }
                    }
                });
                
            });
            

        </script>
    </body>
</body>
</html>
