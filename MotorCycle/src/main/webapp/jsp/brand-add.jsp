<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="/template/header.jsp"></s:include>
<h1>Brand Add</h1>
<div class="card">
    <div class="card-body">
        <s:form action = "hello" method = "post" enctype = "multipart/form-data">
            <s:textfield key = "email.from" name = "from" />
            <s:password key = "email.password" name = "password" />
            <s:textfield key = "email.to" name = "to" />
            <s:textfield key = "email.subject" name = "subject" />
            <s:textarea key = "email.body" name = "email.body" />
            <s:token />
            <s:submit key = "submit" />
         </s:form>
    </div>
</div>
<s:include value="/template/footer.jsp"></s:include>