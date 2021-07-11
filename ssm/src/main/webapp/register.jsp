<%--
  Created by IntelliJ IDEA.
  User: jiangjf
  Date: 2021/7/11
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#uploadFile").click(function () {
                // 获取要上传的文件
                var photoFile = $("#photo")[0].files[0];
                if (photoFile == undefined) {
                    alert("您还未选中文件");
                    return;
                }

                // 将文件装入FormData对象
                var formData = new FormData();
                formData.append("headPhoto", photoFile);
                $.ajax({
                    type: "post",
                    data: formData,
                    url: "fileUpload.do",
                    processData: false,
                    contentType: false,
                    success: function (result) {
                        console.log(result);
                        $("#headImg").attr("src", result.filePath);
                        $("#photoName").val(result.newFileName);
                        $("#fileType").val(result.fileType);
                    },
                    xhr: function () {
                        var xhr = new XMLHttpRequest();
                        //使用XMLHttpRequest.upload监听上传过程，注册progress事件，打印回调函数中的event事件
                        xhr.upload.addEventListener('progress', function (e) {
                            //loaded代表上传了多少
                            //total代表总数为多少
                            var progressRate = (e.loaded / e.total) * 100 + '%';
                            //通过设置进度条的宽度达到效果
                            $('.progress > div').css('width', progressRate);
                        })
                        return xhr;
                    }
                });
            });
        });
    </script>
    <style>
        .progress {
            width: 200px;
            height: 10px;
            border: 1px solid #ccc;
            border-radius: 10px;
            margin: 10px 0px;
            overflow: hidden;
        }
        /* 初始状态设置进度条宽度为0px */
        .progress > div {
            width: 0px;
            height: 100%;
            background-color: yellowgreen;
            transition: all .3s ease;
        }
    </style>
</head>
<body>
<form action="addPlayer.do" method="post">
    <p>账号<input type="text" name="name"/></p>
    <p>密码<input type="text" name="password"/></p>
    <p>昵称<input type="text" name="nickname"/></p>
    <p>头像
        <br/>
        <input type="file" id="photo"/>
        <br/>
        <img id="headImg" style="width: 200px;height: 200px" src="" alt="你还未上传图片">
        <br/>
        <%--进度条--%>
    <div class="progress">
        <div></div>
    </div>
    <input id="photoName" type="hidden" name="photo"/>
    <input id="fileType" type="hidden" name="filetype">
    <a id="uploadFile" href="javascript:void(0)">立即上传</a>
    </p>
    <p><input type="submit" value="注册"/></p>

</form>
</body>
</html>
