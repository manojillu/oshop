function addToCart(id) {
	alert("Your item has been successfully added to cart")
	$.ajax({
		type : "GET",
		url : 'addingShoppingcart/' + id,
		success : function(data) {
			$('#quantity').html(data);
		}
	});
}
