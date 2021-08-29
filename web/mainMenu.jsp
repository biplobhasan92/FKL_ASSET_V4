    
<%-- 
    Document   : mainMenu
    Created on : 12-Mar-2019, 10:58:31
    Author     : Hasan
--%>

<%@taglib prefix="s" uri="/struts-tags" %>
<div class="area-mainmenu">
    <div class="container-fluid">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#"><img src='img.gif' /></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav collapse navbar-collapse justify-content-end">
                    <li class="nav-item active">
                        <s:url id="addM"        action="addM" ></s:url>
                        <s:url id="searchEntry" action="searchEntry" ></s:url>
                        <s:url id="showPerson"  action="showPerson" ></s:url>
                        <s:url id="showPrinter" action="showPrinter" ></s:url>
                        <s:url id="check_ip"    action="check_ip" ></s:url>
                        <s:url id="addAttach"   action="addAttach" ></s:url>
                        <s:url id="loadAttach"  action="loadAttach" ></s:url>
                        <s:url id="openReport"  action="openReport" ></s:url>
                        <s:url id="changePass"  action="changePass" ></s:url>
                        <s:url id="openHisReport" action="openHisReport"></s:url>
                        <s:url id="machineReport" action="machineReport"></s:url>
                        <s:url id="newEmp"      action="newEmp" ></s:url>
                        <s:url id="log_history" action="log_history" ></s:url>
                        <s:url id="gotoDemandInputForm" action="gotoDemandInputForm" ></s:url>
                        <%--
                            <s:url id="gotoDescription" action="gotoDescription" ></s:url> 
                        --%>
                        <s:url id="getAllDemand" action="getAllDemand" ></s:url>
                        <%--
                            <s:url id="testAction" action="testAction"></s:url> 
                        --%>
                        <s:url id="logout"      action="logout" ></s:url>
                        <s:a cssClass="nav-link" href="%{addM}">New Entry<span class="sr-only">(current)</span> </s:a>
                    </li>
                    <li class="nav-item">
                        <s:a cssClass="nav-link" href="%{searchEntry}">Search/Update</s:a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Record
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <s:a cssClass="nav-link dropdown-item" href="%{showPerson}">Machine</s:a>
                            <s:a cssClass="nav-link dropdown-item" href="%{showPrinter}">Printer&Others</s:a>
                            <s:a cssClass="nav-link dropdown-item" href="%{check_ip}">Check IP</s:a>
                            <s:a cssClass="nav-link dropdown-item" href="%{addAttach}">Add Attachment</s:a>
                            <s:a cssClass="nav-link dropdown-item" href="%{loadAttach}">Load Attachment</s:a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Report
                        </a>
                        <div class="dropdown-menu " aria-labelledby="navbarDropdownMenuLink">
                            <s:a cssClass="nav-link dropdown-item" href="%{openReport}">Report</s:a>
                            <s:a cssClass="nav-link dropdown-item" href="%{machineReport}">All IT Asset</s:a>
                            <s:a cssClass="nav-link dropdown-item" href="%{openHisReport}">History</s:a>
                            <s:if test="%{#session.emp_id=='012032' || #session.emp_id=='012007' || #session.emp_id=='012008' || #session.emp_id=='012022'}">
                                <s:a cssClass="nav-link dropdown-item" href="%{log_history}">Log History</s:a>
                            </s:if>
                        </div>
                    </li>
                    <li class="nav-item">
                        <s:a cssClass="nav-link" href="%{newEmp}">Add Employee</s:a>
                    </li>
                    
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Requisition
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <%--
                                <s:a cssClass="nav-link dropdown-item" href="%{gotoDescription}" > Add Description </s:a>
                            --%>
                            <s:a cssClass="nav-link dropdown-item" href="%{gotoDemandInputForm}" >Demand/Return Input</s:a>
                            <s:a cssClass="nav-link dropdown-item" href="%{getAllDemand}" >Demand/Return List</s:a>
                            <%--
                                <s:a cssClass="nav-link dropdown-item" href="%{testAction}" >Test</s:a> 
                            --%>
                        </div>
                    </li>
                    
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Logout
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <s:a cssClass="nav-link dropdown-item" href="%{changePass}">Change Pass</s:a>
                            <a class="dropdown-item" style="text-align: center" href="#">
                                <i>${sessionScope.aname}</i> &nbsp;<span><i class="fa fa-cog fa-spin" style="color: #009900 "></i></span>
                            </a>
                            <a class="dropdown-item" style="text-align: center" href="#">
                                <spam>${sessionScope.emp_id}</spam>
                            </a>
                            <s:a cssClass="nav-link LogOutMarkar" href="%{logout}"><i class="fa fa-power-off"></i></s:a>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
</div>