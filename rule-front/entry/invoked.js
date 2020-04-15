import Vue from 'vue';
import App from '../src/pages/invoked/invoked.vue';
Vue.config.productionTip = false;
new Vue({ render: h => h(App) }).$mount('#invoked'); 