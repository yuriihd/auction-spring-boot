/**
 * Created by Yurii on 02.04.2017.
 */



app.controller('lotController', function ($rootScope, $scope, $location,$http) {

        var url = 'http://localhost:8060';

        $scope.lots=[];

        $scope.name = undefined;
        $scope.topic = undefined;
        $scope.description = undefined;
        $scope.price = undefined;
        $scope.endDate = undefined;

        $scope.canProceed = true;

        $http.get(url+'/lots').success(function (data) {
        $scope.lots=data;
        })


        // $scope.removeTask = function (id) {
        //     problemService.removeTask(id)
        // };


        $scope.addLot = function () {

            /*Need to know current username : */
            $http.get(url + '/currentUser').then(function (response) {
                console.log(response);
                $scope.showUser = true;
                $scope.user = response.data;
            });
            return $http.post(url+'/'+$scope.user.username+'/addLot',
                {
                name: $scope.name,
                topic: $scope.topic,
                description : $scope.description,
                price : $scope.price,
                endDate : $scope.endDate
                })
                .then(function (response) {
                $location.path("/allLots");
            }).catch(function (response) {
                $scope.canProceed = false;
            })
            };



        // $scope.editMode = false;
        // $scope.searchable = undefined;
        //
        // $scope.search = function (searchable) {
        //     problemService.searchForTask(searchable).then(function (response) {
        //             $scope.tasks = response.data;
        //             if($scope.tasks.length == 0)
        //                 $scope.message = "EMPTY";
        //         },
        //         function () {
        //             problemService.getTasks().then(function (response){
        //                 $scope.tasks = response.data;
        //             });
        //         })
        // };
        //
        // $scope.updateTask = function (task) {
        //     problemService.updateTask(task.id, task.name, task.level, task.maxScore, task.description);
        // };
        //
        // $scope.changeEditMode = function () {
        //     $scope.editMode = !$scope.editMode;
        // }
    });

