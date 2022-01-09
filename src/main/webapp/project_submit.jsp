<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="GBK">
    <title>项目提交</title>
</head>
<body>
<script src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $("#tea_num").change(function(){
            var selected=$(this).children('option:selected').val()
            if(selected=="one"){
                $("#one_teacher").show();
                $("#one_teacher").find(":input").attr("disabled",false);
                $("#two_teacher").hide();
                $("#two_teacher").find(":input").attr("disabled",true);
            }else if(selected=="two"){
                $("#two_teacher").show();
                $("#two_teacher").find(":input").attr("disabled",false);
                $("#one_teacher").hide();
                $("#one_teacher").find(":input").attr("disabled",true);
            }
        });
        $("#stu_num").change(function(){
            var selected=$(this).children('option:selected').val()
            if(selected=="one"){
                $("#one_stu").show();
                $("#one_stu").find(":input").attr("disabled",false);
                $("#two_stu").hide();
                $("#two_stu").find(":input").attr("disabled",true);
                $("#three_stu").hide();
                $("#three_stu").find(":input").attr("disabled",true);
                $("#four_stu").hide();
                $("#four_stu").find(":input").attr("disabled",true);
            }else if(selected=="two"){
                $("#one_stu").hide();
                $("#one_stu").find(":input").attr("disabled",true);
                $("#two_stu").show();
                $("#two_stu").find(":input").attr("disabled",false);
                $("#three_stu").hide();
                $("#three_stu").find(":input").attr("disabled",true);
                $("#four_stu").hide();
                $("#four_stu").find(":input").attr("disabled",true);
            }else if(selected=="three"){
                $("#one_stu").hide();
                $("#one_stu").find(":input").attr("disabled",true);
                $("#two_stu").hide();
                $("#two_stu").find(":input").attr("disabled",true);
                $("#three_stu").show();
                $("#three_stu").find(":input").attr("disabled",false);
                $("#four_stu").hide();
                $("#four_stu").find(":input").attr("disabled",true);
            }else if(selected=="four"){
                $("#one_stu").hide();
                $("#one_stu").find(":input").attr("disabled",true);
                $("#two_stu").hide();
                $("#two_stu").find(":input").attr("disabled",true);
                $("#three_stu").hide();
                $("#three_stu").find(":input").attr("disabled",true);
                $("#four_stu").show();
                $("#four_stu").find(":input").attr("disabled",false);
            }
        });
        $("#material_m").blur(function (){
            var num1=parseInt($("#material_m").val());
            var num2=parseInt($("#print_m").val());
            var num3=parseInt($("#vehicle_m").val());
            var num4 = parseInt($("#publish_m").val());
            var num5=parseInt($("#express_m").val());
            var num = num1+num2+num3+num4+num5;
            $("#money").val(num);
        })
        $("#print_m").blur(function (){
            var num1=parseInt($("#material_m").val());
            var num2=parseInt($("#print_m").val());
            var num3=parseInt($("#vehicle_m").val());
            var num4 = parseInt($("#publish_m").val());
            var num5=parseInt($("#express_m").val());
            var num = num1+num2+num3+num4+num5;
            $("#money").val(num);
        })
        $("#vehicle_m").blur(function (){
            var num1=parseInt($("#material_m").val());
            var num2=parseInt($("#print_m").val());
            var num3=parseInt($("#vehicle_m").val());
            var num4 = parseInt($("#publish_m").val());
            var num5=parseInt($("#express_m").val());
            var num = num1+num2+num3+num4+num5;
            $("#money").val(num);
        })
        $("#publish_m").blur(function (){
            var num1=parseInt($("#material_m").val());
            var num2=parseInt($("#print_m").val());
            var num3=parseInt($("#vehicle_m").val());
            var num4 = parseInt($("#publish_m").val());
            var num5=parseInt($("#express_m").val());
            var num = num1+num2+num3+num4+num5;
            $("#money").val(num);
        })
        $("#express_m").blur(function (){
            var num1=parseInt($("#material_m").val());
            var num2=parseInt($("#print_m").val());
            var num3=parseInt($("#vehicle_m").val());
            var num4 = parseInt($("#publish_m").val());
            var num5=parseInt($("#express_m").val());
            var num = num1+num2+num3+num4+num5;
            $("#money").val(num);
        })
    });
