<#include "security.ftlh">
<#import "login.ftlh" as l>
<nav class="navbar navbar-expand-lg navbar-light "  style="background-color: #fff0f5;">
    <a class="navbar-brand"  href="/">SomeThingGood</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
         <#if user??>
            <li class="nav-item active">
                <a class="nav-link" href="/setgood">set</a>
            </li>

              <li class="nav-item active">
                            <a class="nav-link" href="/getgood">get</a>
                        </li>
              <li class="nav-item active">
                <a class="nav-link" href="/main/${currentUserId}">my good</a>
            </li>
             <#if isAdmin>
            <li class="nav-item">
                <a class="nav-link" href="/registration">Registration</a>
            </li>
              </#if>
            <#if isAdmin>
            <li class="nav-item">
                <a class="nav-link" href="/user">UserList</a>
            </li>
             </#if>
             </#if >
        </ul>
        <div class="navbar-text mx-3">${name}</div>
        <div>
       <#if isActive>
        <@l.logout />
         </#if>
    </div>
</nav>