import axios from 'axios'
import { getCookie } from './auth'
import type { DataProps } from '@/types/api'


const service = axios.create({
  baseURL: import.meta.env.VITE_APP_MOCK_URL as string,
  timeout: 5000,
  headers: {
    'Content-Type': 'application/json;charset=UTF-8'
  }
})

service.interceptors.request.use(
  (config) => {
    const token = getCookie('token')
    if (token) {
      config.headers['token'] = 'Bearer ' + token
    }
    return config
  },
  (error) => {
    console.log('request error: ', error)
    return Promise.reject(error)
  }
)

service.interceptors.response.use(
  (response) => {
    return response.data
  },
  (error) => {
    console.log('response error: ', error)
    return Promise.reject(error)
  }
)

// 修改 service 返回的类型是 Promise<DataProps>



export default service
