export default function (context) {
    console.log('[Check Auth] Middlware is running');
        context.store.dispatch('initAuth', context.req);
    
 }