import type { MockMethod } from 'vite-plugin-mock'
import { faker } from '@faker-js/faker'

interface InfoItem {
  id: string
  age: number
  name: string
  gender: string
  major: string
}

const infoList: InfoItem[] = []
for (let i = 0; i < 5; i++) {
  infoList.push({
    id: faker.string.uuid(),
    age: faker.number.int({ min: 0, max: 100 }),
    name: faker.person.fullName(),
    gender: ['男', '女'][faker.number.int({ min: 0, max: 1 })],
    major: faker.person.jobArea()
  })
}

function isAuth(headers: Record<string, any>): boolean {
  return headers?.['token'] === 'Bearer admin-token'
}

function response(code: number, message: string, data: any): any {
  return {
    code,
    message,
    data
  }
}

export default [
  {
    url: '/api/infoList',
    method: 'get',
    response: ({ headers }) => {
      if (!isAuth(headers)) {
        return response(401, '请先登录', null)
      }
      return response(200, '获取成功', infoList)
    }
  },
  {
    url: '/api/add',
    method: 'post',
    response: ({ headers, body }) => {
      if (!isAuth(headers)) {
        return response(401, '请先登录', null)
      }
      const id = faker.string.uuid()
      body.id = id
      infoList.push(body as InfoItem)
      return response(200, '添加成功', body)
    }
  },
  {
    url: '/api/update',
    method: 'patch',
    response: ({ headers, body }) => {
      if (!isAuth(headers)) {
        return response(401, '请先登录', null)
      }
      const index = infoList.findIndex((item) => (body as InfoItem).id === item.id)
      if (index !== -1) {
        infoList[index] = body as InfoItem
        return response(200, '修改成功', null)
      } else {
        return response(500, '修改失败', null)
      }
    }
  },
  {
    url: '/api/delete/:id',
    method: 'delete',
    response: ({ headers, query }) => {
      if (!isAuth(headers)) {
        return response(401, '请先登录', null)
      }
      const { id } = query
      const index = infoList.findIndex((item) => item.id === id)
      if (index !== -1) {
        infoList.splice(index, 1)
        return response(200, '删除成功', null)
      } else {
        return response(500, '删除失败', null)
      }
    }
  },
  {
    url: '/api/search',
    method: 'get',
    response: ({ headers, query }) => {
      if (!isAuth(headers)) {
        return response(401, '请先登录', null)
      }
      const { name } = query
      const list = infoList.filter((item) => item.name.includes(name))
      return list
    }
  }
] as MockMethod[]
