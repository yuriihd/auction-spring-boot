/**
 * Created by Yurii on 02.04.2017.
 */
var app = angular.module("Auction",[]);
app.controller("LotController",function ($scope,$http ) {
    $scope.lots=[];

    $http.get('http://localhost:8070/lots').success(function (data) {
        $scope.lots=data;
    })

})