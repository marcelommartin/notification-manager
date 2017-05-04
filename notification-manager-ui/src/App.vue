<template>
  <div id="app">
 
  </div>
</template>

<script>
export default {
  name: 'app'
}

import Firebase from 'firebase'

let config = {
    apiKey: "AIzaSyAmkmjZgfQtn5ZzzvCJ02OZkvI9Bln3mvo",
    authDomain: "notification-manager-a274c.firebaseapp.com",
    databaseURL: "https://notification-manager-a274c.firebaseio.com",
    projectId: "notification-manager-a274c",
    storageBucket: "notification-manager-a274c.appspot.com",
    messagingSenderId: "585354264066"
  };
  
let app = Firebase.initializeApp(config)
let db = app.database()

</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
