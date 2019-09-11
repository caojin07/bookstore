/**
 * http://usejsdoc.org/
 */
function add_book(obj, bookid) {
	var res = confirm('Confirm to add');
	if (res == true) {
		$.ajax({
			url : "cart?operation=add",
			data : {
				"id" : bookid
			},
			dataType : "json",
			type : "post",
			success : function(data) {
				console.log(data);
				$("#cartnumber").html(data.cartnumber);
			},
			error : function() {
				alert("Add error");
			}
		})
	}
}

