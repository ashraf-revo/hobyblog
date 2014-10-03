<%@ page language="java" contentType="text/html; charset=windows-1256"
         pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type"
              content="text/html; charset=windows-1256">
        <link rel="stylesheet"
              href='<c:url value="/resources/plugins/bootstrap/css/bootstrap.css"/>' />
        <link rel="stylesheet" href='<c:url value="/resources/css/main.css"/>' />
        <link rel="stylesheet" href='<c:url value="/resources/css/theme.css"/>' />
        <link rel="stylesheet"
              href='<c:url value="/resources/css/MoneAdmin.css"/>' />
        <link rel="stylesheet"
              href='<c:url value="/resources/plugins/Font-Awesome/css/font-awesome.css"/>' />
        <script src='<c:url value="/resources/plugins/jquery-2.0.3.min.js"/>'></script>

        <script
        src='<c:url value="/resources/plugins/modernizr-2.6.2-respond-1.1.0.min.js"/>'></script>
        <script
        src='<c:url value="/resources/plugins/jquery.validate.min.js"/>'></script>
      
                <script src='<c:url value="/resources/js/jquery.min.js"/>'></script>
 <script src='<c:url value="/resources/js/bootstrap.min.js"/>'></script>

 
        <link href='<c:url value="/resources/css/bootstrap-tag.css"/>' rel="stylesheet">
        <script src='<c:url value="/resources/js/bootstrap-tag.js"/>' ></script>
    <script>
        !function ($) {
            $(function() {
                window.prettyPrint && prettyPrint();
            });
        }(window.jQuery);
    </script>


        <title><tiles:getAsString name="title" /></title>
    </head>
    <body class="padTop53 ">

        <div id="wrap">
            <div id="top">
                <nav class="navbar navbar-inverse navbar-fixed-top "
                     style="padding-top: 10px;"> <a
                        data-original-title="Show/Hide Menu" data-placement="bottom"
                        data-tooltip="tooltip"
                        class="accordion-toggle btn btn-primary btn-sm visible-xs"
                        data-toggle="collapse" href="#menu" id="menu-toggle"> <i
                            class="icon-align-justify"></i>
                    </a> <header class="navbar-header"> <a href="index.html"
                                                           class="navbar-brand"> <img
                                src='<c:url value="/resources/img/logo.png"/>' />
                        </a> </header> <tiles:insertAttribute name="event" /> </nav>
            </div>
            <div id="left">
                <tiles:insertAttribute name="personal" />
                <tiles:insertAttribute name="menu" />
            </div>
            <div id="content">
                <div class="inner" style="min-height: 1200px;">
                    <div class="row">
                        <div class="col-lg-12">
                            <h2>Blank Page One</h2>
                        </div>
                    </div>
                    <hr />
                    <tiles:insertAttribute name="body" />
                </div>
            </div>
        </div>
        <div id="footer">

            <form id="more"><p>
                    <input type="submit" id="checkmore" class="btn btn-success btn-xs btn-flat" value="see more"/>
                </p>
            </form>            
        </div>

    </body>
</html>