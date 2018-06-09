<%@ page import="xxxxxx.yyyyyy.zzzzzz.domain.service.user.UserServiceImpl" %>
	<%@ page import="org.springframework.context.ApplicationContext" %>
	<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/projectName-env.xml");
		UserServiceImpl userService = (UserServiceImpl) context.getBean("userService");
        String username = userService.getCurrentUserName();
        Integer id = userService.getUserIdByName(username);
        %>
	<div id="header" class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/main">MyNotes</a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navmenu-left navbar-nav">
				<li><a href="/main">Home</a></li>
			</ul>
            <ul style="float: right" class="nav navbar-nav">
                <li><a href="/main?userId=<%=id%>"><%=username%></a></li>
				<li style="line-height: 50px"><a href="./logout"><img style="height: 30px" src="../res/media/logout.png"></a></li>
            </ul>
		</div>

		<!--/.nav-collapse -->
	</div>
</div>

