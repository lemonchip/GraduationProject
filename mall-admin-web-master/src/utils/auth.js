import Cookies from 'js-cookie'

const TokenKey = 'loginToken'

export function getToken() {
  console.log("getToken")
  return Cookies.get(TokenKey)
}

export function setToken(token) {
  console.log("token："+token)
  return Cookies.set(TokenKey, token)
}

export function removeToken() {
  return Cookies.remove(TokenKey)
}
