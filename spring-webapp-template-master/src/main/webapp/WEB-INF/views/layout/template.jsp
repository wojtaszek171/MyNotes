<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>    <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>    <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width,initial-scale=1"/>
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/vendor/bootstrap/dist/css/bootstrap.css" />
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/vendor/bootstrap/dist/css/bootstrap-theme.css" />
<style type="text/css">
body {
    padding-top: 60px;
    /* 60px to make the container go all the way to the bottom of the topbar */
}
.my-inline.form-inline input[type="text"],
.my-inline.form-inline input[type="password"] {
  width: 240px;
}
.my-horizontal.form-horizontal input[type="text"],
.my-horizontal.form-horizontal input[type="password"] {
  width: 360px;
}
html,
body {
    margin:0;
    padding:0;
    height:100%;
}
#container {
    min-height:100%;
    position:relative;
    /*height:100%;*/
}
#body {
    margin-top: 50px;
    padding-bottom:60px;   /* Height of the footer */
}
#footer {
    position:absolute;
    bottom:0;
    width:100%;
}
</style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js" integrity="sha256-VazP97ZCwtekAsvgPBSUwPFKdrwD3unUfSGVYrahUqU=" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
    <script src="https://code.jquery.com/color/jquery.color-2.1.2.min.js" integrity="sha256-H28SdxWrZ387Ldn0qogCzFiUDDxfPiNIyJX7BECQkDE=" crossorigin="anonymous"></script>
    <script src="http://code.jquery.com/jquery-migrate-3.0.0.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/spectrum/1.8.0/spectrum.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/spectrum/1.8.0/spectrum.min.css">
<script type="text/javascript">

    
</script>
<c:set var="titleKey">
    <tiles:insertAttribute name="title" ignore="true" />
</c:set>
<title><spring:message code="${titleKey}" text="MyNotes" /></title>
<%--<tiles:insertAttribute title="header" />--%>
</head>
<body>
    <div id="container" class="container">
        <tiles:insertAttribute name="header" />
        <div id="body"><tiles:insertAttribute name="body" /></div>
        <tiles:insertAttribute name="footer" />
    </div>
</body>
</html>