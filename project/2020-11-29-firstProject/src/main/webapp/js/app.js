//页面加载完成后执行function里面的逻辑
$(function () {
    //在页面表单
    //在jquery，使用$("#id")通过id是获取某个页面元素
    $("#login_form").submit(function () {
        //Ajax自己发请求
        $.ajax({
            url:"../login",//请求的服务路径
            type:"post", //请求方法
            //-------------------
            //响应数据类型：dataType:"",
            //不使用默认为表单提交格式(xxx-)
            //json需要手动指定
            //------------------
            //请求的数据类型：请求头content-Type，默认表单格式，json
            // contentType:"",

            //请求数据：使用序列化的表单数据
            //serialize()将表单内容序列化
            data:$("#login_form").serialize(),
            dataType:"json",
            //设置响应内容
            success:function (r) {//响应体json字符串，会解析为方法参数
                if(r.success){
                    //前端页面url直接跳转到某个路径
                    window.location.href="../jsp/articleList.jsp";
                }else {
                    alert("错误码:"+r.code+"\n消息体："+r.message);
                }
            }
        })
        //统一不执行默认的表单提交
        return false;
    })
})