import { getToken, setToken, removeToken } from '@/utils/auth';

const state = {
    token : getToken(),
    roles : []
};

const mutations = {

    SET_TOKEN : (state, token) => {
        state.token = token;
    },

    SET_ROLES  : (state, roles) => {
        state.roles = roles
    }
};

const actions = {

    // user login
    login({ commit }, user){
        return new Promise((resolve, reject) => {
            if(user){
                commit('SET_TOKEN');
                setToken('auth_done');
                resolve();
            }else{
                reject();
            }
        });
    },

    // user logout
    logout({ commit }){
        return new Promise((resolve) => {
            commit('SET_TOKEN');
            removeToken('');
            resolve();
        });
    }
};

export default {
    state,
    mutations,
    actions
}