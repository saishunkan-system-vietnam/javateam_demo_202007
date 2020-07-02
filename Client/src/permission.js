import router from './router';
// import store from './store';
import { getToken } from '@/utils/auth';

router.beforeEach(async(to, from, next) => {
    const whiteList = ['/pages/login', '/pages/register']
    const hasToken = getToken();
    if(hasToken){
        next();
    }else{
        if(whiteList.indexOf(to.path) !== -1){
            next();
        }else{
            next(`/pages/login?redirect=${to.path}`);
        }
    }
});