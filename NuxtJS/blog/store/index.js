import Vuex from 'vuex';
import Cookie from 'js-cookie';

const createStore = () => {
    return new Vuex.Store(
        {
            state: {
                loadedPosts: [],
                token: null
            },
            mutations: {
                setPosts(state, posts){
                    state.loadedPosts = posts;
                },
                addPost(state, post){
                    state.loadedPosts.push(post);
                },
                editPost(state, editedPost){
                    const newLoadedPosts = [...state.loadedPosts];
                    const postIndex = newLoadedPosts.findIndex(i=>i.id === editedPost.id);
                    newLoadedPosts[postIndex] = editedPost;
                    state.loadedPosts = newLoadedPosts;
                },
                setToken(state, token){
                    // console.log(token);
                    state.token = token;
                },
                clearToken(state){
                    state.token = null;
                }
            },
            actions: {
                async nuxtServerInit(vuexContext, context){
                    try{
                        const getPosts = await context.app.$axios.$get('/posts.json');
                        // 
                        const postsArr = [];
                       for(let key in getPosts){
                            postsArr.push({...getPosts[key], id: key});
                       }
                       vuexContext.commit('setPosts', postsArr);
                    }catch(e){
                        console.log(e);
                    }  
                },
                setPosts(vuexContext, posts) {
                    vuexContext.commit('setPosts', posts)
                },
                async authenticateUser(vuexContext, authData){
                    // console.log('[authenticateUser], got here');
                    // console.log(authData);
                    let authURL = 'https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=AIzaSyC_RIFvlfOrkWKAqyCFEahbvPCfD2Dmb9M';
                    if(authData.isLogin){
                    authURL = 'https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyC_RIFvlfOrkWKAqyCFEahbvPCfD2Dmb9M';
                    }
                    const signInUser = await this.$axios.$post(authURL, {
                        email: authData.email,
                        password: authData.password,
                        returnSecureToken: true
                    })
                    vuexContext.commit('setToken', signInUser.idToken);
                    localStorage.setItem('token', signInUser.idToken);
                    localStorage.setItem('tokenExpiration', new Date().getTime() +  Number.parseInt(signInUser.expiresIn) * 1000);
                    Cookie.set('jwt', signInUser.idToken);
                    Cookie.set('expirationDate', new Date().getTime() +  Number.parseInt(signInUser.expiresIn) * 1000);
                    // vuexContext.dispatch('setLogoutTimer', signInUser.expiresIn * 1000);
                    return signInUser;
                },
                initAuth(vuexContext, req){
                    // console.log('[initAuth], got here');
                    let token;
                    let expirationDate;
                    if (req){
                        if(!req.headers.cookie){
                            return
                        }
                        const jwtCookie = req.headers.cookie.split(';').find(i => i.trim().startsWith('jwt='));
                        if(!jwtCookie) {
                            return;
                        }
                         token = jwtCookie.split('=')[1];
                         expirationDate = req.headers.cookie.split(';').find(i => i.trim().startsWith('expirationDate=')).split('=')[1];
                    }else{
                         token = localStorage.getItem("token");
                         expirationDate = localStorage.getItem('tokenExpiration');

                        
                    }
                    if(new Date().getTime() > +expirationDate || !token){
                        vuexContext.dipatch('logout');
                        return;
                    }
                    // vuexContext.dispatch('setLogoutTimer', expirationDate - new Date())
                    vuexContext.commit('setToken', token);
                },
                async addPost(vuexContext, post){
                    try{
                        const createPost = await this.$axios.$post('/posts.json?auth=' + vuexContext.state.token, post);
                        vuexContext.commit('addPost', {...post, id: createPost.name})
                        return createPost;
                      }catch(e){
                        console.log(e)
                      }       
                },
                async editPost(vuexContext, editedPost){
                    try{
                        const updatedPost = await this.$axios.$put('/posts/' + editedPost.id + ".json?auth=" + vuexContext.state.token, editedPost.postData);
                        vuexContext.commit('editPost', {...editedPost.postData, id: editedPost.id})
                        return updatedPost;
                    }catch(e){
                        console.log(e)
                    }
                },
                logout(vuexContext){
                    vuexContext.commit('clearToken');
                    Cookie.remove('jwt');
                    Cookie.remove('expirationDate');
                    if(process.client){
                        localStorage.removeItem('token');
                        localStorage.removeItem('tokenExpiration');
                    }
                    
                }
                
            },
            getters: {
                loadedPosts(state) {
                    return state.loadedPosts
                },
                isAuthenticated(state) {
                    return state.token != null
                }
            }
        }
    )
}

export default createStore;