<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="/template/header.jsp"></s:include>
<h1>Brand List</h1>
<div class="card">
    <div class="card-body">
        <s:a class="btn btn-sm btn-primary float-right mb-2" action="brand"><i class="fas fa-plus"></i> Add</s:a>
        <s:property value="brands"/>
        
            
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                    <tr>
                        <th style="width:50px;">#ID</th>
                        <th>Brand Name</th>
                        <th style="width:100px;">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="brands" status="brand">
                    <tr>
                        <td><s:property value="id"/></td>
                        <td><s:property value="name"/></td>
                        <td></td>
                    </tr>
                    </s:iterator>
                </tbody>
            </table>
        </div>
    </div>
</div>
<s:include value="/template/footer.jsp"></s:include>