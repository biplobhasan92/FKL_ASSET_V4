<%-- 
    Document   : demandList
    Created on : 15-Mar-2021, 10:36:05
    Author     : Hasan Mobarak
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
        <title>FKL ASSET V4 | Demand List</title>
        <s:head theme="ajax" debug="true"/>
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
    </head>
    <body>
        <%@include file="mainMenu.jsp" %>
        <div class='main'> <!--  main DIV is Start  -->      
            <div style="text-align: center;" class="form-title">
                <div class="container-fluid">
                    <div class="row">                        
                        <div class="col-lg-12">
                            <img src='images/fakir-logo.png' style="height: 115px; width: 230px;margin-left: 28px;"/>
                            <p>KAYEMPUR, FATULLAH, NARAYANGANJ</p>
                            <h2><span style="border: 1px solid #000;font-weight: bold;padding: 5px;">Departmental Demand List</span></h2>
                        </div>            
                    </div>
                </div>
                <hr/>
                <div style="color:#802420">
                    <p id="message"></p>
                    <s:property value="message"/>
                </div>
                <br>                
            </div>
            <div class="container-fluid" style="width:95% !important">
                <table id="myTable" class="display" style="width:100%">
                    <thead>
                        <tr>
                            <th class="text-center">DDN</th>
                            <th class="text-center">Date</th>
                            <th class="text-center">Applicant</th>
                            <th class="text-center">Dept.</th>
                            <th class="text-center">Description</th>
                            <th class="text-center">Brand</th>
                            <th class="text-center">Model</th>
                            <th class="text-center">Weight(K.G)</th>
                            <th class="text-center">Pcs</th>
                            <th class="text-center">Parts No</th>
                            <th class="text-center">Location</th>
                            <th class="text-center">Status</th>
                            <th class="text-center">Remarks</th>                            
                            <th class="text-center">Edit</th>
                            <th class="text-center">Delete</th>
                        </tr>
                    </thead>

                    <tbody>
                        <s:iterator value="dList">
                                <s:hidden value="dmndID"/>
                                <s:hidden value="sl"/>
                            <tr>
                                <td><s:property value="ddn_no"/></td>
                                <td><s:property value="demandDate"/></td>
                                <td><s:property value="nameOfApplicant"/></td>
                                <td><s:property value="department"/></td>
                                <td><s:property value="description"/></td>
                                <td><s:property value="brand"/></td>
                                <td><s:property value="model"/></td>
                                <td><s:property value="weight"/></td>
                                <td><s:property value="pcs"/></td>
                                <td><s:property value="partsNo"/></td>
                                <td><s:property value="location"/></td>                               
                                <td><s:property value="status"/></td>
                                <td><s:property value="remarks"/></td>
                                <td>
                                    <s:url id="editDemandInput" action="editDemandInput">
                                        <s:param name="ddn_no" value="ddn_no" />
                                    </s:url>
                                    <s:a href="%{editDemandInput}" cssClass="btn btn-light">
                                        Edit
                                    </s:a>
                                </td>
                                <td>
                                    <s:url id="deleteDemandInput" action="deleteDemandInput" >
                                        <s:param name="sl" value="sl" />
                                        <s:param name="ddn_no" value="ddn_no" />
                                    </s:url>
                                    <s:a href="%{deleteDemandInput}" cssClass="btn btn-light" onclick="return confirm('Do you want to Delete this records? ')">
                                        Delete
                                    </s:a>
                                </td>
                            </tr>
                        </s:iterator>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
