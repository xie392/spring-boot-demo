import router from './router'
import { isLogin } from '@/utils/auth'
import { ElMessage } from 'element-plus'

const whiteList = ['login']

router.beforeEach(async (to, from, next) => {
  if (isLogin()) {
    whiteList.includes(to.name as string) ? next({ path: '/' }) : next()
  } else {
    const isAuth = to.meta.requireAuth || false
    if (isAuth && !isLogin()) {
      ElMessage.error('请先登录')
      next(`/login?redirect=${to.fullPath}`)
    } else {
      next()
    }
  }
})
