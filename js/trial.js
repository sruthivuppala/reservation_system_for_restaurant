/**
 * Created by sruthi on 24-12-2015.
 */
var home_template,aboutus_template, menu_template, createreservation_template, editreservation_template, owner_template;
var cancelreservation_template, makereservation_success_template, loginsuccess_template;
var admin_reservationslist_template, admin_seatingarea_template, admin_createreservation_template;
var admin_editreservation_template, admin_cancelreservation_template;
var cheese_fondue_template, salads_template, individual_entrees_template, four_course_experience_template, chocolate_fondue_template;
var gluten_free_menu_template;

function showTemplate(template,data){
    var html    = template(data);
    $('#content').html(html);
}
function showAdminTemplate(template,data){

    var html    = template(data);
    $('#admin_content').html(html);
}

function showMenuTemplate(template,data){
    var html = template(data);
    $("#menu_content").html(html);
}

$(document).ready(function(){

    $(".drop_collapse").click(function(event) {
        $(".navbar-collapse").collapse('hide');
    });
    /*$(".navbar-nav li a").click(function(event) {
        $(".navbar-collapse").collapse('hide');
    });*/

    var source = $("#home-template").html();
    home_template = Handlebars.compile(source);

    var source = $("#aboutus-template").html();
    aboutus_template = Handlebars.compile(source);

    var source = $("#menu-template").html();
    menu_template = Handlebars.compile(source);

    // Handlebars for items under menu
    var source = $("#cheese_fondue-template").html();
    cheese_fondue_template = Handlebars.compile(source);

    var source = $("#salads-template").html();
    salads_template = Handlebars.compile(source);

    var source = $("#individual_entrees-template").html();
    individual_entrees_template = Handlebars.compile(source);

    var source = $("#four_course_experience-template").html();
    four_course_experience_template = Handlebars.compile(source);

    var source = $("#chocolate_fondue-template").html();
    chocolate_fondue_template = Handlebars.compile(source);

    var source = $("#gluten_free_menu-template").html();
    gluten_free_menu_template = Handlebars.compile(source);

    var source = $("#createreservation-template").html();
    createreservation_template = Handlebars.compile(source);

    var source = $("#editreservation-template").html();
    editreservation_template = Handlebars.compile(source);

    var source = $("#cancelreservation-template").html();
    cancelreservation_template = Handlebars.compile(source);

    var source = $("#loginsuccess-template").html();
    loginsuccess_template = Handlebars.compile(source);

    var source = $("#admin_reservationslist-template").html();
    admin_reservationslist_template = Handlebars.compile(source);

    var source = $("#admin_seatingarea-template").html();
    admin_seatingarea_template= Handlebars.compile(source);

    var source = $("#admin_createreservation-template").html();
    admin_createreservation_template= Handlebars.compile(source);

    var source = $("#admin_editreservation-template").html();
    admin_editreservation_template= Handlebars.compile(source);

    var source = $("#admin_cancelreservation-template").html();
    admin_cancelreservation_template= Handlebars.compile(source);

    var source = $("#owner-template").html();
    owner_template = Handlebars.compile(source);


    $("#home-tab").click(function(){
        showTemplate(home_template,data1);
    });

    $("#aboutus-tab").click(function(){
        showTemplate(aboutus_template,data1);
    });

    $("#menu-tab").click(function(){
        showTemplate(menu_template,data1);

        $("#cheese_fondue-tab").click(function(){
            showMenuTemplate(cheese_fondue_template,data1);
        });

        $("#salads-tab").click(function(){
            showMenuTemplate(salads_template,data1);
        });

        $("#individual_entrees-tab").click(function(){
            showMenuTemplate(individual_entrees_template,data1);
        });

        $("#four_course_experience-tab").click(function(){
            showMenuTemplate(four_course_experience_template,data1);
        });

        $("#chocolate_fondue-tab").click(function(){
            showMenuTemplate(chocolate_fondue_template,data1);
        });

        $("#gluten_free_menu-tab").click(function(){
            showMenuTemplate(gluten_free_menu_template,data1);
        });

        $("#cheese_fondue-tab").click();
    });

    $("#create_reservation-tab").click(function(){
        showTemplate(createreservation_template,data1);

        $("#submit_makereservation").onclick(function(){
                alert("Success");
        });
    });

    $("#edit_reservation-tab").click(function(){
        showTemplate(editreservation_template,data1);
    });

    $("#cancel_reservation-tab").click(function(){
        showTemplate(cancelreservation_template,data1);

        $("#submit_cancelreservation").click(function(){
            alert("Success");
        });
    });

    $("#owner-tab").click(function(){
        showTemplate(owner_template,data1);

        $("#login").click(function(){
            var username = document.getElementById("inputEmail").value;
            var password = document.getElementById("inputPassword").value;

            if(username=="admin@fonduefun.com" && password=="admin"){
                showTemplate(loginsuccess_template,data1);

                $(".navbar-nav li a").click(function(event) {
                    $(".navbar-collapse").collapse('hide');
                });

                $("#admin_reservationslist-tab").click(function(){
                    showAdminTemplate(admin_reservationslist_template,data1);
                });
                $("#admin_seatingarea-tab").click(function(){
                    showAdminTemplate(admin_seatingarea_template,data1);
                });
                $("#admin_createreservation-tab").click(function(){
                    showAdminTemplate(createreservation_template,data1);
                });
                $("#admin_editreservation-tab").click(function(){
                    showAdminTemplate(editreservation_template,data1);
                });
                $("#admin_cancelreservation-tab").click(function(){
                    showAdminTemplate(cancelreservation_template,data1);
                });
                $("#admin_reservationslist-tab").click();
            }
            else{
                alert("Login unsuccesful");
            }
        });
    });

    $("#home-tab").click();
});
