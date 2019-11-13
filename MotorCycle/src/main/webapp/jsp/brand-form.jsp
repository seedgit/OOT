<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="/template/header.jsp"></s:include>
<h1>Brand Add</h1>
<div class="card">
    <div class="card-body">
        %{action}
        <s:property value="action"/>
        <s:form action="brandAdd" method="post">
            <s:textfield label="Name" name="name" class="form-control" value="%{brand.name}" />
            <s:submit key="submit" name="submit" class="btn btn-sm btn-primary float-right"/>
         </s:form>
    </div>
</div>
<s:include value="/template/footer.jsp"></s:include>