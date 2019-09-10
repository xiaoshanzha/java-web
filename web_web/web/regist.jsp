<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/9/8
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        span{
            color: red;
        }
    </style>

    <!-- 引入Jquery -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"> </script>

    <script type="text/javascript">
        //获取xhr对象
        function getxhr() {
            var xhr = new XMLHttpRequest();
            return xhr;    
        }
        
        function checkUsername() {
            //获取用户输入的用户名
            var username = document.getElementById("username").value;
            //发送异步请求进行校检
            var xhr = getxhr();

            //设置请求信息并发送请求
            xhr.open("get","checkUsername?username="+username,true);
            xhr.send();
            //监听readyState的状态
            xhr.onreadystatechange=function () {

                if(xhr.readyState==4) {
                    if (xhr.status == 200) {
                        //获取服务端响应回来的数据.
                        var msg = xhr.responseText;
                        //将信息显示到用户名输入框后面
                        document.getElementById("regist_span").innerHTML = msg;
                    }
                }
            }
        }


        <!--ajax发送-->
        $(function () { // 相当于 window.onload();加载完毕执行

            var  usernameFlag = false ;
            var  passwordFlag = false ;

            $("#username").blur(function(){
                var username = $("#username").val();
                //发送异步请求
                $.ajax({
                    url:"checkUsername",
                    type:"post",
                    data:"username=" + username,
                    success:function(data){  // 会将服务器返回的数据保存到data中
                        if(data == 0){
                            $("#regist_span").html("用户名可以使用");
                            usernameFlag =true;
                        }else{
                            $("#regist_span").html("用户名不可以使用");
                        }
                    }
                });
            });

            $("#repassword").blur(function () {
                var password = $("#password").val();
                var repassword = $("#repassword").val();

                if(password !=null && password !="" && password == repassword){
                    $("#pass_span").html("密码一致");
                    passwordFlag = true ;
                }else{
                    $("#pass_span").html("密码不一致");
                }

            });

            $("form").submit(function () {
                return usernameFlag && passwordFlag;
            });
        });
    </script>
</head>
<body>
<h1>欢迎注册</h1>
<form action="regist"  method="post" >

    <!--利用xhr发送异步请求进行判断-->
    <!-- 用户名称:<input type="text" id="username" name="username" onblur="checkUsername();" /><span id="regist_span">${regist_msg }</span> -->

    <!--使用jquery框架发送异步请求-->
    用户名称:<input type="text" id="username" name="username" /><span id="regist_span">${regist_msg }</span>
    <br/>

    用户密码:<input type="password" id="password" name="password"/>
    <br/>
    确认密码:<input type="password" id="repassword" name="repassword"/><span id="pass_span"></span>
    <br/>
    <input type="submit" value="注册"/>

</form>
</body>
</html>
