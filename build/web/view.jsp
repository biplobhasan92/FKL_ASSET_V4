<%-- 
    Document   : view
    Created on : Mar 3, 2017, 10:50:06 AM
    Author     : Ahsan, Hasan Mobarak
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FKL ASSET V4 | Records Assign To Individuals</title>
        <link rel="stylesheet" type="text/css" href="css/font-awesome-4.6.3/css/font-awesome.min.css">


        <style>
            .t_font>tbody>tr>td{
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
            function serachByID(){
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
            
            
            
            

            function serachByName(){
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



            function serachByDepartment(){
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
            
            
            


            function serachByTag(){
                var input, filter, table, tr, td, i, rowCount=0;
                input = document.getElementById("inputTag");
                filter = input.value.toUpperCase();
                table = document.getElementById("myTable");
                tr = table.getElementsByTagName("tr");
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
            
            


            function serachByIp(){
                var input, filter, table, tr, td, i, rowCount=0;
                input = document.getElementById("inputIp");
                filter = input.value.toUpperCase();
                table = document.getElementById("myTable");
                tr = table.getElementsByTagName("tr");
                for (i = 0; i < tr.length; i++){
                    td = tr[i].getElementsByTagName("td")[5];
                    if (td){
                        if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                            rowCount++;
                            tr[i].style.display = "";
                        }else{
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
                for (i = 0; i < tr.length; i++){
                    td = tr[i].getElementsByTagName("td")[11];
                    if (td) {
                        if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                            rowCount++;
                            tr[i].style.display = "";
                        }else{
                            tr[i].style.display = "none";
                        }
                    }
                }
                document.getElementById('search_result').innerHTML = rowCount;
            }





            function serachByExtension(){
                var input, filter, table, tr, td, i, rowCount=0;
                input = document.getElementById("inputExt");
                filter = input.value.toUpperCase();
                table = document.getElementById("myTable");
                tr = table.getElementsByTagName("tr");
                // Loop through all table rows, and hide those who don't match the search query
                for (i = 0; i < tr.length; i++){
                    td = tr[i].getElementsByTagName("td")[14];
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
        <script type="text/javascript" language="javascript" class="init">
            $(document).ready(function(){
                $('#myTable').DataTable({
                    "deferRender": true,
                    "paging"     : false,
                    "searching"  : false,
                    "font-family": 'Capriola',
                    "columnDefs" : {
                        {
                            "width"   : "5%",
                            "targets" : [0,1,2,3,4,5,6,7,8,9]
                        },
                        {
                            "width"   : "5%",
                            "targets" : [12,13,14,15,16,17]
                        }
                    }
                });
            });
        </script>
    </head>

    <body>
        <%@include file="mainMenu.jsp" %>
        <div class='fix main'> <!--  main DIV is Start  -->                   
            <div class="border"></div>
            <center>
                <h1 style="font-family: 'Capriola', cambria;">Employee Records</h1>
                <p>* Search Machine Record Assign to Employee</p>                    
                <br/>
                <div class="liveSearch">
                    <input type="text" id="inputId"   onkeyup="serachByID()"         placeholder="Search By ID.."   class="userId">
                    <input type="text" id="inputName" onkeyup="serachByName()"       placeholder="Search By Name.." class="userId">
                    <input type="text" id="inputDept" onkeyup="serachByDepartment()" placeholder="Search By Dept.." class="userId">
                    <input type="text" id="inputTag"  onkeyup="serachByTag()"        placeholder="Search By Tag.."  class="userId">
                    <input type="text" id="inputIp"   onkeyup="serachByIp()"         placeholder="Search By IP.."   class="userId">
                    <input type="text" id="inputType" onkeyup="serachByType()"       placeholder="Search By Type.." class="userId">
                    <input type="text" id="inputExt"  onkeyup="serachByExtension()"  placeholder="By Extention"     class="userId">
                </div> 
                <br/>
                <label>Search Result : <span id="search_result"> </span></label>
                <br/>                                        
                <section>
                    <s:if test="eBeans.size()>0">
                        <table id="myTable" class="t_font cell-border" style="width:100%">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Desig.</th>
                                    <th>Dept.</th>
                                    <th>Machine.Tag</th>
                                    <th>IP</th>
                                    <th>M.ID</th>
                                    <th>HDD(GB)</th>
                                    <th>M.Board</th>
                                    <th>RAM(GB)</th>
                                    <th>Processor</th>
                                    <th>Type</th>
                                    <th>Monitor</th>
                                    <th>Status</th>
                                    <th>Net.Sts</th>
                                    <th>PBX&nbsp;Ext.</th>
                                    <th>Edit</th>
                                    <th>Delete</th>
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
                                        <td><s:property value="mid"/></td>
                                        <td><s:property value="hdd"/></td>
                                        <td><s:property value="mboard"/></td>
                                        <td><s:property value="ram"/></td>
                                        <td><s:property value="chip"/></td>
                                        <td><s:property value="mtype"/></td>
                                        <td><s:property value="monitor_desc"/></td>
                                        <td><s:property value="pcstatus"/></td>
                                        <td><s:property value="nstatus"/></td>
                                        <td><s:property value="pvs_extension"/></td>
                                        <%--<td><s:property value="imgloc"/></td>--%>
                                        <td>                                                
                                            <s:url id="updateData" action="updateData" >
                                                <s:param name="pid" value="pid" />
                                                <s:param name="pvs_extension" value="pvs_extension" />
                                            </s:url>
                                            <s:a href="%{updateData}" cssStyle="color:#0056B3">
                                                Edit
                                            </s:a>
                                        </td>
                                        <td>                                                
                                            <s:url id="getDeletingData" action="getDeletingData" >
                                                <s:param name="pid" value="pid" />
                                            </s:url>
                                            <s:a href="%{getDeletingData}" cssStyle="color:#0056B3">
                                                Delete
                                            </s:a>
                                        </td>
                                    </tr>
                                </s:iterator>
                            </tbody>
                        </table>
                    </s:if>
                </section>
                <br/>
                <div style="color: #000;font-size: 15px; text-shadow: 0 1px 1px rgba(0, 0, 0, 0.75);opacity: 1;">
                    <s:property value="message"/>
                </div>
                <br/>
            </center>
        </div>
    </body>
</body>
</html>