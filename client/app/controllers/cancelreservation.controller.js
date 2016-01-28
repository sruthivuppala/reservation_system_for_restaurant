/**
 * Created by vsrut on 27-01-2016.
 */

'use strict';

angular
    .module('restaurant')
    .controller('CancelReservation',CancelReservation);

CancelReservation.$inject = ['dataService'];

function CancelReservation(dataService){

    var cancelR = this;


    cancelR.cancelReservation = function(){

        cancelR.cancelsuccess = false;

        console.log(cancelR.reservation_ID);

        dataService
            .cancelBooking(cancelR.reservation_ID)
            .then(function(data){
                cancelR.reservation_ID = data;
            }, function (error){
                console.log(error);
            })

        cancelR.cancelsuccess = true;

        console.log(cancelR);

    }

}
