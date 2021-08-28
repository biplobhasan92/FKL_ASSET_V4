<%-- 
    Document   : demandInput.jsp
    Created on : 15-Mar-2021, 09:28:41
    Author     : Hasan Mobarak
--%>



<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
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
        <title>FKL ASSET V4 | Demand Input</title>
        <s:head theme="ajax" debug="true"/>
        
        <script>
            
            function addMorePassengerRow(tableID) {

                var table = document.getElementById(tableID);
                var rowCount = table.rows.length;
                var row = table.insertRow(rowCount); // description.brand model weight pcs partsNo location remarks
                
                var cell0 = row.insertCell(0);   //to insert first column
                var snoCol = document.createElement("label");
                // snoCol.type = "text";
                snoCol.name="demand.demandDetail["+(rowCount-1)+"].sl";
                snoCol.innerHTML=rowCount;
                cell0.appendChild(snoCol);
                
                var cell1 = row.insertCell(1);   //to insert first column
                var desCol = document.createElement("textarea");
                desCol.rows="1";
                desCol.className ="form-control";
                desCol.name="demand.demandDetail["+(rowCount-1)+"].description";
                cell1.appendChild(desCol);
                
                var cell2   = row.insertCell(2); //to insert second column
                var brndCol = document.createElement("input");
                brndCol.type= "text";
                brndCol.className ="form-control";
                brndCol.name="demand.demandDetail["+(rowCount-1)+"].brand";
                cell2.appendChild(brndCol);
                
                
                var cell3  = row.insertCell(3); // to insert 3rd column
                var mdlCol = document.createElement("input");
                mdlCol.type= "text";
                mdlCol.className ="form-control";
                mdlCol.name="demand.demandDetail["+(rowCount-1)+"].model";
                cell3.appendChild(mdlCol);
                
                
                var cell4  = row.insertCell(4); // to insert 3rd column
                var mdlCol = document.createElement("input");
                mdlCol.type= "number";
                mdlCol.className ="form-control";
                mdlCol.name="demand.demandDetail["+(rowCount-1)+"].weight";
                cell4.appendChild(mdlCol);
                
                var cell5  = row.insertCell(5); // to insert 3rd column
                var pcsCol = document.createElement("input");
                pcsCol.type= "number";
                pcsCol.className ="form-control";
                pcsCol.name="demand.demandDetail["+(rowCount-1)+"].pcs";
                cell5.appendChild(pcsCol);
                    
                
                var cell6  = row.insertCell(6); // to insert 3rd column
                var partsCol = document.createElement("input");
                partsCol.type= "number";
                partsCol.className ="form-control";
                partsCol.name="demand.demandDetail["+(rowCount-1)+"].partsNo";
                cell6.appendChild(partsCol);
                
        
                var cell7  = row.insertCell(7);
                var locCol = document.createElement("input");
                locCol.type= "text";
                locCol.className ="form-control";
                locCol.name="demand.demandDetail["+(rowCount-1)+"].location";
                cell7.appendChild(locCol);
                
                var cell8  = row.insertCell(8);
                var remCol = document.createElement("input");
                remCol.type= "text";
                remCol.className ="form-control";
                remCol.name="demand.demandDetail["+(rowCount-1)+"].status";
                cell8.appendChild(remCol);
                
                
                var cell9  = row.insertCell(9);
                var remCol = document.createElement("input");
                remCol.type= "text";
                remCol.className ="form-control";
                remCol.name="demand.demandDetail["+(rowCount-1)+"].remarks";
                cell9.appendChild(remCol);
                
                return false;
            }  
            
            function removeRowFromTable(tbl_nm){
                var tbl = document.getElementById(tbl_nm);
                var lastRow = tbl.rows.length;
                if (lastRow > 2) tbl.deleteRow(lastRow - 1);
            }
            
        </script>
        
        <script>
            function isNumber(val, iid){
                if(isNaN(val)){
                    document.getElementById('message').innerHTML = ' Give Number ';
                }else{
                    document.getElementById('message').innerHTML = '';
                }
            }
        </script>
    </head>
    
    <body>
        <%@include file="mainMenu.jsp" %>
        <div class='main'> <!--  main DIV is Start  -->      
            <div style="text-align: center;" class="form-title">
                <br>
                <br>
                <h1> Edit Demand Note </h1>
                <hr/>
                <br>
                <div style="color:#802420">
                    <p id="message"></p>
                    <s:property value="message"/>
                </div>
                <br>
            </div>
            
            <div class="form-div">
                <s:form name="demandNote" action="editDemandNote" method="post" theme="simple">
                    <s:hidden name="rowindex"/>
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-2"> <!--readonly="true" -->
                                <label for="ddn_no">DDN No:<span style="color: red">*</span> </label>
                            </div>
                            <div class="col-lg-4">
                                <s:hidden  value="%{demand.ddn_no}" name="demand.ddn_no" />
                                <s:textfield cssClass="form-control" value="%{demand.ddn_no}" readonly="true" onkeypress="isNumber(this.value, this.id)" />
                            </div>
                            <div class="col-lg-2">
                                <label for="req_no">Date No:<span style="color: red">*</span> </label>
                            </div>
                            <div class="col-lg-4">
                                <s:textfield cssClass="form-control"  name="demand.demandDate" value="%{demand.demandDate}" />
                            </div>
                        </div>
                        <br/>
                        <div class="row">
                            <div class="col-lg-2">
                                <label for="name">Name Of Applicant:<span style="color: red">*</span> </label>
                            </div>
                            <div class="col-lg-4">
                                <s:textfield value="%{demand.nameOfApplicant}" cssClass="form-control" name="demand.nameOfApplicant" required="true" />
                            </div>
                            <div class="col-lg-2">
                                <label for="dept_sec">Department/Section:<span style="color: red">*</span></label>
                            </div>
                            <div class="col-lg-4">
                                <s:textfield value="%{demand.department}" cssClass="form-control" name="demand.department" required="true" />
                            </div>
                        </div>

                        <br>

                        <div class="row">
                            <div class="col-lg-2">
                                <label for="designation_with_id">
                                    Designation with ID:<span style="color: red">*</span>
                                </label>
                            </div>
                            <div class="col-lg-4">
                                <s:textfield value="%{demand.desigWithId}" cssClass="form-control" name="demand.desigWithId" required="true" />
                            </div>
                            <div class="col-lg-2">
                                <label for="demand_to">
                                    Demand Submitted to:<span style="color: red">*</span>
                                </label>
                            </div>
                            <div class="col-lg-4">
                                <s:textfield value="%{demand.submitedTo}" cssClass="form-control" name="demand.submitedTo" required="true" />
                            </div>
                        </div>
                    </div>
                    <br>
                    <div class="container-fluid dynamic-fields">
                        <div class="row clearfix">
                            <div class="col-md-12 column">
                                <table class="table table-bordered table-hover" id="tab_logic">
                                    <tr>
                                        <th class="text-center">#</th>
                                        <th class="text-center">Description</th>
                                        <th class="text-center">Brand</th>
                                        <th class="text-center">Model</th>
                                        <th class="text-center">Weight(K.G)</th>
                                        <th class="text-center">Pcs</th>
                                        <th class="text-center">Parts No</th>
                                        <th class="text-center">Location</th>
                                        <th class="text-center">Status</th>
                                        <th class="text-center">Remarks</th>
                                    </tr>                             

                                    <s:iterator value="dList" status="cnt" >
                                        <s:hidden name="demand.demandDetail[%{#cnt.count-1}].sl"  value="%{sl}" cssClass="form-control" />
                                        <tr>
                                            <td> </td>
                                            <td><s:textarea  rows="1" name="demand.demandDetail[%{#cnt.count-1}].description" value="%{description}" cssClass="form-control" /></td>
                                            <td><s:textfield name="demand.demandDetail[%{#cnt.count-1}].brand"  value="%{brand}" cssClass="form-control" /></td>
                                            <td><s:textfield name="demand.demandDetail[%{#cnt.count-1}].model"  value="%{model}"  cssClass="form-control" /></td>
                                            <td><s:textfield name="demand.demandDetail[%{#cnt.count-1}].weight" value="%{weight}" cssClass="form-control" /></td>
                                            <td><s:textfield name="demand.demandDetail[%{#cnt.count-1}].pcs" value="%{pcs}" cssClass="form-control" /></td>
                                            <td><s:textfield name="demand.demandDetail[%{#cnt.count-1}].partsNo" value="%{partsNo}" cssClass="form-control" /></td>
                                            <td><s:textfield name="demand.demandDetail[%{#cnt.count-1}].location" value="%{location}" cssClass="form-control" /></td>
                                            <td><s:textfield name="demand.demandDetail[%{#cnt.count-1}].status" value="%{status}" cssClass="form-control" /></td>
                                            <td><s:textfield name="demand.demandDetail[%{#cnt.count-1}].remarks" value="%{remarks}" cssClass="form-control" /></td>
                                        </tr>
                                    </s:iterator>
                                </table>
                            </div>
                        </div>
                        <a id="add_row" onclick="addMorePassengerRow('tab_logic')" class="btn btn-default pull-left">Add Row</a><a id='delete_row' onclick="removeRowFromTable('tab_logic')" class="pull-right btn btn-default">Delete Row</a>
                        <br>
                        <br>
                        <div class="row">
                            <div class="col-lg-2"></div>
                            <div class="col-lg-3"></div>
                            <div class="col-lg-2">
                                <s:reset value="Reset" cssClass="btn btn-danger" />
                            </div>
                            <div class="col-lg-2">
                                <s:submit value="Save Note" cssClass="btn btn-primary btn-large" />
                            </div>
                            <div class="col-lg-3"></div>
                        </div>
                    </div>
                </s:form>
            </div>
        </div>
    </body>
</html>
