/**
 * http://usejsdoc.org/
 */
$(function() {
	//First time
	refresh_subcategory();
	
	$("#categoryid").change(function() {
		refresh_subcategory();
	});
})

function refresh_subcategory() {
	var category = $("#categoryid").val();
	$.ajax({
		url : "booklist?operation=subcategory",
		data : {
			"category" : category
		},
		dataType : "json",
		type : "post",
		success : function(data) {
			console.log(data);
			$("#subcategoryid").html("");
			for (var i = 0; i < data.length; i++) {
				$("#subcategoryid").append(
						"<option value='" + data[i].sub_category + "'>"
								+ data[i].description + "</option>");
			}
		},
		error : function() {
			alert("Subcategory error");
		}
	})
}