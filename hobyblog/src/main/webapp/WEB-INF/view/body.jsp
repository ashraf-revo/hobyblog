<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<table id="todesply">
    <c:forEach items="${posts}" var="post">
        <tr>
            <td>
                <div class="col-lg-4">
                    <div class="panel panel-success">
                        <div class="panel-heading">
                            <img class="media-object img-thumbnail user-img"
                                 alt="${post.person.username}"
                                 src='<c:url value="/resources/img/pimage/${post.person.pimage}"/>' />
                        </div>
                        <div class="panel-body">
                            <p>
                                <c:out value="${post.txt}" />
                            </p>
                        </div>
                        <div class="panel-footer">
                            <input class="btn btn-success btn-xs btn-round btn-line"
                                   type="button" value="hibernate" />
                        </div>
                    </div>
                </div>
            </td>
        </tr>
    </c:forEach>
</table>


<div class="col-lg-12">
    <div class="modal fade" id="formModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="H2">Modal Form</h4>
                </div>
                <div class="modal-body">
                    <sf:form commandName="post" id="savepost" action="${pageContext.request.contextPath}/savepost" method="POST" role="form" class="form-horizontal">
                        <div class="form-group">
                            <label class="control-label">Texts Input</label>
                            <sf:textarea path="txt" class="form-control" rows="3"/>
                        </div>  
                        <div class="form-group">          
                            <label class="control-label">Tags Input   split with ,</label>
                            <sf:input  path="TxtTags" class="form-control" name="tags" value=""/>
                        </div>

                        <div class="modal-footer">
                            <input type="submit" id="btnsavepost" class="btn btn-danger" data-dismiss="modal" value="Save Post"/>
                        </div>
                    </sf:form>
                </div>

            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function () {
        var c = 5;
        $("#more").submit(function (e) {

            if (c !== -1)
                $.ajax({
                    url: "more/" + c,
                    type: 'GET',
                    success: function (post, textStatus, jqXHR) {
                        if (post.length > 0) {
                            c += 5;
                            $("#todesply").last().append(post);
                        }
                        else {
                            $("#checkmore").addClass("disabled");
                            c = -1;
                        }

                    }
                });
            e.preventDefault();
        });
        $("#btnsavepost").click(
                function (e) {
                    $.ajax({
                        url: "savepost",
                        data: $("#savepost").serialize(),
                        type: 'POST',
                        success: function (post, textStatus, jqXHR) {
                            $("#todesply").prepend(post);
                        }
                    });
                    e.preventDefault();
                }
        );
        $(window).scroll(function (e) {
            if ($(document).height() - 200 <= $(window).scrollTop() + $(window).height())
                if (c !== -1)
                    $.ajax({
                        url: "more/" + c,
                        type: 'GET',
                        success: function (post, textStatus, jqXHR) {
                            if (post.length > 0) {
                                c += 5;
                                $("#todesply").last().append(post);
                            }
                            else {
                                $("#checkmore").addClass("disabled");
                                c = -1;
                            }

                        }
                    });
            e.preventDefault();

        });
    });
</script>