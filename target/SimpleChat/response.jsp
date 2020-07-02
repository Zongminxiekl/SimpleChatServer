<%--
  Created by IntelliJ IDEA.
  User: Zongmin
  Date: 2020/6/16
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
    <script>
        //页面加载绑定单击事件
        $(function () {
            $("#btn").click(function () {
                //alert("btn");
                $.ajax({
                    url:"user/testAjax",
                    contentType: "application/json;charset=utf-8",
                    data: '{"username":"hehe","password":"123","age":18}',
                    dataType: "json",
                    type: "POST",
                    success: function (data) {
                        //data服务器端响应的json数据，进行解析
                        console.log(data);
                    }
                })
            });
        });
    </script>
</head>
<body>
    <button id="btn">发送ajax请求</button>
</body>
</html>
