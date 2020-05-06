import request from './request'


export function ReqHomeAdvertise(){
    return request({
        url: '/home/homeAdvertise',
        method: 'get'
      })
}

export function ReqHomeFlash(){
    return request({
        url: '/home/homeFlash',
        method: 'get'
      })
}