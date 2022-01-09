<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .background {
            margin: auto;
            width: 400px;
            height: 550px;
            border: 3px solid #73AD21;
            background: lightgoldenrodyellow;
            border-radius: 10px;
        }
        input[type=text],input[type=password] {
            border: 1px solid black;
            padding: 10px 10px;
            border-radius: 3px;
            width: 100%;
        }
        input:focus {
            background-color: lightblue;
        }
        body {
            background-color: lightblue;
            margin-bottom: 50px;
        }
        .form123 {
            padding: 20px 10px 0px 60px;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="background" style="margin-top: 10px">
    <h2 style="text-align: center">学生个人信息修改</h2>
    <p id="errorMsg" style="color:#ff0000;text-align: center;padding-top: 0px;padding-bottom: 0px"></p>
    <form id="changeForm" action="editServlet" class="form123">
        <input type="hidden" name="action" value="change">
        <table>
            <tr>
                <td>
                    <label for="stu_id">学号</label>
                </td>
                <td>
                    <input type="text" id="stu_id" name="stu_id" value="<%=request.getSession().getAttribute("id")%>" readonly>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="password">密码</label>
                </td>
                <td>
                    <input type="text" id="password" name="password" placeholder="请输入新的密码">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="name">姓名</label>
                </td>
                <td>
                    <input type="text" id="name" name="name" placeholder="请输入姓名">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="sex">性别</label>
                </td>
                <td>
                    <input type="radio" id="sex" name="sex" value="男" checked> 男
                    <input type="radio" name="sex" value="女"> 女
                </td>
            </tr>
            <tr>
                <td>
                    <label for="stu_mail">Email</label>
                </td>
                <td>
                    <input type="text" id="stu_mail" name="stu_mail" placeholder="请输入邮箱">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="academy">学院</label>
                </td>
                <td>
                    <input type="text" id="academy" name="academy" placeholder="请输入学院">
                </td>
            </tr>
            <tr>
                <td>
                </td>
                <td>
                    <input type="submit" style="width: 80px" value="修改">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
