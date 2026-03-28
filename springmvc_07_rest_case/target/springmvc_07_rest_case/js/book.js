$(document).ready(function () {
    // 页面加载完成后自动获取数据
    getAll();

    // 绑定保存按钮点击事件
    $("#btnSave").click(function () {
        // 1. 封装表单数据为 JSON 对象
        var formData = {
            type: $("#type").val(),
            name: $("#name").val(),
            description: $("#description").val()
        };

        // 2. 发送异步 POST 请求
        $.ajax({
            url: "/books", // 对应 Controller 的 @RequestMapping("/books")
            type: "POST",
            contentType: "application/json;charset=utf-8",
            data: JSON.stringify(formData),
            success: function (res) {
                alert("保存成功！服务器响应：" + res);
                // 保存成功后刷新列表并清空表单
                getAll();
                $("#bookForm")[0].reset();
            }
        });
    });

    // 刷新按钮事件
    $("#btnGetAll").click(function () {
        getAll();
    });
});

// 查询所有数据的函数
function getAll() {
    $.ajax({
        url: "/books",
        type: "GET",
        success: function (res) {
            // res 应当是 Controller 返回的 List<Book>
            var html = "";
            for (var i = 0; i < res.length; i++) {
                html += "<tr>" +
                    "<td>" + res[i].type + "</td>" +
                    "<td>" + res[i].name + "</td>" +
                    "<td>" + res[i].description + "</td>" +
                    "</tr>";
            }
            // 将拼接好的 html 填充到 table 的 tbody 中
            $("#bookTable tbody").html(html);
        }
    });
}
