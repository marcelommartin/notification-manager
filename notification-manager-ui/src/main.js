// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

import firebase from "firebase";

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App }
})

var config = {
  apiKey: "AIzaSyAmkmjZgfQtn5ZzzvCJ02OZkvI9Bln3mvo",
  authDomain: "notification-manager-a274c.firebaseapp.com",
  databaseURL: "https://notification-manager-a274c.firebaseio.com",
  projectId: "notification-manager-a274c",
  storageBucket: "notification-manager-a274c.appspot.com",
  messagingSenderId: "585354264066"
};
firebase.initializeApp(config);
