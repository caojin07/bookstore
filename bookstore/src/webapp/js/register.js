/**
 * http://usejsdoc.org/
 */

var flag = {
	"inumber" : false,
	"username" : false,
	"password" : false
};

$(function() {
	// Inumber check
	$("#txtInumber").blur(function() {
		var inumber = $(this).val();
		$.ajax({
			url : "register?op=icheck",
			data : {
				"inumber" : inumber
			},
			dataType : "json",
			type : "post",
			success : function(data) {
				if (data.result == "error") {
					$("#inumber\\.info").html("I Number already registered");
					flag.inumber = false;
				} else {
					$("#inumber\\.info").html("");
					flag.inumber = true;
				}
			},
			error : function() {
				alert("Check error");
			}
		})

	});

	// email验证
	$("#txtEmail")
			.blur(
					function() {
						var email = $(this).val();
						var pattern = /\b(^['_A-Za-z0-9-]+(\.['_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\.[A-Za-z0-9-]+)*((\.[A-Za-z0-9]{2,})|(\.[A-Za-z0-9]{2,}\.[A-Za-z0-9]{2,}))$)\b/;
						if (!pattern.test(email)) {
							$("#email\\.info").html("Email格式不正确");
							return;
						} else {
							$("#email\\.info").html("");
							flag.email = true;
						}
						// 邮箱重复校验
					});
/*	$("#txtBirthday").datetimepicker({
		format : 'yyyy-mm-dd', // 显示格式可为yyyymm/yyyy-mm-dd/yyyy.mm.dd
		weekStart : 1, // 0-周日,6-周六 。默认为0
		autoclose : true,
		startView : 3, // 打开时显示的视图。0-'hour'
		// 1-'day'
		// 2-'month'
		// 3-'year'
		// 4-'decade'
		minView : 2,
		initialDate : new Date(),// 初始化日期.默认new
		// Date()当前日期
		forceParse : false, // 当输入非格式化日期时，强制格式化。默认true
		bootcssVer : 3,// 显示向左向右的箭头
		language : 'EN' // 语言
	});*/
	$("#txtUsername").blur(function() {
		// 用户名校验
		var username = $(this).val();

		// 校验规则，可调整
		var pattern = /\b(^['A-Za-z0-9]{4,20}$)\b/;
		if (!pattern.test(username)) {
			$("#username\\.info").html("Username illegal");
			return;
		} else {
			$("#username\\.info").html("");
			flag.username = true;
		}
	});

	// 密码校验
	$("#txtPassword").blur(function() {
		var password = $(this).val();

		var pattern = /\b(^['A-Za-z0-9]{4,20}$)\b/;
		if (!pattern.test(password)) {
			$("#password\\.info").html("Password format error");
			return;
		} else {
			$("#password\\.info").html("");
			// flag.password=true;
			return;
		}
	});

	// 密码重复校验
	$("#txtRepeatPass").blur(function() {
		var repeatPass = $(this).val();

		var pattern = /\b(^['A-Za-z0-9]{4,20}$)\b/;
		if (repeatPass != $("#txtPassword").val()) {
			$("#repeatPass\\.info").html("Password different");
			return;
		} else {
			$("#repeatPass\\.info").html("");
			flag.password = true;
			return;
		}
	});

	$("#form").submit(function() {
		var ok = flag.inumber && flag.email && flag.password;
		if (ok == false) {
			alert("Error exist");
			history.back();
			return false;
		}
		return true;
	});

})