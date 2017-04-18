/**
 * Created by Yurii on 11.04.2017.
 */
var app = angular.module('app', ['ngRoute','ngResource']);
app.config(function($routeProvider){
    $routeProvider
        .when('/home',{
            templateUrl: 'views/home.html',
            controller: 'lotController'
        })
        .when('/login',{
            templateUrl: 'views/login.html',
            controller: 'loginController'
        })
        .when('/signUp',{
            templateUrl: 'views/signup.html',
            controller: 'loginController'
        })
        .when('/allLots',{
            templateUrl: 'views/allLots.html',
            controller: 'lotController'
        })
        .when('/addLot', {
            templateUrl: 'views/addlot.html',
            controller: 'lotController'
        })
        .when('/myLots', {
            templateUrl: 'views/myLots.html',
            controller: 'myLotController'
        })
        .when('/profile', {
            templateUrl: 'views/profile.html',
            controller: 'profileController'
        })
        // .when('/problems', {
        //     templateUrl: 'views/problems.html',
        //     controller: 'problemController'
        // })
        // .when('/problem/:id', {
        //     templateUrl: 'views/problem.html',
        //     controller: 'problemController'
        // })
        // .when('/createProblem', {
        //     templateUrl: 'views/createProblem.html',
        //     controller: 'problemController'
        // })
        // .when("/signUp", {
        //     templateUrl: 'views/sign_up.html',
        //     controller: 'loginController'
        // })
        // .when('/profile', {
        //     templateUrl: 'views/profile.html',
        //     controller: 'profileController'
        // })
        .otherwise(
            { redirectTo: '/home'}
        );
}).controller("MainController", ['$scope','$http', function($scope, $http) {
    var url = "http://localhost:8060";


    $scope.user = undefined;
    $scope.showUser = false;

    $http.get(url + '/currentUser').then(function (response) {
        console.log(response);
        $scope.showUser = true;
        $scope.user = response.data;
    });




    $scope.logOut = function () {
        $http.post(url + '/logout').then(function (response) {
            $scope.showUser = false;
            $scope.user = undefined;
        })
    }


}]);

