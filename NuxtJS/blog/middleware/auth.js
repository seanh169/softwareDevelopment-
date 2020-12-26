export default function (context) {
    console.log('[Auth] Middlware is running');
    if(!context.store.getters.isAuthenticated){
        context.redirect('/admin/auth')
    }
 }