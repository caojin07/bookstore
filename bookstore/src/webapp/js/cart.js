/**
 * http://usejsdoc.org/
 */
function remove_book(obj,bookid) {
	var res = confirm('Confirm to remove');
	if (res == true) {
		$.ajax({
			url : "cart?operation=remove",
			data : {
				"id" : bookid
			},
			dataType : "json",
			type : "post",
			success : function(data) {
				$(obj).parents("tr").remove();
				$("#cartnumber").html(data.cartnumber);
			},
			error : function() {
				alert("Remove error");
			}
		})
	}
}
