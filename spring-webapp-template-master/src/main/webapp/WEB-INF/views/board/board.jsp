<%@ page import="java.util.ArrayList" %>
<%@ page import="xxxxxx.yyyyyy.zzzzzz.domain.model.Card" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script>
    $(document).ready(function() {
        $("#showPalette").spectrum({
            showPaletteOnly: true,
            showPalette:true,
            palette: [
                ['green', 'rgb(255, 128, 0)', 'hsv 100 70 50','red'],
                ['yellow', 'black', 'blue', 'violet']
            ]
        });
        $("#showPalette").spectrum("set","rgb(0, 128, 0)");
    });

    function changeModal(id, name) {
        $("#deletehref").attr("onclick", "location.href='./board/delete_card?id="+id+"'");
        $("#deletename").text('Na pewno chcesz usunąć kartkę "'+name.toString()+'" ?');
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

</style>
<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Stwórz nową kartkę</h4>
            </div>
            <div class="modal-body">
                <form action="/board/new_card/" method="post">
                    <table>
                        <tr><td>Tytuł kartki:</td><td><input type="text" required name="cardTitle"></td></tr>
                        <tr><td>Kolor:</td><td><input id="showPalette" type="text" name="cardColor"></td></tr>
                        <input type="text" name="boardId" value="<%= request.getParameter("id") %>" style="visibility: hidden">
                        <%--<tr><td>Tło:</td><td><input type="text" name="name"></td></tr>--%>
                    </table>
                    <button type="submit" class="btn btn-default" name="createCard">Stwórz</button>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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
                <h4 class="modal-title">Usuń kartkę</h4>
            </div>
            <div class="modal-body">
                <h4 id="deletename">Na pewno chcesz usunąć kartkę?</h4>
                <button id="deletehref" class="btn btn-default" style="color: red" onclick="/main/delete?id=">Usuń</button>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal" >Zamknij</button>
            </div>
        </div>

    </div>
</div>

<div class="col-sm-12">
    <div id="addCard" style="background-color: lightgray; font-size: 20px; font-weight: bold; text-align: center; line-height: 30px; color: #5e5e5e" data-toggle="modal" class="btn btn-default" data-target="#myModal">Nowa kartka</div>
    <% if(request.getAttribute("error")!=null){
    %>
        <%=request.getAttribute("error")%>
    <%
    }%>

    <%
        ArrayList<Card> cards = (ArrayList<Card>) request.getAttribute("cards");
        for (Card card: cards) {
    %>
    <div id="card" style="background-color: <%=card.getColor()%>">
        <div class="dropdown_item" style="position: absolute; right: 10px; top: 10px;">
            <img data-toggle="dropdown" style="width: 20px; height: 20px;" src="../res/media/dotsMenu.png">
            <ul class="dropdown-menu">
                <li><a data-toggle="modal" data-target="#deleteModal" onclick="changeModal(<%=card.getId()%>,'<%=card.getTitle()%>')">Usuń</a></li>
            </ul>
        </div>
        <p><%=card.getTitle()%></p>
    </div>
    <%
        }
    %>
</div>

