$(document).ready(
		function() {
			$('#isTitleRequired').hide();
		$('#isPriceRequired').hide();
		$('#isCategoryRequired').hide();
		$('#isImageUrlRequired').hide();
		$('#title').keyup(function() {
			var title = $("#title").val();
			$('#cardTitle').text(title);
			$('#isTitleRequired').hide();
		});

		$('#price').keyup(function() {
			var price = $("#price").val();
			$('#cardPrice').text(price);
			$('#isPriceRequired').hide();
		});

		$('#category').change(function() {
			$('#isCategoryRequired').hide();
		});

		$('#imageUrl').keyup(function() {
			var imageUrl = $("#imageUrl").val();
			$('#cardImage').attr('src', imageUrl);
			$('#isImageUrlRequired').hide();
			});

	$('#savebtn').click(
		function() {
			var isTitleRequired = $('#title').val().trim();
			var isPriceRequired = $('#price').val().trim();
			var isCategoryRequired = $('#category').val().trim();
			var isImageUrlRequired = $('#imageUrl').val().trim();
			var error = 0;
			if (isTitleRequired == "") {
				$('#isTitleRequired').show();
				error = 1;
			} else {
				$('#isTitleRequired').hide();
			}
			if (isPriceRequired == "") {
				error = 1;
				$('#isPriceRequired').show();
			} else {
				$('#isPriceRequired').hide();
			}
			if (isCategoryRequired == "") {
				error = 1;
				$('#isCategoryRequired').show();
			} else {
				$('#isCategoryRequired').hide();
			}
			if (isImageUrlRequired == "") {
				error = 1;
				$('#isImageUrlRequired').show();
			} else {
				$('#isImageUrlRequired').hide();
			}
	
			if (error) {
				return false;
			} else {
				return true;
			}
		});
	
	});

function deleteProduct(id){
	if(confirm("Are you sure you want to remove the product?")){
		$.ajax({
			url : 'deleteProduct/' + id,
			success : function(data) {
				location.reload();
			}
		});
	}
}