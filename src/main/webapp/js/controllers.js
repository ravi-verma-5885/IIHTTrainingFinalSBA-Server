angular.module('projectApp.controllers', []).controller('UserListController',
		function($scope, $state, $stateParams, $window, User) {
			$scope.user = new User(); 

			$scope.addUser = function() { 
				$scope.user.$save(function() {
					$state.go('users'); 
				});
			};
			
			$scope.users = User.query();
		}).controller('UserDeleteController',
		function($scope, $state, $stateParams, User) {
			$scope.user = User.delete({
				id : $stateParams.id
			}); 
			$scope.users = User.query();
		}).controller('UserViewController',
		function($scope, $stateParams, User) {
			$scope.user = User.get({
				id : $stateParams.id
			}); 
		}).controller('UserCreateController',
		function($scope, $state, $stateParams, User) {
			$scope.user = new User(); 

			$scope.addUser = function() { 
				$scope.user.$save(function() {
					$state.go('users'); 
				});
			};
		}).controller('UserEditController',
		function($scope, $state, $stateParams, User) {
			$scope.updateUser = function() { 
				$scope.user.$update(function() {
					$state.go('users'); 
				});
			};

			$scope.loadUser = function() {
				$scope.user = User.get({
					id : $stateParams.id
				});
			};

			$scope.loadUser();
		}).controller('ProjectListController',
		function($scope, $state, $stateParams, $window, User) {
			$scope.users = User.query(); 
			
			
		});