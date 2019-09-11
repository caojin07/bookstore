/**
 * http://usejsdoc.org/
 */
$(function() {
	if (remember != null) {
		if (remember == "checked") {
			$("#remembercheck").attr("checked", "checked");
		} else {
			$("#remembercheck").removeAttr('checked');
		}
	}
})
