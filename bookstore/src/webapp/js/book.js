/**
 * http://usejsdoc.org/
 */
$(function() {
	var $btn = $("#addtocart");
	var $bookid = request("id");
	$btn.on("click", function() {
		$.ajax({
			url : "cart?operation=add",
			data : {
				id : $bookid
			},
			dataType : "json",
			type : "post",
			success : function(data) {
				$("#cartnumber").html(data.cartnumber);
				alert(data.message);
			},
			error : function() {
				alert("Error");
			}
		})
	});
})


function request(paras) {
	var url = location.href;
	var paraString = url.substring(url.indexOf("?") + 1, url.length).split("&");
	var paraObj = {}
	for (i = 0; j = paraString[i]; i++) {
		paraObj[j.substring(0, j.indexOf("=")).toLowerCase()] = j.substring(j
				.indexOf("=") + 1, j.length);
	}
	var returnValue = paraObj[paras.toLowerCase()];
	if (typeof (returnValue) == "undefined") {
		return "";
	} else {
		return returnValue;
	}
}


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

