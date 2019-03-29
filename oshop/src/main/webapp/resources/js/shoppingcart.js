function increaseQuantity(id) {
	var individualQuantity = parseInt($('#quantity' + id).val());
	var quan=$('#quantity' + id).val(individualQuantity + 1);
	$.ajax({
		type : "GET",
		url : 'addingShoppingcart/' + id,
		success : function(data) {
			location.reload();
		}
	});
}

function decreaseQuantity(id) {
	var individualQuantity = parseInt($('#quantity' + id).val());
	if(individualQuantity>0){ 
		var quantity= $('#quantity'+id).val(individualQuantity - 1);
		if(quantity.val() > 0){
			$.ajax({
				type : "GET",
				url : 'reducingShoppingcart/' + id,
				success : function(data) {
					location.reload();
				}
			});
		}
	}
	if(individualQuantity==1){
		if(confirm("Are you sure you want to remove from cart?")){
			$.ajax({
			type : "GET",
			url : 'deletecart/' + id,
			success : function(data) {
				location.reload();
			}
		});
		}
		else{
			$('#quantity'+id).val(1);
		}
	}
}