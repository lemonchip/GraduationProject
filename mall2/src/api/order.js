import request from './request'


export function ReqcreateOrder(data){
    return request({
        url: '/order/add',
        method: 'post',
        data: data
      })
}

export function ReqcreateOrderItem(data){
    return request({
        url: '/order/addItem',
        method: 'post',
        data: data
      })
}
export function ReqGetMyOrder(data){
    return request({
        url: '/order/getOrder',
        method: 'get',
        params: data
      })
}

