<%-- 
    Document   : entry
    Created on : Mar 3, 2017, 10:49:16 AM
    Author     : ASUS
--%>
<%@include file="linkingScriptAndCss.jsp" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>

    <s:if test="%{#session.master == null && #session.admin == null}">
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

        <title>FKL ASSET V4 | Product Info</title>
        <s:head theme="ajax" debug="true"/>
    </head>
    <body>

        <%@include file="mainMenu.jsp" %>
        <div class='fix main'> <!--  main DIV is Start  -->   
                
            <div class="border"></div>
            <!--  #######################   mian menu  ##################################################################-->
                <center>
                    <div style="color:#9c2400;font-size: 15px; text-shadow: 0 1px 1px rgba(0, 0, 0, 0.75);opacity: 1; height: auto;">
                    <s:property value="message"/>
                </div>


                <div class='fix form'>
                    <div class="auth-form-header"> 
                        <legend align="center">Product Information</legend>
                    </div>
                    
                    <div class="auth-form-body">
                        <s:form action="updateProduct" theme="simple">
                            <table>
                                <col width="150">
                                <col width="180">
                                <col width="150">
                                <col width="180">
                                <col width="150">
                                <col width="180">
                                <tr>   

                                <tr>
                                    <td><s:label for="id" >Product ID:</s:label></td>
                                    <td><s:textfield name="pid" id="pid"  cssClass="userId"/></td>

                                    <td >
                                        <s:submit value="Search" action="searchProduct" cssClass="btn btn-primary btn-large">
                                            <s:param name="pid" value="pid" />
                                        </s:submit>
                                    </td>

                                    <div id="msuccess1" style="display: none;">  
                                        <div style="color: #9c2400;font-size: 15px; text-shadow: 0 1px 1px rgba(0, 0, 0, 0.75);opacity: 1; height: auto;">
                                            <s:property value="message2"/>
                                        </div>
                                    </div>
                                </tr>

                                <tr>
                                    <td>Memo No:</td>
                                    <td><s:textfield name="memo" id="memo" cssClass="userId"/></td>

                                    <td>Product Cost:</td>
                                    <td><s:textfield name="cost" id="cost" cssClass="userId"/></td>

                                    <td>Supplier:</td>
                                    <td><s:textfield name="supplier" id="supplier" cssClass="userId"/></td> 
                                </tr>

                                <tr>
                                    <td>Product Purchase Date:</td>
                                    <td style="min-height: 35px;padding: 7px 3px; background-position: right center;border: 1px solid #cccccc; -webkit-border-radius: 3px;-moz-border-radius: 3px;border-radius: 3px;box-shadow: inset 0 1px 2px inset 0 1px 1px rgba(0, 0, 0, 0.075);-moz-box-sizing: border-box; box-sizing: border-box;transition: all 0.15s ease-in;-webkit-transition: all 0.15s ease-in 0; vertical-align: middle;
                                        margin-top: 3px;margin-bottom: 3px; margin-left:  5px; height: 15px;  width: 150px;  display: inline-block;  font-size: 13px;   font-weight: normal;  
                                        line-height: 10px ;  ">
                                        <s:datetimepicker  name="buydate" id="buydate" displayFormat="yyyy-MM-dd"  />
                                    </td>

                                    <td>Supplier Warrenty (In Month No):</td>
                                    <td><s:textfield name="suplrwrnty" id="suplrwrnty" cssClass="userId"/></td>

                                    <td>Product Lifetime (In Month No):</td>
                                    <td><s:textfield name="prdtlife" id="prdtlife" cssClass="userId"/></td>
                                </tr>

                                <tr>

                                </tr>

                                <tr>

                                </tr>

                                <tr>

                                </tr>

                            </table>

                            <table>
                                <tr>
                                    <td align="center">
                                        <s:submit value="Update" onmouseover="/mbuy()" cssClass="btn btn-primary btn-large"/>
                                    </td>  
                                </tr>
                            </table>
                        </s:form>
                    </div>
                </div>
            </center>
        </div>
    </body>
</html>

