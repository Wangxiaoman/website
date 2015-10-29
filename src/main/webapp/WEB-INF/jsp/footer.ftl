<%@page language="java" contentType="text/html; charset=utf-8" %>
<style type="text/css">
    .footer {
        width: 100%;
        min-height: 300px;
        background-color: #404857;
    }

    .footer .contact {
        background-color: #363B51;
        min-height: 80px;
    }

    .footer .contact .container {
        width: 80%;
    }

    .footer .contact .container .column_min{
        float: left;
        width: 18%;
        margin-top: 30px;
        vertical-align:middle;
    }

    .footer .contact .container .column_more{
        float: left;
        width: 27%;
        margin-top: 30px;
        vertical-align:middle;
    }

    .footer .contact .container em{
        color: #ffffff;
        margin-left: 3%;
    }

    .footer .more_info .container{
        width: 80%;
        min-height: 50px;
        font-size: 16px;
        margin-top: 20px;
    }

    .footer .more_info .container .about_us{
        float: left;
        width: 40%;
    }

    .footer .more_info .container .about_us a{
        color: #ffffff;
        font-style: italic;
    }

    .footer .more_info .container .legal{
        float: right;
        width: 40%;

    }

    .footer .more_info .container .legal em{
        color:#5e5e5e;
        font-style: italic;
        margin-left: 5px;
    }

</style>

<div class="modal fade" id="save_feed_back">
    <div class="modal-dialog">
        <form action="/feedback/save" method="post" onSubmit="return beforeSubmit(this);">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">给出您的建议</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>联系方式</label>
                        <input type="text" name="contact" id="contact" class="form-control"
                               placeholder="xxxx@xx.com">
                    </div>

                    <div class="form-group">
                        <label>建议</label>
                        <textarea name="feedback" id="feedback" class="form-control" cols="50" rows="10"></textarea>
                    </div>

                    <input type="hidden" name="interviewUrl" id="interviewUrl" value=""/>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary">提交</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </form>
    </div>
    <!-- /.modal-dialog -->
</div>

<div class="footer">
    <div class="contact">
        <div class="container">
            <div class="column_min">
                <img src="/assets/images/phone_128.png"  width="24px"><em>400-800-5555</em>
            </div>
            <div class="column_more">
                <img src="/assets/images/mail-24.png"><em>feedback@imianba.com</em>
            </div>
            <div class="column_more">
                <img src="/assets/images/location-24.png"><em>望京西 西路8号 大厦</em>
            </div>
            <div class="column_min">
                <img src="/assets/images/weibo-24.png"><em>面吧科技</em>
            </div>
            <%--<div class="column_min">--%>
                <%--<img src="/assets/images/qq-24.png"><em>12788888</em>--%>
            <%--</div>--%>
        </div>
    </div>

    <div class="more_info">
        <div class="container">
            <div class="about_us">
                <a>关于我们</a> <a>|</a> </a> <a>招贤纳士</a>
            </div>
            <div class="legal">
                <em>面吧科技技术有限公司</em><em>备案号</em>
            </div>
        </div>
    </div>
</div>

</body>

<script>
    var _hmt = _hmt || [];
    (function () {
        var hm = document.createElement("script");
        hm.src = "//hm.baidu.com/hm.js?13525bfa4fc5037920d909504a7dd04b";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>

</html>