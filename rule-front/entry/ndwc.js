import Vue from 'vue'

import 'normalize.css/normalize.css' // A modern alternative to CSS resets

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import locale from 'element-ui/lib/locale/lang/zh-CN'// lang i18n
// import '@/styles/index.scss' // global css
import draggable from 'vuedraggable'
import underscore from 'vue-underscore'
import App from '../src/pages/ndwc/ndwc.vue';
Vue.config.productionTip = false;
Vue.use(ElementUI, { locale },draggable,underscore)
new Vue({ 
  
  render: h => h(App) }).$mount('#ndwc'); 