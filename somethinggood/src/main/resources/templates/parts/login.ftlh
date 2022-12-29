<#macro login path isRegisterForm>


<form class="mx-auto" style="margin-top: 150px;  text-align: center;"   action="${path}" method="post">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label-lg"  for="exampleInputEmail1" > Username: </label>
        <div class="col-sm-3">
        <input class="form-control-lg ${(usernameError??)?string('is.invalid','')}"
         value="<#if user??> ${user.username} </#if>" type="text" name="username" placeholder="Enter username">
                     <#if usernameError??>
                               <div clas="invalid-feedback">
                                  ${usernameError}
                               </div>
                     </#if>
        </div>
    </div>


    <div class="form-group row">
        <label class="col-sm-2 col-form-label-lg" for="exampleInputPassword1"> Password: </label>
    <div class="col-sm-3    ">
        <input class="form-control-lg ${(passwordError??)?string('is.invalid','')}"
         type="password" name="password" placeholder="Enter Password">
                     <#if passwordError??>
                               <div clas="invalid-feedback">
                                  ${passwordError}
                               </div>
                     </#if>
        <input type="hidden" name = "_csrf" value="${_csrf.token}"/>
        <div>
     <#if isRegisterForm>
                        <div class="  mt-3">
                            <input class="form-control-lg ${(passwrod2Error??)?string('is.invalid','')}"
                             type="password" name="password2" placeholder="Repeat Password">
                                     <#if password2Error??>
                                               <div clas="invalid-feedback">
                                                  ${password2Error}
                                               </div>
                                     </#if>
                        <div>

     </#if>
        <button class="btn  btn-outline-dark   mt-3"  type="submit"> <#if isRegisterForm>Create<#else> Sign In</#if></button>
     </div >
     <div class=" mt-5" >
            <#if !isRegisterForm > <a   href ="/registration">add new User</a></#if>
     </div>
</form>

</#macro>


<#macro logout>
<form action="/logout" method="post">
    <input type="hidden" name = "_csrf" value="${_csrf.token}"/>
    <button class="btn"   type="submit">Sign Out</button>
</form>
</#macro>