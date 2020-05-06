<template>
  <div>
    <Table border ref="selection" :columns="this.columns" :data="this.shoppingCart" size="large" no-data-text="您的购物车没有商品，请先添加商品到购物车再点击购买"></Table>
    <div class="go-to">
      <Button @click="goTo" type="primary">去付款</Button>
    </div>
  </div>
</template>

<script>
import store from '@/vuex/store';
import { mapState, mapActions } from 'vuex';
export default {
  name: 'MyShoppingCart',
  data () {
    return {
      datas:{},
      columns: [
        {
          type: 'selection',
          width: 58,
          align: 'center'
        },
        {
          title: '图片',
          key: 'productImg',
          width: 86,
          render: (h, params) => {
            return h('div', [
              h('img', {
                attrs: {
                  src: params.row.productImg
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
          key: 'productColour',
          align: 'center',
          width: 198,
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
          width: 128,
          key: 'price',
          align: 'center'
        }
      ]
    };
  },
  created () {
    //const that = this 
    this.loadShoppingCart()
    // .then(res =>{
    //   const data = {
    //     productName:that.shoppingCart.productName,
    //   }
    // })
  },
  computed: {
    ...mapState(['shoppingCart'])
  },
  methods: {
    ...mapActions(['loadShoppingCart']),
    goTo () {
      this.$router.push('/order');
    }
  },
  store
};
</script>

<style scoped>
.go-to {
  margin: 15px;
  display: flex;
  justify-content: flex-end;
}
</style>
