import type { MockMethod } from 'vite-plugin-mock'

export default [
  {
    url: '/api/login',
    method: 'post',
    response: ({ body }) => {
      const { name, password } = body
      if (name === 'admin' && password === '123456') {
        return {
          code: 200,
          message: '登录成功',
          data: {
            name: 'admin',
            token: 'admin-token'
          }
        }
      } else {
        return {
          code: 500,
          message: '账号或密码错误',
          data: null
        }
      }
    }
  }
] as MockMethod[]
