$(function () {
    // 初始化加载
    getAll();

    // 搜索按钮
    $("#btnSearch").click(function() {
        // 后端若无条件查询接口，此处可做前端过滤或调用 getById
        getAll();
    });

    // “新建”按钮：显示表单并清空
    $("#btnShowAdd").click(function() {
        $("#formTitle").text("新增图书");
        $("#bookId").val(""); // 清空ID
        $("#bookForm")[0].reset();
        $("#bookFormSection").show();
    });

    // “取消”按钮
    $("#btnCancel").click(function() {
        $("#bookFormSection").hide();
    });

    // “保存”按钮 (新增/修改通用)
    $("#btnSave").click(function () {
        saveOrUpdate();
    });
});

// 获取列表渲染
function getAll() {
    $.ajax({
        url: "/books",
        type: "GET",
        success: function (res) {
            if (res.code == 20041) {
                var bookList = res.data;
                var html = "";
                for (var i = 0; i < bookList.length; i++) {
                    var b = bookList[i];
                    html += `<tr>
                        <td>${i + 1}</td>
                        <td>${b.type}</td>
                        <td>${b.name}</td>
                        <td>${b.description}</td>
                        <td>
                            <button class="btn-edit" onclick="getById(${b.id})">编辑</button>
                            <button class="btn-del" onclick="deleteBook(${b.id})">删除</button>
                        </td>
                    </tr>`;
                }
                $("#bookTable tbody").html(html);
            }
        }
    });
}

// 保存或更新
function saveOrUpdate() {
    var id = $("#bookId").val();
    var bookData = {
        id: id ? id : null,
        type: $("#type").val(),
        name: $("#name").val(),
        description: $("#description").val()
    };

    // 如果有ID则用 PUT(修改)，没有则用 POST(新增)
    var type = id ? "PUT" : "POST";

    $.ajax({
        url: "/books",
        type: type,
        contentType: "application/json",
        data: JSON.stringify(bookData),
        success: function (res) {
            if (res.code == 20011 || res.code == 20031) {
                alert("操作成功！");
                $("#bookFormSection").hide();
                getAll();
            } else {
                alert(res.msg);
            }
        }
    });
}

// 删除功能
function deleteBook(id) {
    if (confirm("确定要删除这条记录吗？")) {
        $.ajax({
            url: "/books/" + id,
            type: "DELETE",
            success: function (res) {
                if (res.code == 20021) {
                    alert("删除成功！");
                    getAll();
                } else {
                    alert(res.msg);
                }
            }
        });
    }
}

// 编辑前查询回显
function getById(id) {
    $.ajax({
        url: "/books/" + id,
        type: "GET",
        success: function (res) {
            if (res.code == 20041 && res.data) {
                $("#formTitle").text("修改图书");
                $("#bookId").val(res.data.id);
                $("#type").val(res.data.type);
                $("#name").val(res.data.name);
                $("#description").val(res.data.description);
                $("#bookFormSection").show();
                // 滚动到表单位置
                $("html,body").animate({scrollTop:0}, 500);
            }
        }
    });
}
