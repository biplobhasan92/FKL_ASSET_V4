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
    <head>
        <title>Welcome</title>
        <sx:head/>
        <script>
            function report(){
		$.ajax({			
                    type:"GET",
                    url:"report.action",
                    success: function(result){
                            var tblData="";
                            $.each(result.beanList, function(){				
                                // tblData += "<tr><td>" + this.uname + "</td>" +
                                // here is data come from action class 
                                // and display it in log ...
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
        <h2>Struts 2 Autocomplete (Drop down) Example!</h2>
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <s:select size="1" list="demandDesc" label="Country" name="Country" cssClass="form-control">
                        <sx:submit value="save" />
                    </s:select>
                </div>
            </div>
        </div>
    </body>
</html>