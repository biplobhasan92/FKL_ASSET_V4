<%-- 
    Document   : viewP.jsp (view printer)
    Created on : Mar 3, 2017, 10:50:06 AM
    Update on  : 02.01.2021
    Author     : Hasan Mobarak
    Version    : 4.0
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
        <title>FKL ASSET V4 | View Printer and Device Assign to Dept</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/font-awesome-4.6.3/css/font-awesome.min.css">
        <script type="text/javascript" language="javascript" class="init">
                $(document).ready(function(){
                $('#myTable').DataTable({
                        "deferRender": true,
                        "paging"     : false,
                        "searching"  : false,
                        "font-family": 'Capriola'
                    });
                });
        </script>
        <style>
            .t_font>tbody>tr>td {
                font-size: 14px;
            }
            .t_font>thead>tr>th{
                padding: 10px;
            }            
            .liveSearch{width: 80%;}
            #myInput, #myInput1, #myInput2, #myInput3, #myInput4{
                background-position: 10px 10px; /* Position the search icon */
                background-repeat: no-repeat; /* Do not repeat the icon image */
                width: 10%;   /*Full-width */
                padding: 0px 20px;
                margin-bottom: 12px; /* Add some space below the input */
            }
            table{
                border-collapse: collapse;
                width: 90%;
            }
            th, td{
                padding: 1px;
                text-align: center;
                border-bottom: 1px solid #ddd;
                font-family: 'Capriola', cambria;
            }
            td{
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

        <script>
            function myFunction() {
                var input, filter, table, tr, td, i, rowCount=0;
                input = document.getElementById("myInput");
                filter = input.value.toUpperCase();
                table = document.getElementById("myTable");
                tr = table.getElementsByTagName("tr");
                for (i = 0; i < tr.length; i++) {
                    td = tr[i].getElementsByTagName("td")[2];
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


            function myFunction1() {
                var input, filter, table, tr, td, i, rowCount=0;
                input = document.getElementById("myInput1");
                filter = input.value.toUpperCase();
                table = document.getElementById("myTable");
                tr = table.getElementsByTagName("tr");
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


            function myFunction2() {
                var input, filter, table, tr, td, i, rowCount=0;
                input = document.getElementById("myInput2");
                filter = input.value.toUpperCase();
                table = document.getElementById("myTable");
                tr = table.getElementsByTagName("tr");
                for (i = 0; i < tr.length; i++){
                    td = tr[i].getElementsByTagName("td")[2];
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



            function myFunction3() {
                var input, filter, table, tr, td, i, rowCount=0;
                input = document.getElementById("myInput3");
                filter = input.value.toUpperCase();
                table = document.getElementById("myTable");
                tr = table.getElementsByTagName("tr");
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
            
            
            function myFunction4() {
                var input, filter, table, tr, td, i, rowCount=0;
                input = document.getElementById("myInput4");
                filter = input.value.toUpperCase();
                table = document.getElementById("myTable");
                tr = table.getElementsByTagName("tr");
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
        </script>
    </head>

    <body class="dt-example dt-example-bootstrap4">
        <%@include file="mainMenu.jsp" %>
        <div class='fix main'> <!--  main DIV is Start  -->
            <div class="border"></div>
                <br/>
                <center>
                    <h1 style="font-family: 'Capriola', cambria;">Printers & Others Records</h1>
                    <p>* Search Machine Record Assign to Departments</p>                    
                    <div class="liveSearch">
                        <input type="text" id="myInput1" onkeyup="myFunction1()" placeholder="Search Deptarments.." class="userId">
                        <input type="text" id="myInput2" onkeyup="myFunction2()" placeholder="Search Tag.." class="userId">
                        <input type="text" id="myInput3" onkeyup="myFunction3()" placeholder="Search IP.." class="userId">
                        <input type="text" id="myInput4" onkeyup="myFunction4()" placeholder="Search Type.." class="userId">
                    </div>
                    <br/>
                        <label>Search Result : <span id="search_result"> </span></label>
                    <br/>
                    <div class="container-fluid">
                        <section>
                            <s:if test="eBeans.size()>0">
                                <table id="myTable" class="t_font cell-border" style="width:100%">
                                    <thead>
                                        <tr>
                                            <th>No</th>
                                            <th>Dept.</th>
                                            <th>Tag No.</th>
                                            <th>IP</th>
                                            <th>M. ID</th>
                                            <th>Type</th>
                                            <th>Status</th>
                                            <th>Net.Sts</th>
                                            <th>Remarks</th>
                                            <th>Date</th>
                                            <th>DDN/REQ</th>
                                            <th>Edit</th>
                                            <th>Delete</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <s:iterator value="eBeans" status="eBeansStatus">
                                            <tr>
                                                <td><s:property value="#eBeansStatus.index+1"/></td>
                                                <td><s:property value="dept"/></td>
                                                <td><s:property value="fklid"/></td>
                                                <td><s:property value="ip"/></td>
                                                <td><s:property value="mid"/></td>
                                                <td><s:property value="mtype"/></td>
                                                <td><s:property value="pcstatus"/></td>
                                                <td><s:property value="nstatus"/></td>
                                                <td><s:property value="remarks"/></td>
                                                <td><s:property value="hdate"/></td>
                                                <td><s:property value="imgloc"/></td>
                                                <td>
                                                    <s:url id="updatePrinterData" action="updatePrinterData" >
                                                        <s:param name="pid" value="pid" />
                                                    </s:url> 
                                                    <s:a href="%{updatePrinterData}" cssStyle="color:#0056B3">
                                                       Edit
                                                    </s:a>
                                                </td>
                                                <td>
                                                    <s:url id="getDeletingPrntrData" action="getDeletingPrntrData" > 
                                                        <s:param name="pid" value="pid" />
                                                    </s:url>
                                                    <s:a href="%{getDeletingPrntrData}" cssStyle="color:#0056B3">
                                                       Delete
                                                    </s:a>
                                                </td>
                                            </tr>
                                        </s:iterator>
                                    </tbody>
                                </table>
                            </s:if>
                        </section>
                    </div>
                <br/>
                <div style="color: #000;font-size: 15px; text-shadow: 0 1px 1px rgba(0, 0, 0, 0.75);opacity: 1;">
                    <s:property value="message"/>
                </div>
                <br/>
            </center>
        </div>
    </body>
</html>