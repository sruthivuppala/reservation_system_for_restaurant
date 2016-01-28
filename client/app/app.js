(function(){
    'use strict';

    angular.module('restaurant',['ui.router'])
        .config(moduleConfig);

    moduleConfig.$inject = ['$stateProvider','$urlRouterProvider'];
    function moduleConfig($stateProvider, $urlRouterProvider) {

            $stateProvider

                .state('app',{
                    url:'/',
                    views:{
                        'header':{
                            templateUrl:"app/views/header.html"
                        },
                        'content':{
                            templateUrl: 'app/views/home.tmpl.html'
                        },
                        'subcontent':{
                            template: ''
                        },
                        'footer':{
                            templateUrl: 'app/views/footer.html'
                        }
                    }
                })
                .state('app.aboutus',{
                    url:'aboutus',
                    views:{
                        'content@':{
                            templateUrl: 'app/views/aboutus.tmpl.html'
                        }
                    }
                })
                .state('app.menu',{
                    url:'menu',
                    views:{
                        'content@':{
                            templateUrl: 'app/views/menu.tmpl.html'
                        },
                        'subcontent@':{
                            templateUrl: 'app/views/cheese_fondue.tmpl.html'
                        }
                    }
                })
                .state('app.menu.salads',{
                    url:'menu/salads',
                    views:{
                        'content@':{
                            templateUrl: 'app/views/menu.tmpl.html'
                        },
                        'subcontent@':{
                            templateUrl: 'app/views/salads.tmpl.html'
                        }
                    }
                })
                .state('app.menu.individual_entrees',{
                    url:'menu/individual_entrees',
                    views:{
                        'content@':{
                            templateUrl: 'app/views/menu.tmpl.html'
                        },
                        'subcontent@':{
                            templateUrl: 'app/views/individual_entrees.tmpl.html'
                        }
                    }
                })
                .state('app.menu.four_course_experience',{
                    url:'menu/four_course_experience',
                    views:{
                        'content@':{
                            templateUrl: 'app/views/menu.tmpl.html'
                        },
                        'subcontent@':{
                            templateUrl: 'app/views/four_course_experience.tmpl.html'
                        }
                    }
                })
                .state('app.menu.chocolate_fondue',{
                    url:'menu/chocolate_fondue',
                    views:{
                        'content@':{
                            templateUrl: 'app/views/menu.tmpl.html'
                        },
                        'subcontent@':{
                            templateUrl: 'app/views/chocolate_fondue.tmpl.html'
                        }
                    }
                })
                .state('app.menu.gluten_free_menu',{
                    url:'menu/gluten_free_menu',
                    views:{
                        'content@':{
                            templateUrl: 'app/views/menu.tmpl.html'
                        },
                        'subcontent@':{
                            templateUrl: 'app/views/gluten_free_menu.tmpl.html'
                        }
                    }
                })
                .state('app.createReservation',{
                    url:'makereservation',
                    views:{
                        'content@':{
                            templateUrl: 'app/views/createReservation.tmpl.html',
                            controller: 'CreateReservation',
                            controllerAs: 'createR'
                        }
                    }
                })
                /*.state('app.createReservation.submitting',{
                    url:'submitting',
                    views:{
                        'content@':{
                            templateUrl: 'views/createdReservation.tmpl.html',
                            controller: 'CreateReservation',
                            controllerAs: 'createR'
                        }
                    }
                })*/
                .state('app.editReservation',{
                    url:'editreservation',
                    views:{
                        'content@':{
                            templateUrl: 'app/views/editReservation.tmpl.html'
                        }
                    }
                })
                .state('app.cancelReservation',{
                    url:'cancelreservation',
                    views:{
                        'content@':{
                            templateUrl: 'app/views/cancelReservation.tmpl.html',
                            controller: 'CancelReservation',
                            controllerAs: 'cancelR'
                        }
                    }
                })
                .state('app.owner',{
                    url:'admin',
                    views:{
                        'content@':{
                            templateUrl: 'app/views/owner.tmpl.html',
                            controller: 'OwnerController',
                            controllerAs: 'owner'
                        }
                    }
                })
                .state('app.owner.viewReservations',{
                    url:'/viewReservations',
                    views:{
                        'content@':{
                            templateUrl: 'app/views/loginsuccess.tmpl.html'
                        },
                        'subcontent@':{
                            templateUrl: 'app/views/viewReservations.tmpl.html',
                            controller: 'ViewReservation',
                            controllerAs: 'viewRC'
                        }
                    }
                })
                .state('app.owner.reservationDetails',{
                    url:'/reservationDetails/:id',
                    views:{
                        'content@':{
                            templateUrl: 'app/views/loginsuccess.tmpl.html'
                        },
                        'subcontent@':{
                            templateUrl: 'app/views/reservation-detail.tmpl.html',
                            controller: 'ReservationDetail',
                            controllerAs: 'rDetail'
                        }
                    }
                })
                .state('app.owner.seatingArea',{
                    url:'/seatingArea',
                    views:{
                        'content@':{
                            templateUrl: 'app/views/loginsuccess.tmpl.html'
                        },
                        'subcontent@':{
                            templateUrl: 'app/views/seatingarea.tmpl.html'
                        }
                    }
                })
                .state('app.owner.createReservation',{
                    url:'/createReservation',
                    views:{
                        'content@':{
                            templateUrl: 'app/views/loginsuccess.tmpl.html'
                        },
                        'subcontent@':{
                            templateUrl: 'app/views/createReservation.tmpl.html',
                            controller: 'CreateReservation',
                            controllerAs: 'createR'
                        }
                    }
                })
                .state('app.owner.editReservation',{
                    url:'/editReservation',
                    views:{
                        'content@':{
                            templateUrl: 'app/views/loginsuccess.tmpl.html'
                        },
                        'subcontent@':{
                            templateUrl: 'app/views/editReservation.tmpl.html',
                        }
                    }
                })
                .state('app.owner.cancelReservation',{
                    url:'/cancelReservation',
                    views:{
                        'content@':{
                            templateUrl: 'app/views/loginsuccess.tmpl.html',
                            controller: 'CancelReservation',
                            controllerAs: 'cancelR'
                        },
                        'subcontent@':{
                            templateUrl: 'app/views/cancelReservation.tmpl.html',
                        }
                    }
                })
            ;
            $urlRouterProvider.otherwise('/');
        }
})();