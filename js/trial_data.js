/**
 * Created by sruthi on 24-12-2015.
 */

var data1={ restaurantName : "Fondue Fun", restaurantLocation : "USA"};

Handlebars.registerHelper('submit_makereservation', function() {
    //var emotion = Handlebars.escapeExpression(this.emotion),
      //  name = Handlebars.escapeExpression(this.name);

    return new Handlebars.SafeString(
        "<input type='button' id='submit_makereservation' class='btn btn-info' value='Submit' />"
    );
});

Handlebars.registerHelper('submit_cancelreservation', function() {
    //var emotion = Handlebars.escapeExpression(this.emotion),
    //  name = Handlebars.escapeExpression(this.name);

    return new Handlebars.SafeString(
        "<input type='button' id='submit_cancelreservation' class='btn btn-info' value='Submit' />"
    );
});

Handlebars.registerHelper('login', function() {
    //var emotion = Handlebars.escapeExpression(this.emotion),
    //  name = Handlebars.escapeExpression(this.name);

    return new Handlebars.SafeString(
        "<button type='submit' class='btn btn-primary' id='login'>Login</button>"
    );
});

Handlebars.registerHelper('img_insert', function() {
    //var current_src = Handlebars.escapeExpression(this.source);
    //  name = Handlebars.escapeExpression(this.name);

    return new Handlebars.SafeString(
        "<img src='images/round_table_for_4.PNG' id='img1' width='200px' height='200px'/> &nbsp" +
        "<img src='images/round_table_for_6.PNG' id='img2' width='200px' height='200px'/> &nbsp" +
        "<img src='images/round_table_for_8.PNG' id='img2' width='200px' height='200px'/> &nbsp"
    );
});

Handlebars.registerHelper('img_insert_rectangular', function() {
    //var current_src = Handlebars.escapeExpression(this.source);
    //  name = Handlebars.escapeExpression(this.name);

    return new Handlebars.SafeString(
        "<img src='images/table_2.PNG' id='img1' width='200px' height='200px'/> &nbsp" +
        "<img src='images/table_4.PNG' id='img2' width='200px' height='200px'/> &nbsp" +
        "<img src='images/table_6.PNG' id='img2' width='200px' height='200px'/> &nbsp"
    );
});

Handlebars.registerHelper('cheese_fondue', function() {
    //var current_src = Handlebars.escapeExpression(this.source);
    //  name = Handlebars.escapeExpression(this.name);

    return new Handlebars.SafeString(
        "<a href='#' id='cheese_fondue-tab'>CHEESE FONDUE</a>"
    );
});

Handlebars.registerHelper('salads', function() {
    //var current_src = Handlebars.escapeExpression(this.source);
    //  name = Handlebars.escapeExpression(this.name);

    return new Handlebars.SafeString(
        "<a href='#' id='salads-tab'>SALADS</a>"
    );
});

Handlebars.registerHelper('individual_entrees', function() {
    return new Handlebars.SafeString(
        "<a href='#' id='individual_entrees-tab'>INDIVIDUAL ENTREES</a>"
    );
});

Handlebars.registerHelper('four_course_experience', function() {
    return new Handlebars.SafeString(
        "<a href='#' id='four_course_experience-tab'>4-COURSE EXPERIENCE</a>"
    );
});

Handlebars.registerHelper('chocolate_fondue', function() {
    return new Handlebars.SafeString(
        "<a href='#' id='chocolate_fondue-tab'>CHOCOLATE FONDUE</a>"
    );
});

Handlebars.registerHelper('gluten_free_menu', function() {
    return new Handlebars.SafeString(
        "<a href='#' id='gluten_free_menu-tab'>GLUTEN-FREE MENU</a>"
    );
});

