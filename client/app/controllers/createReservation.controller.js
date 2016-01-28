/**
 * Created by vsrut on 26-01-2016.
 */

'use strict';

angular
    .module('restaurant')
    .controller('CreateReservation',CreateReservation);

 CreateReservation.$inject = ['dataService'];

 function CreateReservation(dataService){

     var createR = this;

     createR.cid=0;

     createR.addReservation = function(){

         createR.successful = false;
         dataService
             .addBooking(createR)
             .then(function(data){
                 createR.reservation_ID = data.reservation_ID;
                 console.log("Function executed"+createR.reservation_ID);
             }, function (error){
                 console.log(error);
             })
         createR.successful = true;

     }

 }