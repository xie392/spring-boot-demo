import Cookies from 'js-cookie'

export function getCookie(key: string) {
  return Cookies.get(key)
}

export function setCookie(key: string, value: string) {
  return Cookies.set(key, value)
}

export function removeCookie(key: string) {
  return Cookies.remove(key)
}

export function isLogin() {
  return Cookies.get('token')
}
