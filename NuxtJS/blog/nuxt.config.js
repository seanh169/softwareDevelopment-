export default {
  // Global page headers (https://go.nuxtjs.dev/config-head)
  head: {
    title: 'blog',
    meta: [
      { charset: 'utf-8' },
      { name: 'viewport', content: 'width=device-width, initial-scale=1' },
      { hid: 'description', name: 'description', content: '' }
    ],
    link: [
      { rel: 'icon', type: 'image/x-icon', href: '/favicon.ico' },
      { rel: 'style-sheet', href: "https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&display=swap"}
    ]
  },

  loading: { color: '#333333', throttle: 0 },
  
  // Global CSS (https://go.nuxtjs.dev/config-css)
  css: [
    '~/assets/styles/main.css'
  ],

  // Plugins to run before rendering page (https://go.nuxtjs.dev/config-plugins)
  plugins: [
    '~plugins/core-components.js',
    '~plugins/date-filter.js'
  ],

  // Auto import components (https://go.nuxtjs.dev/config-components)
  components: true,

  // Modules for dev and build (recommended) (https://go.nuxtjs.dev/config-modules)
  buildModules: [
  ],

  // Modules (https://go.nuxtjs.dev/config-modules)
  modules: [
    '@nuxtjs/axios',
  ],
  axios: {
    baseURL: 'https://nuxt-blog-385b3-default-rtdb.firebaseio.com'
  },

  // Build Configuration (https://go.nuxtjs.dev/config-build)
  build: {

  },
  env: {
    baseURL: 'https://nuxt-blog-385b3-default-rtdb.firebaseio.com',
    fpAPIKey: 'AIzaSyC_RIFvlfOrkWKAqyCFEahbvPCfD2Dmb9M'
  },
  router: {
    middleware : 'log'
    // extendRouts(routes, resolve) {
    //   routes.push({
    //     // name: 'custom',
    //     path: '*',
    //     component: resolve(__dirname, 'pages/index.vue')
    //   })
    // }
  },
  transition: {
    name: 'fade',
    mode: 'out-in'
  }
}
