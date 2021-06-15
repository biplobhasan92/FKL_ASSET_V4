<%-- 
    Document   : demandInput2
    Created on : 16-Mar-2021, 09:30:09
    Author     : Hasan
--%>

<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="linkingScriptAndCss.jsp" %>
<sx:head/>

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
        <%--<s:head theme="ajax" debug="true"/>--%>
        
        <script>            
            function addMorePassengerRow(tableID){
                var table = document.getElementById(tableID);
                var rowCount = table.rows.length;
                var row = table.insertRow(rowCount); // description.brand model weight pcs partsNo location remarks
                
                var cell0 = row.insertCell(0);   //to insert first column
                var snoCol = document.createElement("label");
                // snoCol.type = "text";
                snoCol.name="demand.demandDetail["+(rowCount-1)+"].sl";
                snoCol.innerHTML=rowCount;
                cell0.appendChild(snoCol);
                
                var cell1 = row.insertCell(1);   //to DESCRIPTION .... 
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
                remCol.name="demand.demandDetail["+(rowCount-1)+"].remarks";
                cell8.appendChild(remCol);
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
            
            
            
            function report(){
		$.ajax({	
                    type:"GET",
                    url:"report.action",
                    success: function(result){
                        var tblData="";
                        $.each(result.demandDesc, function() {					
                                tblData += "<tr><td>" + this.uname + "</td>" + 
                                "<td>" + this.uemail + "</td>" + 
                                "<td>" + this.upass + "</td>" + 
                                "<td>" + this.udeg + "</td>" +
                                "<td>"+
                                "<button onclick='fetchOldRecord(this);' class='btn btn-sm btn-info' data-toggle='modal' data-target='#updateModal'>Update</button>"+
                                "<button onclick='deleteUser(this);' class='btn btn-sm btn-danger'>Delete</button>"+
                                "</td></tr>" ;
                        });
                        $("#tbody").html(tblData);
                    },
                    error: function(result){
                        alert("Some error occured.");
                    }
		});
            }
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
                            <h2>
                                <span style="border: 1px solid #000;font-weight: bold;padding: 5px;">
                                    Departmental Demand List
                                </span>
                            </h2>
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
            
            <div class="form-div">
                <s:form name="demandNote" action="saveDemandNote" method="post" theme="simple">
                    <s:hidden name="rowindex"/>
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-2">
                                <label for="ddn_no">DDN No:<span style="color: red">*</span> </label>
                            </div>
                            <div class="col-lg-4">
                                <s:textfield cssClass="form-control" name="demand.ddn_no" onkeypress="isNumber(this.value, this.id)" />
                            </div>
                            <div class="col-lg-2">
                                <label for="req_no">Date No:<span style="color: red">*</span> </label>
                            </div>
                            <div class="col-lg-4">
                                <s:datetimepicker cssClass="form-control"  name="demand.demandDate" displayFormat="dd-MM-yyyy" />
                            </div>
                        </div>
                           
                        <br/>
                        <div class="row">
                            <div class="col-lg-2">
                                <label for="name">Name Of Applicant:<span style="color: red">*</span> </label>
                            </div>
                            <div class="col-lg-4">
                                <s:textfield value="%{#session.emp_full_name}" cssClass="form-control" name="demand.nameOfApplicant" required="true" />
                            </div>
                            <div class="col-lg-2">
                                <label for="dept_sec">Department/Section:<span style="color: red">*</span></label>
                            </div>
                            <div class="col-lg-4">
                                <s:textfield value="%{#session.dept}" cssClass="form-control" name="demand.department" required="true" />
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
                                <s:textfield value="%{#session.designation} (%{#session.emp_id})" cssClass="form-control" name="demand.desigWithId" required="true" />
                            </div>
                            <div class="col-lg-2">
                                <label for="demand_to">
                                    Demand Submitted to:<span style="color: red">*</span>
                                </label>
                            </div>
                            <div class="col-lg-4">
                                <s:select list="{'Accessories Store', 'Spare Parts'}" name="demand.submitedTo" required="true" id="mtype" headerValue=" --Select Type-- " cssClass="form-control">
                                    
                                </s:select>
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
                                        <th class="text-center">Weight(KG)</th>
                                        <th class="text-center">Pcs</th>
                                        <th class="text-center">Parts No</th>
                                        <th class="text-center">Location</th>
                                        <th class="text-center">Remarks</th>
                                    </tr>
                                    
                                    <s:iterator value="demand.demandDetail" status="cnt" >
                                        <tr>
                                            <td>
                                              <%--  <s:textarea  rows="1" name="demand.demandDetail[%{#cnt.count-1}].description" /> --%>
                                              <s:select cssClass="form-control" list="demandDesc" name="demand.demandDetail[%{#cnt.count-1}].description">                                                  
                                              </s:select>
                                            </td>
                                            <td> <s:textfield name="demand.demandDetail[%{#cnt.count-1}].brand" /> </td>
                                            <td> <s:textfield name="demand.demandDetail[%{#cnt.count-1}].model" /> </td>
                                            <td> <s:textfield name="demand.demandDetail[%{#cnt.count-1}].weight" /></td>
                                            <td> <s:textfield name="demand.demandDetail[%{#cnt.count-1}].pcs" /> </td>
                                            <td> <s:textfield name="demand.demandDetail[%{#cnt.count-1}].partsNo" /></td>
                                            <td> <s:textfield name="demand.demandDetail[%{#cnt.count-1}].location" /></td>
                                            <td> <s:textfield name="demand.demandDetail[%{#cnt.count-1}].remarks" /></td>
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
