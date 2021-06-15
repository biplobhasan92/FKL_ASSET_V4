<%-- 
    Document   : addAttachSucc
    Created on : 05-Dec-2020, 15:02:09
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
        <title>File Upload Success</title>
        <script type="text/javascript" language="javascript" class="init">
            $(document).ready(function(){
            $('#myTable').DataTable({
                    "deferRender": true,
                    "paging"     : false,
                    "font-family": 'Capriola'
                });
            });

            function checkVal(){
                confirm("Want to delete?");
            }
        </script>
    </head>

    <body>
        <%@include file="mainMenu.jsp" %>
        <div>
            You have successfully uploaded <s:property value = "myFileFileName"/>
        </div>
        <div style="margin-top: 40px; font-size: 30px; color: green;">
            <s:property value="msg" />
        </div>
        
        
        
        <div class="container-fluid" style="width:95% !important">            
            <table id="myTable" class="display" style="width:100%">
                <thead>
                    <tr style="background-color: #E0E0E1;">
                        <th>FKL TAG</th>
                        <th>NAME</th>
                        <th>Image</th>
                        <th>Action</th>
                    </tr>
                </thead>
                
                <tbody>
                    <s:iterator value="dataList">
                        <tr>
                            <td><i><s:property value="fkl_tag" /></i></td>
                            <td><i><s:property value="name" /></i></td>
                            <td><img width="100" height="100" src="<s:property value="image" />"></td>
                            <td>
                                <s:if test="%{#session.emp_id=='012032' || #session.emp_id=='012007'}">
                                    <s:url id="deletingAttachment" action="deletingAttachment" >
                                        <s:param name="id" value="id" />
                                    </s:url>
                                    <s:a href="%{deletingAttachment}" onclick="return confirm('Are you sure you want to delete?')" cssClass="btn btn-light" >
                                        Delete
                                    </s:a>
                                </s:if>
                            </td>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>
        </div>
   </body>
</html>


                                        
                                            
               
                                    
