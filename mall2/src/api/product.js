import request from './request'


export function ReqGoodList(state){
    return request({
        url: '/product/goodList',
        method: 'get',
        params: state
      })
}

export function ReqGoodInfo(state){
  return request({
      url: '/goods/goodsInfo',
      method: 'get',
      params: state
    })
}

export function ReqGoodInfoColour(state){
  return request({
      url: '/goods/goodsInfo/colour',
      method: 'get',
   
      params: state
    })
}

export function ReqGoodInfoSpecs(state){
  return request({
      url: '/goods/goodsInfo/specs',
      method: 'get',
      params: state
    })
}