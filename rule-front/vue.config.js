'use strict'
const path = require('path')
const defaultSettings = require('./src/settings.js')
const fs = require('fs');
const glob = require('glob');
function resolve(dir) {
  return path.join(__dirname, dir)
}

const name = defaultSettings.title || 'vue Element Admin' // page title



function getPages() {
  const pages = {};
  const pagesJson = require('./config/page.json');

  glob.sync('./src/pages/**/*.vue').forEach(function (pageUrl) {
    const ext = path.extname(pageUrl);
    const pageCode = path.basename(pageUrl, ext);
    // 文件名不能重复的验证（pageCode 在这里取的是文件名）
    if(pages[pageCode]){
      // console.error(colors('red', `文件名不能重复使用：${pageCode}。\n`));
      process.exit(1);
    }
    // 生成入口文件
    const entryFile = `./entry/${pageCode}.js`;
    fs.exists(entryFile, function (exists) {      // 这里没有对文件目录进行判断，所以需要先建一个'entry'文件夹，否则会报错
      if(exists) return;
      // 创建文件及写入文件内容
      const appTpl = '.' + pageUrl;
      const entryData = `import Vue from 'vue';\nimport App from '${appTpl}';\nVue.config.productionTip = false;\nnew Vue({ render: h => h(App) }).$mount('#${pageCode}'); `;
      fs.writeFile(entryFile, entryData, function(err){
        // err.code === 'ENOENT'
        if(err) console.log(err);
      });
    });
    // 自定义页面数据
    const pageData = pagesJson[pageCode] || {};
    console.log(JSON.stringify(pageData))
    Object.assign(pageData, {
      url: pageUrl,
      code: pageCode
    });
    // 配置多页面
    pages[pageCode] = {
      entry: entryFile,               // 入口文件
      template: './public/index.html',// 模板文件
      filename: pageCode + '.html',   // 打包后的文件路径
      minify: false,                  // 是否压缩
      chunks: ['chunk-vendors', 'chunk-common', 'app', pageCode],   // 引入资源文件
      chunksSortMode: 'manual',       // 控制 chunk 的排序。none | auto（默认）| dependency（依赖）| manual（手动）| {function}
      pageData: pageData
    };
  });
  return pages;
}

const pagesObject = Object.assign(getPages(), {
  app: './src/main.js'    // 配置主入口文件（会生成 app.html，vue cli3并没有提供直接配置入口文件的选项）
})


// If your port is set to 80,
// use administrator privileges to execute the command line.
// For example, Mac: sudo npm run
// You can change the port by the following method:
// port = 9527 npm run dev OR npm run dev --port = 9527
const port = process.env.port || process.env.npm_config_port || 9527 // dev port

// All configuration item explanations can be find in https://cli.vuejs.org/config/
module.exports = {

  pages: Object.assign(getPages(), {
    app: './src/main.js'    // 配置主入口文件（会生成 app.html，vue cli3并没有提供直接配置入口文件的选项）
  }),

  /**
   * You will need to set publicPath if you plan to deploy your site under a sub path,
   * for example GitHub Pages. If you plan to deploy your site to https://foo.github.io/bar/,
   * then publicPath should be set to "/bar/".
   * In most cases please use '/' !!!
   * Detail: https://cli.vuejs.org/config/#publicpath
   */
  publicPath: './',
  outputDir: 'dist',
  assetsDir: 'static',
  lintOnSave: false,
  productionSourceMap: false,
  devServer: {
    port: port,
    open: true,
    proxy: {
      '/rule': {
        target: 'http://localhost:8081/rule/',
        pathRewrite: {
          '^/rule': ''
        },
        changeOrigin: true
      }
    },
    overlay: {
      warnings: false,
      errors: true
    }
    // before: require('./mock/mock-server.js')
  },
  configureWebpack: {
    // provide the app's title in webpack's name field, so that
    // it can be accessed in index.html to inject the correct title.
    name: name,
    resolve: {
      alias: {
        '@': resolve('src')
      }
    }
  },
  chainWebpack(config) {
    config.plugins.delete('preload') // TODO: need test
    config.plugins.delete('prefetch') // TODO: need test

    // set svg-sprite-loader
    config.module
      .rule('svg')
      .exclude.add(resolve('src/icons'))
      .end()
    config.module
      .rule('icons')
      .test(/\.svg$/)
      .include.add(resolve('src/icons'))
      .end()
      .use('svg-sprite-loader')
      .loader('svg-sprite-loader')
      .options({
        symbolId: 'icon-[name]'
      })
      .end()

    // set preserveWhitespace
    // config.module
    //   .rule('vue')
    //   .use('vue-loader')
    //   .loader('vue-loader')
    //   .tap(options => {
    //     options.compilerOptions.preserveWhitespace = true
    //     return options
    //   })
    //   .end()

    // config
    //   // https://webpack.js.org/configuration/devtool/#development
    //   .when(process.env.NODE_ENV === 'development',
    //     config => config.devtool('cheap-source-map')
    //   )

    // config
    //   .when(process.env.NODE_ENV !== 'development',
    //     config => {
    //       config
    //         .plugin('ScriptExtHtmlWebpackPlugin')
    //         .after('html')
    //         .use('script-ext-html-webpack-plugin', [{
    //         // `runtime` must same as runtimeChunk name. default is `runtime`
    //           inline: /runtime\..*\.js$/
    //         }])
    //         .end()
    //       config
    //         .optimization.splitChunks({
    //           chunks: 'all',
    //           cacheGroups: {
    //             libs: {
    //               name: 'chunk-libs',
    //               test: /[\\/]node_modules[\\/]/,
    //               priority: 10,
    //               chunks: 'initial' // only package third parties that are initially dependent
    //             },
    //             elementUI: {
    //               name: 'chunk-elementUI', // split elementUI into a single package
    //               priority: 20, // the weight needs to be larger than libs and app or it will be packaged into libs or app
    //               test: /[\\/]node_modules[\\/]_?element-ui(.*)/ // in order to adapt to cnpm
    //             },
    //             commons: {
    //               name: 'chunk-commons',
    //               test: resolve('src/components'), // can customize your rules
    //               minChunks: 3, //  minimum common number
    //               priority: 5,
    //               reuseExistingChunk: true
    //             }
    //           }
    //         })
    //       config.optimization.runtimeChunk('single')
    //     }
    //   )

    Object.keys(pagesObject).forEach(page => {
      config.plugins.delete(`preload-${page}`)
      config.plugins.delete(`prefetch-${page}`)
    })
  }
}
