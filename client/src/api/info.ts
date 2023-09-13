import type { DataInfo } from '@/types'
import type { DataProps } from '@/types/api'
import request from '@/utils/request'

/**
 * All Info Api
 *
 */
export const InfoListApi = (): Promise<DataProps> => {
  return request({
    url: '/infoList',
    method: 'get'
  })
}

/**
 * Add Info Api
 *
 * @param data { name: string; age: number; gender: string, major: string }  Add Info params
 */
export const AddInfoApi = (data: {
  name: string
  age: number
  gender: string
  major: string
}): Promise<DataProps> => {
  return request({
    url: '/add',
    method: 'post',
    data
  })
}

/**
 * Update Info Api
 *
 * @param id Info id
 */
export const UpdateInfoApi = (data: DataInfo): Promise<DataProps> => {
  return request({
    url: `/update`,
    method: 'patch',
    data
  })
}

/**
 * Delete Info Api
 *
 * @param id Info id
 */
export const DeleteInfoApi = (id: string): Promise<DataProps> => {
  return request({
    url: `/delete/${id}`,
    method: 'delete'
  })
}

/**
 * Get Info search Api
 *
 * @param name Info name
 */
export const GetInfoSearchApi = (name: string): Promise<DataProps> => {
  return request({
    url: `/search/${name}`,
    method: 'get'
  })
}
