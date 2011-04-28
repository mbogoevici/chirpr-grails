<%--
  Created by IntelliJ IDEA.
  User: marius
  Date: 11-04-28
  Time: 11:13 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name='layout' content='main'/>
</head>
<body>

<table>
    <g:each var="profile" in="${users}">
        <tr>
        <td>
            ${profile.user.username}
        </td>
        <td>
            <sec:ifLoggedIn>
                <g:if test="${profile.followedByMe}">
                    <g:form controller="unfollow" action="index">
                        <g:submitButton name="Unfollow" value="Unfollow!"/>
                        <g:hiddenField name="id" value="${profile.user.username}"/>
                    </g:form>
                </g:if>
                <g:else>
                    <g:form controller="follow" action="index">
                        <g:submitButton name="Follow" value="Follow!"/>
                        <g:hiddenField name="id" value="${profile.user.username}"/>
                    </g:form>
                </g:else>

            </sec:ifLoggedIn>

        </td>
        </tr>
    </g:each>
</table>
</body>
</html>