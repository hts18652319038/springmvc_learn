<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>系统管理首页</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: "Microsoft YaHei", sans-serif;
        }

        body {
            display: flex;
            height: 100vh;
            overflow: hidden;
            background-color: #f5f7fa;
        }

        .sidebar {
            width: 220px;
            background: #2f3545;
            color: white;
            height: 100%;
            padding-top: 20px;
        }

        .sidebar .logo {
            text-align: center;
            font-size: 20px;
            font-weight: bold;
            margin-bottom: 30px;
            padding: 10px;
            color: #667eea;
        }

        .sidebar ul {
            list-style: none;
        }

        .sidebar ul li {
            padding: 15px 25px;
            cursor: pointer;
            transition: background 0.3s;
        }

        .sidebar ul li:hover, .sidebar ul li.active {
            background: #667eea;
        }

        .main {
            flex: 1;
            display: flex;
            flex-direction: column;
        }

        .header {
            height: 60px;
            background: white;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 0 20px;
        }

        .content {
            flex: 1;
            padding: 20px;
            overflow-y: auto;
        }

        .welcome {
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }

        .card-box {
            display: flex;
            gap: 20px;
            margin-top: 20px;
        }

        .card {
            width: 240px;
            background: white;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
            text-align: center;
        }

        .card h3 {
            color: #667eea;
        }
    </style>
</head>
<body>
<div class="sidebar">
    <div class="logo">参数管理系统</div>
    <ul>
        <li class="active">首页</li>
        <li>普通参数管理</li>
        <li>JSON参数管理</li>
        <li>用户管理</li>
    </ul>
</div>

<div class="main">
    <div class="header">
        <div>首页 - 系统总览</div>
        <div>管理员</div>
    </div>
    <div class="content">
        <div class="welcome">
            <h2>欢迎使用参数管理系统</h2>
            <p>SpringMVC 参数接收测试</p>
        </div>
        <div class="card-box">
            <div class="card"><h3>普通参数</h3></div>
            <div class="card"><h3>集合参数</h3></div>
            <div class="card"><h3>JSON参数</h3></div>
        </div>
    </div>
</div>
</body>
</html>
