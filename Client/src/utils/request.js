import axios from 'axios';

// create an axios instance
const service = axios.create({
    baseURL: 'http://localhost:8090/api/use',
    timeout: 5000 // request timeout'
});

// request interceptor
service.interceptors.request.use(
    config => {
      return config
    },
    error => {
      console.log(error)
      return Promise.reject(error)
    }
);

// response interceptor
service.interceptors.response.use(
    response => {
        const res = response.data
        return res;
    },
    error => {
      console.log('err' + error)
      return Promise.reject(error)
    }
);

export default service;
