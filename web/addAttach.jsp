<%-- 
    Document   : addAttach
    Created on : 04-Dec-2020, 18:13:07
    Author     : Hasan Mobarak<biplobjugp40@gmail.com>
    Version    : 4.0
    About      : to upload file related machine in database
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
            .form-div{
                margin-top: 60px;
            }
        </style>
    </head>
    
    <body>
        <%@include file="mainMenu.jsp" %>
        <div class='main'>
            <br>
            <br>
            <br>
            <div style="text-align: center;" class="form-title">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1>
                                Add Image Attachment Against FKL Tag
                            </h1>
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <hr/>            
            <div class="form-div">
                <s:form action="testUpload" enctype="multipart/form-data" theme="simple">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-3"></div>
                            <div class="col-lg-2">
                                <label for="fkl_tag">FKL Tag: <span style="color: red">*</span> </label>
                            </div>
                            <div class="col-lg-4">
                                <s:textfield name="fkl_tag" cssClass="form-control" maxlength="30" required="true" />
                            </div>
                            <div class="col-lg-3"></div>
                        </div>
                        
                        <br>
                        
                        <div class="row">
                            <div class="col-lg-3"></div>
                            <div class="col-lg-2">
                                <label for="name">Name :</label>
                            </div>
                            <div class="col-lg-4">
                                <s:textfield name="name" maxlength="20" cssClass="form-control" />
                            </div>
                            <div class="col-lg-3"></div>
                        </div>
                            
                        <br>
                        
                        <div class="row">
                            <div class="col-lg-3"></div>
                            <div class="col-lg-2">
                                Select Image: <span style="color: red">*</span>
                            </div>
                            <div class="col-lg-4">
                                <s:file name="image" cssClass="form-control" />
                            </div>
                            <div class="col-lg-3"></div>
                        </div>
                        
                        <br>
                        
                        <div class="row">
                            <div class="col-lg-3"></div>
                            <div class="col-lg-2">
                            </div>
                            <div class="col-lg-4">
                                <s:reset value="Reset" cssClass="btn btn-danger" />
                                <s:submit name="sumbit" value="Submit" cssClass="btn btn-primary" cssStyle="float:right;" />
                            </div>
                            <div class="col-lg-3">                                
                            </div>
                        </div>
                    </div>
                </s:form>
            </div>
        </div>
    </body>
</html>
