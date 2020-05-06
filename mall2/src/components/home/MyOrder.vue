<template>
  <div>
    <Table border :columns="columns" :data="myOrderList" size="large" no-data-text="你还有订单，快点去购物吧"></Table>
    <div class="page-size">
      <Page :total="100" show-sizer></Page>
    </div>
  </div>
</template>

<script>
import store from '@/vuex/store';
import { mapState, mapActions } from 'vuex';
export default {
  name: 'MyOrder',
  data () {
    return {
      order: [{
        order_id: 1529931938150,
        goods_id: 1529931938150,
        count: 1,
        img: 'static/img/goodsDetail/pack/1.jpg',
        package: '4.7英寸-深邃蓝',
        price: 28,
        title: '苹果8/7手机壳iPhone7 Plus保护壳全包防摔磨砂硬外壳',
        createAt: '2018-06-06 20:06:08'
      }],
      columns: [
        {
          title: '订单号',
          key: 'orderSn',
          width: 180,
          align: 'center'
        },
        {
          title: '图片',
          key: 'productPic',
          width: 86,
          render: (h, params) => {
            return h('div', [
              h('img', {
                attrs: {
                  src: params.row.productPic
                }
              })
            ]);
          },
          align: 'center'
        },
        {
          title: '商品',
          key: 'productName',
          align: 'center'
        },
        {
          title: '颜色',
          width: 198,
          key: 'productColour',
          align: 'center'
        },
         {
          title: '规格',
          width: 198,
          key: 'productSpecs',
          align: 'center'
        },
        {
          title: '数量',
          key: 'count',
          width: 68,
          align: 'center'
        },
        {
          title: '价格',
          width: 98,
          key: 'productPrice',
          align: 'center'
        }
      ]
    };
  },
   computed: {
    ...mapState(['myOrderList']),
   },
  methods:{
    ...mapActions(['loadMyOrder'])
  },
  created(){
      const userinfo =  localStorage.getItem('loginInfo')
      const userO = JSON.parse(userinfo)
      const data = {
        userId: userO.id,
        page:1,
        size:20
      }
      console.log("我的订单")
      this.loadMyOrder(data)
  },
  store
};
</script>

<style scoped>
.page-size {
  margin: 15px 0px;
  display: flex;
  justify-content: flex-end;
  align-items: center;
}
</style>
