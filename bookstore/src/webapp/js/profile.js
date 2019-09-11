/**
 * http://usejsdoc.org/
 */
$(function() {
	$("#txtBirthday").datetimepicker({
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
		forceParse : false, // 当输入非格式化日期时，强制格式化。默认true
		bootcssVer : 3,// 显示向左向右的箭头
		language : 'EN' // 语言
	});
	$("#txtUserName").blur(function() {
		// 用户名校验
		var username = $(this).val();
		// 校验规则，可调整
		var pattern = /\b(^['A-Za-z0-9]{4,20}$)\b/;
		if (!pattern.test(username)) {
			$("#username\\.info").html("Username illegal");
			return;
		} else {
			$("#username\\.info").html("");
		}
	});

	// 密码校验
	$("#idnewpassword").blur(function() {
		var password = $(this).val();
		var pattern = /\b(^['A-Za-z0-9]{4,20}$)\b/;
		if (password == '') {
			$("#newpassword\\.info").html("Please input new password");
			return;
		} else {
			if (!pattern.test(password)) {
				$("#newpassword\\.info").html("New password format error");
				return;
			} else {
				$("#newpassword\\.info").html("");
				return;
			}
		}
	});

	// 密码重复校验
	$("#idrepeatpassword").blur(function() {
		var repeatPass = $(this).val();

		var pattern = /\b(^['A-Za-z0-9]{4,20}$)\b/;
		if (repeatPass != $("#idnewpassword").val()) {
			$("#repeatpassword\\.info").html("Password different");
			return;
		} else {
			$("#repeatpassword\\.info").html("");
			return;
		}
	});

	$("#form").submit(function() {
		var ok = flag.email && flag.password && flag.nickname;
		if (ok == false) {
			alert("Error exist");
			history.back();
			return false;
		}
		return true;
	});

	if (message != null && message != "") {
		alert(message);
	}
})

function Swithmode() {
	Swith_object($("#txtUserName"));
	Swith_object($("#txtlocation"));
	Swith_object($("#idgenderm"));
	Swith_object($("#idgenderfm"));
	Swith_object($("#txtsmallgroup"));
	Swith_object($("#txtBirthday"));
	Swith_object($("#idsubmit"));
}

function Swith_object(object) {
	var value = object.attr("disabled");

	if (value == "disabled") {
		object.removeAttr("disabled");
	} else {
		object.attr("disabled", "disabled");
	}
}

function ChangePassword() {
	var oldpassword = $("#idpassword").val();
	var newpassword = $("#idnewpassword").val();
	if (newpassword == $("#idrepeatpassword").val()) {
		$.ajax({
			url : "register?op=pass",
			data : {
				oldpassword : oldpassword,
				newpassword : newpassword
			},
			dataType : "json",
			type : "post",
			success : function(data) {
				console.log(data);
				if (data.status == "Y") {
					$("#idpassword").val("");
					$("#idnewpassword").val("");
					$("#idrepeatpassword").val("");
					$("#repeatpassword\\.info").html("");
					$("#closebutton").click();
					alert("Change password success");
				} else {
					alert(data.message);
				}
			},
			error : function() {
				alert("Error");
			}
		})
	} else {
		$("#repeatpassword\\.info").html("Input error");
	}
}