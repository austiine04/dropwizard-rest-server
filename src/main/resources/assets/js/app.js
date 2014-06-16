var app = angular.module('restaurant', []);

app.service('MenuItemsService', function ($http) {

    return {
        fetchMenuItems:  function () {
            return $http.get('/api/menu_items');
        }
    }
});

app.controller('MenuItemsController', function ($scope, MenuItemsService) {

    MenuItemsService.fetchMenuItems().then(function (response) {
        $scope.menuItems = response.data;
    });

});