<script type="text/javascript" charset="utf-8">
	$(function() {
		$.ajax({
			url : "booklist?operation=right",
			/* data : {
				"id" : bookid
			}, */
			dataType : "json",
			type : "post",
			success : function(data) {
				//$(obj).parents("tr").remove();
				$("#idpanel").html("");
				console.log(data);
						
				for (var i = 0; i < data.length; i++){
					var a = '<a href="booklist?operation=detail&id='+ data[i].id +'">'+ data[i].name +'</a> by '+ data[i].user.username +'<br>';
					$("#idpanel").append(a);
				}
			},
			error : function() {
				
			}
		})
	})
</script>
<div class="col-md-3" style="margin-top: 80px">
	<div class="panel panel-default">
		<div class="panel-heading">
			New books online <a class="text-muted pull-right" href="booklist?operation=list">>></a>
		</div>
		<div class="panel-body" id="idpanel"></div>
	</div>
</div>