<head>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js" integrity="sha256-VazP97ZCwtekAsvgPBSUwPFKdrwD3unUfSGVYrahUqU=" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
    <script src="https://code.jquery.com/color/jquery.color-2.1.2.min.js" integrity="sha256-H28SdxWrZ387Ldn0qogCzFiUDDxfPiNIyJX7BECQkDE=" crossorigin="anonymous"></script>
    <script src="http://code.jquery.com/jquery-migrate-3.0.0.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/spectrum/1.8.0/spectrum.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/spectrum/1.8.0/spectrum.min.css">
</head>
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

</script>
<div id="popup">
    <h2>Nowa tablica</h2>
    <form action="/main/new_board/" method="post">
        <table>
            <tr><td>Nazwa:</td><td><input type="text" required name="name"></td></tr>
            <tr><td>Kolor:</td><td><input id="showPalette" type="text" name="color"></td></tr>
            <%--<tr><td>Tło:</td><td><input type="text" name="name"></td></tr>--%>
        </table>
        <button type="submit" class="btn btn-default" name="createBoard">Stwórz</button>
    </form>
</div>
