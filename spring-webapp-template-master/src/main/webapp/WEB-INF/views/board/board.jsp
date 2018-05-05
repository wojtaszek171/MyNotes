<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script>

</script>
<style>

</style>
<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Stwórz nową tablicę</h4>
            </div>
            <div class="modal-body">

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>

<div class="col-sm-12">
    <p>Hello board</p>
    <% if(request.getAttribute("error")!=null){
    %>
        <%=request.getAttribute("error")%>
    <%
    }%>
</div>

