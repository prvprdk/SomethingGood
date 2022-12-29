<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>

 <div class="form " style=" margin-top: 3px;">
<#if Session?? && Session.SPRING_SECURITY_LAST_EXCEPTION??>
       <div class= "alert alert-danger" role="aller" >
            ${Session.SPRING_SECURITY_LAST_EXCEPTION.message}
       </div>
</#if>
</div>
<@l.login "/login" false/>

</@c.page>