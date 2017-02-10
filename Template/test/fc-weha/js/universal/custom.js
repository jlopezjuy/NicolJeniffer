(function($) {
 "use strict";
	
	var slider = new MasterSlider();
	// adds Arrows navigation control to the slider.
	slider.control('arrows');
	
	slider.setup('masterslider' , {
		 width:1400,    // slider standard width
		 height:800,   // slider standard height
		 space:0,
		 speed:45,
		 layout:'fillwidth',
		 loop:true,
		 preload:0,
		 autoplay:true,
		 view:"parallaxMask"
	});
	
	// scroll up arrow
	$(".scrollup").pageup();
	
	
	$('.map').click(function () {
		$('.map iframe').css("pointer-events", "auto");
	});
	
	// page pre loader
	$(document).on('ready', function() {
	
		$("#element").introLoader({
		
			animation: {
				name: 'cssLoader',
				options: {
					exitFx:'slideUp',
					ease: "easeOutSine",
					style: 'light',
					delayBefore: 450, //delay time in milliseconds
					exitTime: 360
				}
			}
		
		});
		
		// navigation collaspe in mobile view
		$('nav a').on('click', function () {

            if ($(".navbar-nav").is(":visible") ){ $(".navbar-nav").trigger("click"); } //bootstrap 2.x
            if ($(".navbar-toggle").is(":visible")) { $(".navbar-toggle").trigger("click"); } //bootstrap 3.x
        });
		
	
		

		
	
	});
	
})(jQuery);