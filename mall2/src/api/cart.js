import request from './request'


export function ReqAddCart(data){
    return request({
        url: '/cart/add',
        method: 'post',
        data: data
      })
}

export function ReqloadCartByUser(data){
    return request({
        url: '/cart/userCart',
        method: 'get',
        params: data
      })
}