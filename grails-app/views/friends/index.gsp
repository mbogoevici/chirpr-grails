<%--
  Created by IntelliJ IDEA.
  User: marius
  Date: 11-04-28
  Time: 3:59 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Chirps from my friends</title><meta name='layout' content='main'/></head>
<body>
<h1>Chirps from my friends</h1>
<sec:ifLoggedIn>
    <g:form controller="chirp" action="index">
        <g:textArea name="text" rows="5" cols="28"/>
        <g:submitButton name="submit" value="Send!"/>
    </g:form>
</sec:ifLoggedIn>
<div class="homePagePanel">
    <ul>
        <g:each in="${chirps}" var="chirp">
            <li>
                <span>
                    <blockquote>
                        ${chirp.text}
                    </blockquote>
                    Sent by
                </span>
                <span>

                    Sent by <g:createLink controller="root" action="index" params="author=${chirp.author.username}"/> on ${chirp.postedOn}
                </span>
            </li>
        </g:each>
    </ul>
</div>
</body>
</html>