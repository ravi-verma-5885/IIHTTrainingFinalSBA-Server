angular.module('projectApp.services', []).factory('User', function($resource) {
  return $resource('http://localhost:8044/users/:id', { id: '@_id' }, {
    update: {
      method: 'PUT'
    }
  });
});