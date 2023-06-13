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

const search=()=>{
    let query = $("#search-input").val();

    if(query=='') {
        $(".search-result").hide();
    }
    else {
        console.log(query);
        let url = `http://localhost:9098/search/${query}`;

        fetch(url).then( (response) => {
            return response.json();
        })
        .then((data) => {
            // console.log(data);
            let text=`<div class='list-group'>`;

            data.forEach((contact) => {
                text+=`<a href='/user/${contact.cId}/contact' class='list-group-item list-group-item-action'>${contact.name}</a>`
            })
            text+=`</div`;
            $(".search-result").html(text);
            $(".search-result").show();
        })
    }
};