</script>
<script>
    $(document).ready(function (){
        if(<%=request.getSession().getAttribute("p_type").equals("nation")%>){
            $("#p_type1").click();
        }else if(<%=request.getSession().getAttribute("p_type").equals("province")%>){
            $("#p_type2").click();
        }else if(<%=request.getSession().getAttribute("p_type").equals("school")%>){
            $("#p_type3").click();
        }else if(<%=request.getSession().getAttribute("p_type").equals("academy")%>){
            $("#p_type4").click();
        }
        var select1 = document.getElementById("subjecttype");
        if(<%=request.getSession().getAttribute("subjecttype").equals("engineer")%>){
            select1.options[0].selected = true;
        }else if(<%=request.getSession().getAttribute("subjecttype").equals("literature")%>){
            select1.options[1].selected = true;
        }
        var select2 = document.getElementById("tea_num");
        if(<%=request.getSession().getAttribute("tea_num").equals("one")%>){
            select2.options[0].selected = true;
            $("#one_teacher").show();
            $("#one_teacher").find(":input").attr("disabled",false);
            $("#two_teacher").hide();
            $("#two_teacher").find(":input").attr("disabled",true);
        }else if(<%=request.getSession().getAttribute("tea_num").equals("two")%>){
            select2.options[1].selected = true;
            $("#two_teacher").show();
            $("#two_teacher").find(":input").attr("disabled",false);
            $("#one_teacher").hide();
            $("#one_teacher").find(":input").attr("disabled",true);
        }
        var select3 = document.getElementById("stu_num");
        if(<%=request.getSession().getAttribute("stu_num").equals("one")%>){
            select3.options[0].selected = true;
            $("#one_stu").show();
            $("#one_stu").find(":input").attr("disabled",false);
            $("#two_stu").hide();
            $("#two_stu").find(":input").attr("disabled",true);
            $("#three_stu").hide();
            $("#three_stu").find(":input").attr("disabled",true);
            $("#four_stu").hide();
            $("#four_stu").find(":input").attr("disabled",true);
        }else if(<%=request.getSession().getAttribute("stu_num").equals("two")%>){
            select3.options[1].selected = true;
            $("#one_stu").hide();
            $("#one_stu").find(":input").attr("disabled",true);
            $("#two_stu").show();
            $("#two_stu").find(":input").attr("disabled",false);
            $("#three_stu").hide();
            $("#three_stu").find(":input").attr("disabled",true);
            $("#four_stu").hide();
            $("#four_stu").find(":input").attr("disabled",true);
        }else if(<%=request.getSession().getAttribute("stu_num").equals("three")%>){
            select3.options[2].selected = true;
            $("#one_stu").hide();
            $("#one_stu").find(":input").attr("disabled",true);
            $("#two_stu").hide();
            $("#two_stu").find(":input").attr("disabled",true);
            $("#three_stu").show();
            $("#three_stu").find(":input").attr("disabled",false);
            $("#four_stu").hide();
            $("#four_stu").find(":input").attr("disabled",true);
        }else if(<%=request.getSession().getAttribute("stu_num").equals("four")%>){
            select3.options[3].selected = true;
            $("#one_stu").hide();
            $("#one_stu").find(":input").attr("disabled",true);
            $("#two_stu").hide();
            $("#two_stu").find(":input").attr("disabled",true);
            $("#three_stu").hide();
            $("#three_stu").find(":input").attr("disabled",true);
            $("#four_stu").show();
            $("#four_stu").find(":input").attr("disabled",false);
        }
    });
