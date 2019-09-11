/**
 * http://usejsdoc.org/
 */
var borrowid = null;

function setid(id) {
	borrowid = id;
	var comment = $("#" + borrowid).val();
	$("#idcomment").val(comment);

}

function SaveComment() {
	var comment = $("#idcomment").val();
	$.ajax({
		url : "borrow?op=comment",
		data : {
			"id" : borrowid,
			"comment" : comment
		},
		dataType : "json",
		type : "post",
		success : function(data) {
			// $(obj).parents("tr").remove();
			// $("#cartnumber").html(data.cartnumber);
			if ("ok" == data.result) {
				alert("ok");
				$("#" + borrowid).val(comment);
				$("#closebutton").click();

			}

		},
		error : function() {
			alert("save comment error");
		}
	})
}

