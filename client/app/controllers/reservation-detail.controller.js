/**
 * Created by vsrut on 20-01-2016.
 */
    'use strict';

    angular
        .module('restaurant')
        .controller('ReservationDetail',ReservationDetail);

    ReservationDetail.$inject = ['dataService', '$stateParams'];

    function ReservationDetail(dataService, $stateParams) {
        var rDetail = this;

        rDetail.detail = null;

        dataService
            .getUserById($stateParams.id)
            .then(function(data){
                rDetail.detail = data;
            }, function (error){
                console.log(error);
            })

        console.log('ReservationDetail');
    }