<%-- 
    Document   : demandDescription
    Created on : 23-Mar-2021, 12:32:40
    Author     : Hasan
--%>

<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="linkingScriptAndCss.jsp" %>
<!DOCTYPE html>
<html>
    <s:if test="%{#session.master == null && #session.admin == null && #session.entry == null}">
        <jsp:forward   page="index.jsp" />
    </s:if>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .main{
                margin-top: 20px;
                margin-bottom: 20px;
            }
        </style>
        <script>
            $(document).ready(function(){
                $('#myTable').DataTable({
                    "deferRender": true,
                    "paging": false,
                    "font-family": 'Capriola'                                       
                });
            });
        </script>
    </head>
    <body>
        <%@include file="mainMenu.jsp" %>

        <section>
            <div style="text-align: center;" class="form-title">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1>Demand Description!</h1>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        
        <section>
            <hr/>
            <br>
            <div class="container-fluid">
                <s:form name="" action="addDescription" theme="simple">
                    
                    <div class="row">
                        <div class="col-lg-2"></div>
                        <div class="col-lg-2"></div>
                        <div class="col-lg-1">
                            <p>Add Description: </p>
                        </div>
                        <div class="col-lg-3">
                            <s:hidden  value="%{d.sl}" name="d.sl" />
                            <s:textarea name="d.description" value="%{d.description}" cssClass="form-control" />
                        </div>
                        <div class="col-lg-1">
                             <s:submit cssClass="btn btn-primary" cssStyle="float:right;" value="Save"/>
                        </div>
                        <div class="col-lg-3">
                           
                        </div>
                    </div>
                    <br/>
                    <br/>
                    <div class="row">
                        <div class="col-lg-2"></div>
                        <div class="col-lg-2"></div>
                        <div class="col-lg-2"></div>
                        <div class="col-lg-2">
                            
                        </div>
                        <div class="col-lg-2"></div>
                        <div class="col-lg-2"></div>
                    </div>
                </s:form>
            </div>
        </section>
        
        <section>
            <div class="main">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <table id="myTable" class="table table-striped table-bordered">
                                <thead>
                                    <tr>
                                        <td>SL</td>
                                        <td>Description</td>
                                        <td>Edit</td>
                                    </tr>
                                </thead>

                                <tbody>
                                    <s:iterator value="descList" status="incr">
                                        <tr>
                                            <td>
                                                <s:property value="%{#incr.index+1}"/>
                                            </td>
                                            <td><s:property value="description"/></td>
                                            <td>
                                                <s:url id="getEditDemandData" action="getEditDemandData" >
                                                    <s:param name="sl" value="sl" />
                                                </s:url>
                                                <s:a href="%{getEditDemandData}" cssClass="btn btn-light">
                                                    Edit
                                                </s:a>
                                            </td>
                                        </tr>
                                    </s:iterator>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>        
    </body>
</html>

