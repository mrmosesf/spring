/**
 * Created by Moses Franco on 6/27/17
 * Codeup
 * Pinnacles
 */

(function ($) {

    var request = $.ajax({
        url: "/posts.json"
    });

    request.done(function (posts) {
        var html = "";
        var $posts = $("#posts");
        posts.forEach(function (post) {
            html += "<div>";
            html += "<h1>" + post.title + "</h1>";
            html += "<h2>" + post.text + "</h2>";
            html += "<h3>" + post.user.username + "</h3>";
            html += "<hr>";
            html += "</div>";
        });


        $posts.append(html);

    });
})(jQuery);