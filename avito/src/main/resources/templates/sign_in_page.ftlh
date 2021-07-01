<#include "base.ftlh">
<@html "Авторизация">
<form action="/signIn" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input name="nick" type="text" placeholder="NICK">
    <input name="password" type="password" placeholder="PASSWORD">
    <label>
        <input type="checkbox" name="remember-me">Запомни меня
    </label>
    <input type="submit" value="SIGN IN">
</form>

    <form>
        </form>

</@>