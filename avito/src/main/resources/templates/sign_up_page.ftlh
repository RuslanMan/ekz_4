<#include "base.ftlh">
<@html "Регистрация">
    <form action="/signUp" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <input name="nick" type="text" placeholder="NICK">
        <input name="email" type="email" placeholder="EMAIL">
        <input name="password" type="password" placeholder="PASSWORD">
        <input type="submit" value="SIGN UP">
    </form>
</@>