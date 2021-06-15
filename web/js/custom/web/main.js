
    $(document).ready(function() {
        $('.box_skitter_large').skitter({
            numbers            : false,
            interval           : 2000,
            navigation         : true,
            label              : true,
            show_randomly      : false,
            hideTools          : false,
            fullscreen         : false,
            thumbs             : false,
            dots               : false,
            preview            : false,
            focus              : true,
            focus_position     : 'center',
            controls           : true,
            controls_position  : 'rightBottom'
            /*
             *velocity           : 2,
             *easing_default     : 'easeOutBack',
             *width_label        : '300px',
             *animation          : 'fade',
             */
        });
    });