var init = function(){
    $("#hidden_username").val(getQueryString("username"));
    template.config('escape', false);
    //定义参数类型
    $.ajax({
        url: '/paper',
        type: 'get',
        data: {
            "username": getQueryString("username")
        },
        success:function(res){
            var test = JSON.parse(res);
            //追加模板消息
            var str = template('radio-ques', {
                "record": test
            });
            //$(".mui-content").html(str);
            document.querySelector('.content-ques').innerHTML = str;
        }
    });
}

function check(){
    var radioName = new Array();
    $(":radio").each(function(){
        radioName.push($(this).attr("name"));
    });
    radioName.sort();
    $.unique(radioName);
    for(var i in radioName) {
        if(!checkRadio(radioName[i])){
            alert("您还有未选择项，请选择，谢谢~");
            return false;
        }
    };
}

function checkRadio(radioName) {
    return $("input[name=" + radioName + "]:checked").val() == null ? false : true;
}

// Parallax function
// https://codepen.io/roborich/pen/wpAsm
var background_image_parallax = function ($object, multiplier) {
    multiplier = typeof multiplier !== 'undefined' ? multiplier : 0.5;
    multiplier = 1 - multiplier;
    var $doc = $(document);
    $object.css({ "background-attatchment": "fixed" });
    $(window).scroll(function () {
        var from_top = $doc.scrollTop(),
            bg_css = 'center ' + (multiplier * from_top - 200) + 'px';
        $object.css({ "background-position": bg_css });
    });
};

/**
 * detect IE
 * returns version of IE or false, if browser is not Internet Explorer
 */
function detectIE() {
    var ua = window.navigator.userAgent;

    var msie = ua.indexOf('MSIE ');
    if (msie > 0) {
        // IE 10 or older => return version number
        return parseInt(ua.substring(msie + 5, ua.indexOf('.', msie)), 10);
    }

    var trident = ua.indexOf('Trident/');
    if (trident > 0) {
        // IE 11 => return version number
        var rv = ua.indexOf('rv:');
        return parseInt(ua.substring(rv + 3, ua.indexOf('.', rv)), 10);
    }
    return false;
}

$(document).ready(function () {
    // Detect IE
    if (detectIE()) {
        alert('为了更好的使用体验，请使用Chrome, Firefox, 或Edge浏览器。');
    }

    $('select').formSelect();
    // Parallax image background
    background_image_parallax($(".tm-parallax"), 0.40);

    // Darken image when its radio button is selected
    $(".tm-radio-group-1").click(function () {
        $('.tm-radio-group-1').parent().siblings("img").removeClass("darken");
        $(this).parent().siblings("img").addClass("darken");
    });

    $(".tm-radio-group-2").click(function () {
        $('.tm-radio-group-2').parent().siblings("img").removeClass("darken");
        $(this).parent().siblings("img").addClass("darken");
    });

    $(".tm-checkbox").click(function () {
        $(this).parent().siblings("img").toggleClass("darken");
    })
});