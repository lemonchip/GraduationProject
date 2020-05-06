import request from './request'


export function Reqlogin(username,password){
    return request({
        url: '/sign_in',
        method: 'post',
        data: {
          username,
          password
        }
      })
}