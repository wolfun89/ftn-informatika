import axios from 'axios';
import { logout } from '../services/auth';

var ZavrsniAxios = axios.create({
  baseURL: 'http://localhost:8080/api',
  /* other custom settings */
});

ZavrsniAxios.interceptors.request.use(
  function presretac(config) {
    const jwt = window.localStorage['jwt']
    if (jwt) {
      config.headers['Authorization'] = "Bearer " + jwt
    }
    return config;
  }
);

ZavrsniAxios.interceptors.response.use(
  function success(response) {
    return response;
  },
  function failure(error) {
    let jwt = window.localStorage['jwt'];
    if (jwt) {
      if (error.response && error.response.status == 403) {
        logout();
      }
    }

    throw error;
  }
);

export default ZavrsniAxios;