</script>
<div>
    <form id="project_form" action="projectServlet">
        <input type="hidden" name="action" value="project">
        <div>
            项目类别：
            <input type="radio" name="p_type" id="p_type1" value="nation">国创-创新训练
            <input type="radio" name="p_type" id="p_type2" value="province">省创-科技创新
            <input type="radio" name="p_type" id="p_type3" value="school">校级SRTP
            <input type="radio" name="p_type" id="p_type4" value="academy">院级SRTP<br>
            项目名称：
            <input type="text" name="p_name" value="<%=request.getSession().getAttribute("p_name")%>"><br>
            学科类别：
            <select name="subjecttype" id="subjecttype">
                <option value="engineer">工科</option>
                <option value="literature">文科</option>
            </select><br>
            导师人数：
            <select id="tea_num" name="tea_num">
                <option value="one" selected>1</option>
                <option value="two">2</option>
            </select><br>
            <div id="one_teacher">
                负责导师：
                工号：<input type="text" name="tea_id1" value="<%=request.getSession().getAttribute("tea_id1")%>"><br>
            </div>
            <div id="two_teacher" style="display: none">
                负责导师：
                工号：<input type="text" name="tea_id1" value="<%=request.getSession().getAttribute("tea_id1")%>"><br>
                参与导师：
                工号：<input type="text" name="tea_id2" value="<%=request.getSession().getAttribute("tea_id2")%>"><br>
            </div>
            负责学生：&nbsp我<br>
            学生人数：
            <select id="stu_num" name="stu_num">
                <option value="one" selected>1</option>
                <option value="two">2</option>
                <option value="three">3</option>
                <option value="four">4</option>
            </select><br>
            <div id="one_stu">
                参与学生：
                学号：<input type="text" name="stu_id1" value="<%=request.getSession().getAttribute("stu_id1")%>"><br>
            </div>
            <div id="two_stu" style="display: none">
                参与学生：
                学号：<input type="text" name="stu_id1" value="<%=request.getSession().getAttribute("stu_id1")%>"><br>
                参与学生：
                学号：<input type="text" name="stu_id2" value="<%=request.getSession().getAttribute("stu_id2")%>"><br>
            </div>
            <div id="three_stu" style="display: none">
                参与学生：
                学号：<input type="text" name="stu_id1" value="<%=request.getSession().getAttribute("stu_id1")%>"><br>
                参与学生：
                学号：<input type="text" name="stu_id2" value="<%=request.getSession().getAttribute("stu_id2")%>"><br>
                参与学生：
                学号：<input type="text" name="stu_id3" value="<%=request.getSession().getAttribute("stu_id3")%>"><br>
            </div>
            <div id="four_stu" style="display: none">
                参与学生：
                学号：<input type="text" name="stu_id1" value="<%=request.getSession().getAttribute("stu_id1")%>"><br>
                参与学生：
                学号：<input type="text" name="stu_id2" value="<%=request.getSession().getAttribute("stu_id2")%>"><br>
                参与学生：
                学号：<input type="text" name="stu_id3" value="<%=request.getSession().getAttribute("stu_id3")%>"><br>
                参与学生：
                学号：<input type="text" name="stu_id4" value="<%=request.getSession().getAttribute("stu_id4")%>"><br>
            </div>
        </div>
        <div>
            <table>
                <tr><td>项目主要内容简介：</td><td><input type="text" name="p_info" value="<%=request.getSession().getAttribute("p_info")%>"></td></tr>
                <tr><td>项目负责人参与科研情况：</td><td><input type="text" name="header_info" value="<%=request.getSession().getAttribute("header_info")%>"></td></tr>
                <tr><td>项目组成员参与科研情况：</td><td><input type="text" name="member_info" value="<%=request.getSession().getAttribute("member_info")%>"></td></tr>
                <tr><td>项目背景、目的及意义：</td><td><input type="text" name="meaning" value="<%=request.getSession().getAttribute("meaning")%>"></td></tr>
                <tr><td>项目研究方案：</td><td><input type="text" name="method" value="<%=request.getSession().getAttribute("method")%>"></td></tr>
                <tr><td>项目研究条件及创新支持：</td><td><input type="text" name="creative" value="<%=request.getSession().getAttribute("creative")%>"></td></tr>
                <tr><td>项目预期成果：</td><td><input type="text" name="pre_result" value="<%=request.getSession().getAttribute("pre_result")%>"></td></tr>
            </table>
        </div>
        申请经费：<input type="text" id="money" name="money" readonly value="<%=request.getSession().getAttribute("money")%>">（自动统计，不需填写）<br>
        <div>
            项目经费预算及用途：
            <table>
                <tr><th>开支科目</th><th>预算经费（元）</th><th>主要用途</th></tr>
                <tr><td>专用材料费</td><td><input type="text" id="material_m" name="material_m" value="<%=request.getSession().getAttribute("material_m")%>"></td><td><input type="text"></td></tr>
                <tr><td>印刷费与资料费</td><td><input type="text" id="print_m" name="print_m" value="<%=request.getSession().getAttribute("print_m")%>"></td><td><input type="text"></td></tr>
                <tr><td>交通与差旅费</td><td><input type="text" id="vehicle_m" name="vehicle_m" value="<%=request.getSession().getAttribute("vehicle_m")%>"></td><td><input type="text"></td></tr>
                <tr><td>出版费</td><td><input type="text" id="publish_m" name="publish_m" value="<%=request.getSession().getAttribute("publish_m")%>"></td><td><input type="text"></td></tr>
                <tr><td>邮寄费</td><td><input type="text" id="express_m" name="express_m" value="<%=request.getSession().getAttribute("express_m")%>"></td><td><input type="text"></td></tr>
            </table>
        </div>
        <div>
            <h3>承诺书</h3>
            <p>以上所填内容真实可靠，本项目组承诺:</p>
            <p>该项目立项后，将严格遵守有关规定、遵守本申报书和预算表中规定的条款和内容，保证按计划进度完成项目任务。</p>
            <input type="radio" value="accept">同意
            <input type="radio" value="refuse">不同意
        </div>
        <input type="submit" id="save" name="submit" value="保存项目">
        <input type="submit" name="submit" value="保存并提交">
    </form>
</div>
</body>
</html>