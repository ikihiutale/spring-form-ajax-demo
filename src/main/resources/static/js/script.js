var postForm = function ($this) {
	console.log("TODO..")
    var $form = $this.closest('form');
    $.ajax({
        type: 'POST',
        url: $form.attr('action'),
        data: $form.serialize(),
        dataType: 'html',
        success: function (response) {
        	var fadeOutDelay = 20000;
        	var $content = $($.trim(response));
        	var $success = $content.length ? $content.find('.success') : undefined;
        	if ($('.success').length && $success && $success.val() === 'true') {
            	console.log("OK!!")
            } 
            else 
            {
            	console.log("NOK!!")
            }
            $('.retail-register-page').html($content.filter('.retail-register-page').html());
            $success = $(document).find('.success-fade-out');
            if ($success.length && $success.is(":visible")) {
            	$success.fadeTo(fadeOutDelay, 0, function(){
            		$('selector').css("visibility", "hidden");   
            	}); 
            }
        }
    });
};
        
jQuery(document).ready(function($) {
	$(document).on('click', '.btn-join-register', function (e) {
		e.preventDefault();
		postForm($(this));
	});	
});
