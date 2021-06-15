<%-- 
    Document   : viewAllMachineRpt.jsp
    Created on : 10-Sep-2020, 11:24:11
    Author     : Hasan Mobarak <biplobjugp40@gmail.com>
    About      : To Generate Department wise All Machine list.
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
        <title>List Of IT Asset</title>
        <link rel="stylesheet" type="text/css" href="css/font-awesome-4.6.3/css/font-awesome.min.css">
        <script type="text/javascript" language="javascript" class="init">                                                
                $(document).ready(function(){                                                            
                    $('#myTable').DataTable({
                        "deferRender": true,
                        "paging": false,
                        "font-family": 'Capriola',
                        "dom" : 'Bfrtip',
                        "buttons" : [
                            {
                                "extend": 'excelHtml5',
                                "exportOptions": {
                                    columns: ':visible'
                                }
                            },
                            {
                                "extend": 'pdfHtml5',
                                "orientation": 'landscape',
                                "customize" : function(doc) {
                                    doc.defaultStyle.fontSize = 9;
                                },
                                "exportOptions": {
                                    columns: ':visible'
                                }
                            },
                            {
                                "extend": 'print',
                                "exportOptions": {
                                    columns: ':visible'
                                }
                            },
                            'colvis'
                        ],
                        "columnDefs":[
                            {"className": "dt-left", "targets": "_all"}
                        ]
                    });
                });
        </script>
        
        <script>
            
            function test(){
                var getId = document.getElementById('emp_id').checked;
                if(getId){
                    document.getElementsByClassName('e_id').style.display = 'block';
                }
            }
            
            function serachByID() { // Search By ID
                // Declare variables
                var input, filter, table, tr, td, i, rowCount=0;
                input = document.getElementById("inputId");
                filter = input.value.toUpperCase();
                table = document.getElementById("myTable");
                tr = table.getElementsByTagName("tr");

                // Loop through all table rows, and hide those who don't match the search query
                for (i = 0; i < tr.length; i++) {
                    td = tr[i].getElementsByTagName("td")[0];
                    if (td) {
                        if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                            rowCount++;
                            tr[i].style.display = "";
                        } else {
                            tr[i].style.display = "none";
                        }
                    }
                }
                document.getElementById('search_result').innerHTML = rowCount;
            }

            function serachByName() { // Search By Name
                // Declare variables
                var input, filter, table, tr, td, i, rowCount=0;
                input = document.getElementById("inputName");
                filter = input.value.toUpperCase();
                table = document.getElementById("myTable");
                tr = table.getElementsByTagName("tr");

                // Loop through all table rows, and hide those who don't match the search query
                for (i = 0; i < tr.length; i++) {
                    td = tr[i].getElementsByTagName("td")[1];
                    if (td) {
                        if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                            rowCount++;
                            tr[i].style.display = "";
                        } else {
                            tr[i].style.display = "none";
                        }
                    }
                }
                document.getElementById('search_result').innerHTML = rowCount;
            }

            function serachByDepartment() {  // Search By Department
                // Declare variables
                var input, filter, table, tr, td, i, rowCount=0;
                input = document.getElementById("inputDept");
                filter = input.value.toUpperCase();
                table = document.getElementById("myTable");
                tr = table.getElementsByTagName("tr");
                // Loop through all table rows, and hide those who don't match the search query
                for (i = 0; i < tr.length; i++) {
                    td = tr[i].getElementsByTagName("td")[3];
                    if (td) {
                        if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                            rowCount++;
                            tr[i].style.display = "";
                        } else {
                            tr[i].style.display = "none";
                        }
                    }
                }
                document.getElementById('search_result').innerHTML = rowCount;
            }
                                 
            function serachByTag() {    // Search By Tag
                // Declare variables
                var input, filter, table, tr, td, i, rowCount=0;
                input = document.getElementById("inputTag");
                filter = input.value.toUpperCase();
                table = document.getElementById("myTable");
                tr = table.getElementsByTagName("tr");

                // Loop through all table rows, and hide those who don't match the search query
                for (i = 0; i < tr.length; i++) {
                    td = tr[i].getElementsByTagName("td")[4];
                    if (td) {
                        if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                            rowCount++;
                            tr[i].style.display = "";
                        } else {
                            tr[i].style.display = "none";
                        }
                    }
                }
                document.getElementById('search_result').innerHTML = rowCount;
            }

            function serachByIp() {
                // Declare variables
                var input, filter, table, tr, td, i, rowCount=0;
                input = document.getElementById("inputIp");
                filter = input.value.toUpperCase();
                table = document.getElementById("myTable");
                tr = table.getElementsByTagName("tr");

                // Loop through all table rows, and hide those who don't match the search query
                for (i = 0; i < tr.length; i++) {
                    td = tr[i].getElementsByTagName("td")[5];
                    if (td) {
                        if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                            rowCount++;
                            tr[i].style.display = "";
                        } else {
                            tr[i].style.display = "none";
                        }
                    }
                }
                document.getElementById('search_result').innerHTML = rowCount;
            }



            function serachByType(){
                var input, filter, table, tr, td, i, rowCount=0;
                input  = document.getElementById("inputType");
                filter = input.value.toUpperCase();
                table  = document.getElementById("myTable");
                tr = table.getElementsByTagName("tr");
                // Loop through all table rows, and hide those who don't match the search query
                for (i = 0; i < tr.length; i++){
                    td = tr[i].getElementsByTagName("td")[6];
                    if (td) {
                        if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                            rowCount++;
                            tr[i].style.display = "";
                        } else {
                            tr[i].style.display = "none";
                        }
                    }
                }
                document.getElementById('search_result').innerHTML = rowCount;
            }
            
            
            
           
        </script>

        <style>
            .t_font>tbody>tr>td {
                font-size: 14px;
            }  
            .t_font>thead>tr>th {
                padding: 10px;
            }
            .liveSearch{
                width: 80%;  
            }
            #myInput, #myInput1, #myInput2, #myInput3, #myInput4 {
                background-position: 10px 10px; 
                background-repeat: no-repeat;
                width: 10%;  
                padding: 0px 20px;
                margin-bottom: 12px; 
            }
            table {
                border-collapse: collapse;
                width: 90%;
            }
            th, td {
                padding: 1px;
                text-align: center;
                border-bottom: 1px solid #ddd;
                font-family: 'Capriola', cambria;
            }
            td {
                font-size: small;
            }
            th{
                padding: 1px;
                text-align: center;
                border-bottom: 2px solid #ddd;
                background-color: #BFB389;
            }
            tr:hover{background-color:#BFB389}
        </style>
    </head>

    <body>
        <%@include file="mainMenu.jsp" %>
        <div class='fix main'> <!--  main DIV is Start  -->   
                
            <div class="border"></div>
            <!--  ####################### mian menu ##################################################################-->
            <div>
                <center>
                    <h1 style="font-family: 'Capriola', cambria;">List Of All IT Asset</h1>
                    <p>* Search Machine Record Assign to Employee</p>                    
                    <br/>
                    <!--
                        <div class="liveSearch">
                            <input id="emp_id"  type="checkbox" checked>&nbsp;&nbsp;<label>ID</label>&nbsp;&nbsp;&nbsp;&nbsp;
                            <input id="emp_name" type="checkbox">&nbsp;&nbsp;<label>Name</label>&nbsp;&nbsp;&nbsp;&nbsp;
                            <input id="emp_dept" type="checkbox">&nbsp;&nbsp;<label>Dept</label>&nbsp;&nbsp;&nbsp;&nbsp;                        
                            <input id="emp_desig" type="checkbox">&nbsp;&nbsp;<label>Designation</label>&nbsp;&nbsp;&nbsp;&nbsp;
                            <input id="machine"   type="checkbox">&nbsp;&nbsp;<label>Machine</label>&nbsp;&nbsp;&nbsp;&nbsp;
                            <input id="mchn_ip"   type="checkbox">&nbsp;&nbsp;<label>I.P</label>&nbsp;&nbsp;&nbsp;&nbsp;
                            <input id="m_id"  type="checkbox">&nbsp;&nbsp;<label>M.ID</label>&nbsp;&nbsp;&nbsp;&nbsp;
                            <input id="hdd" type="checkbox">&nbsp;&nbsp;<label>HDD</label>&nbsp;&nbsp;&nbsp;&nbsp;
                            <input id="m_board" type="checkbox">&nbsp;&nbsp;<label>M.Board</label>&nbsp;&nbsp;&nbsp;&nbsp;
                            <input id="ram" type="checkbox">&nbsp;&nbsp;<label>RAM</label>&nbsp;&nbsp;&nbsp;&nbsp;
                            <input id="processor" type="checkbox">&nbsp;&nbsp;<label>Processor</label>&nbsp;&nbsp;&nbsp;&nbsp;
                            <input id="type" type="checkbox">&nbsp;&nbsp;<label>Type</label>&nbsp;&nbsp;&nbsp;&nbsp;
                            <input id="status" type="checkbox">&nbsp;&nbsp;<label>Status</label>&nbsp;&nbsp;&nbsp;&nbsp;
                            <input id="net_sts" type="checkbox">&nbsp;&nbsp;<label>Net.Sts</label>&nbsp;&nbsp;&nbsp;&nbsp;
                            <input id="pbx_ext" type="checkbox">&nbsp;&nbsp;<label>PBX Ext.</label>&nbsp;&nbsp;&nbsp;&nbsp;                        
                        </div>
                    -->
                    <br/>
                    
                    <!--
                    <div class="container-fluid">
                        <section>-->
                        <%--<s:if test="eBeans.size()>0">--%>
                        <div class="container-fluid" style="width:95% !important">
                            <table id="myTable" class="display" style="width:100%">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Name</th>
                                        <th>Desig.</th>
                                        <th>Dept.</th>
                                        <th>Machine.Tag</th>
                                        <th>IP</th>
                                        <th>Type</th>
                                        <th>Purchase</th>
                                        <th>HDD(GB)</th>
                                        <th>M.Board</th>
                                        <th>RAM(GB)</th>
                                        <th>Processor</th>
                                        <th>Status</th>
                                        <th>Net.Sts</th>
                                        <th>PBX&nbsp;Ext.</th>
                                    </tr>
                                </thead>
                                
                                <tbody>
                                    <s:iterator value="eBeans" status="eBeansStatus">
                                        <tr>
                                            <td><s:property value="id"/></td>
                                            <td><s:property value="name"/></td>
                                            <td><s:property value="designation"/></td>
                                            <td><s:property value="dept"/></td>
                                            <td><s:property value="fklid"/></td>
                                            <td><s:property value="ip"/></td>
                                            <td><s:property value="mtype"/></td>
                                            <td><s:property value="buydate"/></td>
                                            <td><s:property value="hdd"/></td>
                                            <td><s:property value="mboard"/></td>
                                            <td><s:property value="ram"/></td>                                          
                                            <td><s:property value="chip"/></td>
                                            <td><s:property value="pcstatus"/></td>
                                            <td><s:property value="nstatus"/></td>
                                            <td><s:property value="pvs_extension"/></td>                                   
                                        </tr>
                                    </s:iterator>
                                </tbody>
                            </table>
                        </div>
                        <%--</s:if>--%>
                        <!--
                    </section>
                </div> -->
                <br/>
                <div style="color: #000;font-size: 15px; text-shadow: 0 1px 1px rgba(0, 0, 0, 0.75);opacity: 1;">
                    <s:property value="message"/>
                </div>
                <br/>
                </center>
            </div>                
        </div>
    </body>
</body>
</html>
