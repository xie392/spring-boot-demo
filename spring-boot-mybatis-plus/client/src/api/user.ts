import type { DataProps } from '@/types/api'
import request from '@/utils/request'

/**
 * Login Api
 * @param data { name: string; password: string }  Login params
 */
export const LoginApi = (data: { name: string; password: string }): Promise<DataProps> => {
  return request({
    url: '/login',
    method: 'post',
    data
  })
}
