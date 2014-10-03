<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html lang="en"> 
    <head>
        <meta charset="UTF-8" />
        <title><tiles:getAsString name="title"/></title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport" />
        <meta content="" name="description" />
        <meta content="" name="author" />
        <link rel="stylesheet" href='<c:url value="/resources/plugins/bootstrap/css/bootstrap.css"/>' />
        <link rel="stylesheet" href='<c:url value="/resources/css/login.css"/>' />
        <link rel="stylesheet" href='<c:url value="/resources/plugins/magic/magic.css"/>' />
        <script src='<c:url value="/resources/plugins/jquery-2.0.3.min.js"/>'></script>
        <script src='<c:url value="/resources/plugins/bootstrap/js/bootstrap.js"/>'></script>
        <script src='<c:url value="/resources/js/login.js"/>'></script>
        <script
	src='<c:url value="/resources/plugins/jquery.validate.min.js"/>'></script>

    </head>
    <body >
        <tiles:insertAttribute name="body"/>
    </body>
</html>
