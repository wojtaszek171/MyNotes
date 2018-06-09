<%@ page import="java.util.List" %>
<%@ page import="xxxxxx.yyyyyy.zzzzzz.domain.model.Board" %><%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 28.03.2018
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<script>
    $(".navmenu-left li").first().addClass("active");
    function changeModal(id, name) {
        $("#deletehref").attr("onclick", "location.href='./main/delete?id="+id+"'");
        $("#deletename").text('Na pewno chcesz usunąć tablicę "'+name.toString()+'" ?');
    }
    function changeEditModal(id, name) {
        $("#edithref").attr("href", "/main/edit?id="+id);
        $("#editname").val(name.toString());
    }
    function submitEdit(name) {
        $('#edithref').attr("onclick", location.href=$('#edithref').attr("href")+"&name="+name);
    }

function amIclicked(e, element)
    {
        e = e || event;
        var target = e.target || e.srcElement;
        if(target.id==element.id)
            return true;
        else
            return false;
    }
</script>
<style>
    #board{
        min-width: 200px;
        max-width: 300px;
        min-height: 130px;
        cursor: pointer;
        float: left;
        border-radius: 11px;
        margin: 20px;
        padding: 20px;
        color: white;
        font-size: 20px;
        font-weight: bold;
        position: relative;
    }
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
                <%@include file="popup/newboard.jsp" %>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Zamknij</button>
            </div>
        </div>

    </div>
</div>
<div id="deleteModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Usuń tablicę</h4>
            </div>
            <div class="modal-body">
                <h4 id="deletename">Na pewno chcesz usunąć tablicę?</h4>
                <button id="deletehref" class="btn btn-default" style="color: red" onclick="/main/delete?id=">Usuń</button>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal" >Zamknij</button>
            </div>
        </div>

    </div>
</div>

<div id="editModal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Zmień nazwę tablicy</h4>
            </div>
            <div class="modal-body">
                <input type="text" id="editname"/>
                <button id="edithref" class="btn btn-default" style="color: red" onclick="submitEdit($('#editname').val())">Zmień</button>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal" >Zamknij</button>
            </div>
        </div>

    </div>
</div>

<div class="col-sm-12">
    <div id="boards">
        <%
            List<Board> boards = (List<Board>) request.getAttribute("boards");
            for (Board board: boards) {
        %>
        <div id="board" style="background-color: <%=board.getColor()%>" onclick="if(amIclicked(event,this)){location.href='./board?id=<%=board.getId()%>'}">
            <div class="dropdown_item" style="position: absolute; right: 10px; top: 10px;">
                <img data-toggle="dropdown" style="width: 20px; height: 20px;" src="../res/media/dotsMenu.png">
                <ul class="dropdown-menu">
                    <li><a data-toggle="modal" data-target="#editModal" onclick="changeEditModal(<%=board.getId()%>,'<%=board.getName()%>')">Edytuj</a></li>
                    <li><a data-toggle="modal" data-target="#deleteModal" onclick="changeModal(<%=board.getId()%>,'<%=board.getName()%>')">Usuń</a></li>
                </ul>
            </div>
            <p onclick="if(amIclicked(event,this)){location.href='./board?id=<%=board.getId()%>'}"><%=board.getName()%></p>
        </div>
        <%
            }
        %>
        <div id="board" style="background-color: lightgray; font-size: 30px; font-weight: bold; text-align: center; line-height: 88px; color: #5e5e5e" data-toggle="modal" class="btn btn-default" data-target="#myModal">+</div>
    </div>
</div>

