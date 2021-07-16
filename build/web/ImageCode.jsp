<s:iterator value="dataList"> 
    <tr>
        <td> <s:property value="fkl_tag"/> </td>    
        <td> <s:property value="name"/> </td>
        <td>                         
            <img width="150" height="150" src="<s:url value='loadAttach.action?id='/><s:property value='id' />" />               
        </td>
        <td>
            <s:a href="#" cssStyle="color:#0056B3">
               Delete
            </s:a>
        </td>
    </tr>
</s:iterator>