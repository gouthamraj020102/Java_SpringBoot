console.log("This is script file")

const toggleSidebar=()=>{
    if ($(".sidebar").is(":visible")) {
        // true (we need to close)
        $(".sidebar").css("display", "none");
        $(".content").css("margin-left", "0%");
    }
    else {
        // false (we need to open sidebar)
        $(".sidebar").css("display", "block");
        $(".content").css("margin-left", "20%");
    }
};