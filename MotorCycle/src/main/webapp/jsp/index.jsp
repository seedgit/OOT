<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="/template/header.jsp"></s:include>
<h1>Welcome to OOT MotorCycle System</h1>
<p>Your first task is to complete code for 
    <ol>
        <li><s:a action="brandList">Brand</s:a></li>
        <li><s:a action="engineTypeList">Engine Type</s:a></li>
        <li><s:a action="motorCycleTypeList">Motor Cyclte Type</s:a></li>
    </ol>
</p>
<s:include value="/template/footer.jsp"></s:include>