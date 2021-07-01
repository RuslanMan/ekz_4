<#ftl encoding='UTF-8'>

<#macro html title>

    <!doctype html>
    <html lang="ru">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
    </head>
    <body>
    <div style="margin-bottom: 100px">
        <#if user??>
            <span style="margin-left: 70px"><a href="/profile">PROFILE</a></span>
            <span style="margin-left: 70px"><a href="/products">PRODUCTS</a></span>
            <span style="margin-left: 70px"><a href="/you_product">YOU PRODUCTS</a></span>
            <span style="margin-left: 70px"><a href="/add_products">ADD PRODUCT</a></span>
            <span style="margin-left: 70px"><a href="/logout">LOGOUT</a></span>
            <span style="margin-left: 70px"><a href="/balance">BALANSE ${user.balance}</a></span>
            <span style="margin-left: 70px"><a href="/basket">BASKET</a></span>
            <span style="margin-left: 70px"><a href="/index">CHAT</a></span>
        <#else>
            <span style="margin-left: 70px"><a href="/signIn">LOGIN</a></span>
            <span style="margin-left: 70px"><a href="/signUp">REGISTER</a></span>
        </#if>
    </div>
    <#nested>
    </body>
    </html>

</#macro>