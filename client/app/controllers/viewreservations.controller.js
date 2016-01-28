/**
 * Created by vsrut on 19-01-2016.
 */
(function() {
    'use strict';

    angular
        .module('restaurant')
        .controller('ViewReservation', ViewReservation);

    ViewReservation.$inject =['dataService'];

    function ViewReservation(dataService){
        var viewRC = this;

        viewRC.reservations = [];

        dataService
            .getReservations()
            .then(function(data){
                viewRC.reservations = data;
            },function(error){
                console.log(error);
            });
    }
})();/**
 * Created by vsrut on 27-01-2016.
 */
