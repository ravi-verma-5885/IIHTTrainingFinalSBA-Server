angular.module('projectApp', [ 'ui.router', 'ngResource', 'projectApp.controllers',
		'projectApp.services' ]);

angular.module('projectApp').config(function($stateProvider) {
	$stateProvider.state('users', { // state for showing all users
		url : '/users',
		templateUrl : 'pages/users/users.html',
		controller : 'UserListController'
	}).state('viewUser', { // state for showing single user
		url : '/users/:id/view',
		templateUrl : 'pages/users/users.html',
		controller : 'UserViewController'
	}).state('deleteUser', { // state for showing single user
		url : '/users/:id/delete',
		templateUrl : 'pages/users/users.html',
		controller : 'UserDeleteController'
	}).state('/addUser', { // state for adding a new user
		url : '/users',
		templateUrl : 'pages/users/users.html',
		controller : 'UserCreateController'
	}).state('editUser', { // state for updating a user
		url : '/users/:id/edit',
		templateUrl : 'pages/users/users.html',
		controller : 'UserEditController'
	}).state('projects', { // state for updating a user
		url : '/projects',
		templateUrl : 'pages/projects/projects.html',
		controller : 'ProjectListController'
	}).state('tasks', { // state for updating a user
		url : '/tasks',
		templateUrl : 'pages/tasks/tasks.html',
		controller : 'ProjectListController'
	}).state('viewTasks', { // state for updating a user
		url : '/viewTasks',
		templateUrl : 'pages/tasks/viewTasks.html',
		controller : 'ProjectListController'
	});
});