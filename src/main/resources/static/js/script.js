function handleCheckoutBtn() {
  var $this = $(this);
  var orderId = $this.data("order");
  var url = $this.data("url");
  var data = {orderId: orderId};
  console.log( "handleCheckoutBtn: order id=" + orderId + ", url=" + url );
  $.ajax({
      type: "post",
      url: url,
      //contentType : "application/json; charset=utf-8",
      //contentType: "application/json",
      //dataType : "html",
      data: data,
      success: function(data) {
    	  $("#klarna-checkout").html(data);
      },
      error: function(){
          alert("NOOOOOOP");
      },
      //timeout: 600000 
  });
  return false;
}


function handleConfirm(elem) {
	  var $elem = $(elem);
	  var orderId = $elem.data("order");
	  var url = $elem.data("url");
	  var data = {orderId: orderId};
	  console.log( "handleConfirm: order id=" + orderId + ", url=" + url );
	  $.ajax({
	      type: "post",
	      url: url,
	      //contentType : "application/json; charset=utf-8",
	      //contentType: "application/json",
	      //dataType : "html",
	      data: data,
	      success: function(data) {
	    	  $("#klarna-confirm").html(data);
	      },
	      error: function(){
	          alert("NOOOOOOP");
	      },
	      //timeout: 600000 
	  });
	  return false;
}

jQuery(document).ready(function($) {
	$("#orders-table tbody tr").click(function() {
	    window.location.href = $(this).data("href");
	});
	

	$( "#order-checkout-btn" ).on( "click", handleCheckoutBtn);
	
	if ($('#klarna-confirm').length) {
		handleConfirm($('#klarna-confirm'));
	}
	

});
