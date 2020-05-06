<template>
  <div>
    <Search></Search>
    <GoodsListNav></GoodsListNav>
    <div class="goods-list-container">
      <Alert show-icon class="tips-box">
        小提示
        <Icon type="ios-lightbulb-outline" slot="icon"></Icon>
        <template slot="desc">请点击商品前的选择框，选择购物车中的商品，点击付款即可。</template>
      </Alert>
      <Table border ref="selection" :columns="columns" :data="shoppingCart" size="large" @on-selection-change="select" no-data-text="您的购物车没有商品，请先添加商品到购物车再点击购买"></Table>
      <div class="address-container">
        <h3>收货人信息</h3>
        <div class="address-box">
          <div class="address-check">
            <div class="address-check-name">
              <span><Icon type="ios-checkmark-outline"></Icon> {{checkAddress.name}}</span>
            </div>
            <div class="address-detail">
              <p>{{checkAddress.address}}</p>
            </div>
          </div>
          <Collapse>
            <Panel>
                选择地址
                <p slot="content">
                  <RadioGroup vertical size="large" @on-change="changeAddress">
                    <Radio :label="item.addressId" v-for="(item, index) in address" :key="index">
                      <span>{{item.name}} {{item.province}} {{item.city}} {{item.address}} {{item.phone}} {{item.postalcode}}</span>
                    </Radio>
                  </RadioGroup>
                </p>
            </Panel>
          </Collapse>
        </div>
      </div>
      <div class="remarks-container">
        <h3>备注</h3>
        <i-input v-model="remarks" size="large" placeholder="在这里填写备注信息" class="remarks-input"></i-input>
      </div>
      <div class="invoices-container">
        <h3>发票信息</h3>
        <p>该商品不支持开发票</p>
      </div>
      <div class="pay-container">
        <div class="pay-box">
          <p><span>提交订单应付总额：</span> <span class="money"><Icon type="social-yen"></Icon> {{totalPrice.toFixed(2)}}</span></p>
          <div class="pay-btn">
            <router-link to="/pay"><Button type="error" size="large" @click="pay">支付订单</Button></router-link>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Search from '@/components/Search';
import GoodsListNav from '@/components/nav/GoodsListNav';
import store from '@/vuex/store';
import { mapState, mapActions } from 'vuex';
export default {
  name: 'Order',
  beforeRouteEnter (to, from, next) {
    window.scrollTo(0, 0);
    next();
  },
  created () {
    this.loadAddress();
  },
  data () {
    return {
      goodsCheckList: [],
      totalAmount:'',
      receiver:{},
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
      ],
      checkAddress: {
        name: '未选择',
        address: '请选择地址'
      },
      remarks: ''
    };
  },
  computed: {
    ...mapState(['address', 'shoppingCart']),
    totalPrice () {
      let price = 0;
      this.goodsCheckList.forEach(item => {
        price += item.price * item.count;
      });
      this.totalAmount = price ;
      return price;
    }
  },
  methods: {
    ...mapActions(['loadAddress','createOrder']),
    select (selection, row) {
      console.log(selection);
      this.goodsCheckList = selection;
      console.log("goodsCheckList:"+JSON.stringify(this.goodsCheckList));
    },
    changeAddress (data) {
      const father = this;
      console.log(JSON.stringify(this.address))
      this.address.forEach(item => {
        if (item.addressId === data) {
            this.receiver.phone = item.phone
            this.receiver.name = item.name
            this.receiver.city =       item.city
            this.receiver.address    =    item.address
            this.receiver.postalcode   =     item.postalcode
            this.receiver.province = item.province
            this.receiver.receiverRegion = item.area
          father.checkAddress.name = item.name;
          father.checkAddress.address = `${item.name} ${item.province} ${item.city} ${item.address} ${item.phone} ${item.postalcode}`;
        }
      });
    },
    pay(){

        let that = this
        if(that.receiver==undefined||that.receiver=={}||that.receiver==null){
          alert("请先选择收货地址")
          return 0 
        }
      const userinfo =  localStorage.getItem('loginInfo')
      const userO = JSON.parse(userinfo)

      const orderData = {
        spaceUserId: userO.id ,
        memberUsername:userO.user.closername,
        totalAmount: this.totalAmount ,
        payAmount: this.totalAmount,
        receiverPhone: this.receiver.phone,
        receiverName:this.receiver.name ,
        receiverPostCode: this.receiver.postalcode,
        receiverProvince:this.receiver.province ,
        receiverCity:this.receiver.city ,
        receiverDetailAddress: this.receiver.address ,
        receiverRegion: this.receiver.receiverRegion
      }

    
    let orderItems = []

    this.goodsCheckList.forEach(item =>{
    let productAttr = []
    let Specs = {key:'规格',value: item.productSpecs}
    let Colour = {key:'颜色',value: item.productColour}
    productAttr[0] = Colour
    productAttr[1] = Specs
    let productAttrJ = JSON.stringify(productAttr)
    let shoppingCartc = JSON.stringify(item)
    console.log("productAttrJ:"+productAttrJ)
    console.log("shoppingCartc:"+item)

      const orderItemData = {
        orderId:'',
        orderSn:'',
        spaceUserId: userO.id,
        productBrand: item.productBrand,
        productId:item.productId,
        productPic:item.productImg,
        productName:item.productName,
        productPrice:item.price,
        realAmount:item.price,
        productImg:item.productImg,
        productSpecs:item.productSpecs,
        productColour:item.productColour,
        count:item.count,
        productQuantity: item.count,
        productAttr: productAttrJ
      }
      console.log("orderItemData:"+JSON.stringify(orderItemData))
      orderItems.push(orderItemData)
      })
      const data = {
        orderData: orderData,
        orderItems: orderItems
      }
      console.log("data:"+JSON.stringify(data))
      that.createOrder(data);
    }
  },
  mounted () {
    setTimeout(() => {
      this.$refs.selection.selectAll(true);
    }, 500);
  },
  components: {
    Search,
    GoodsListNav
  },
  store
};
</script>

<style scoped>
.goods-list-container {
  margin: 15px auto;
  width: 80%;
}
.tips-box {
  margin-bottom: 15px;
}
.address-container {
  margin-top: 15px;
}
.address-box {
  margin-top: 15px;
  padding: 15px;
  border: 1px #ccc dotted;
}
.address-check {
  margin: 15px 0px;
  height: 36px;
  display: flex;
  align-items: center;
}
.address-check-name {
  width: 120px;
  display: flex;
  justify-content: center;
  align-content: center;
  background-color: #ccc;
}
.address-check-name span {
  width: 120px;
  height: 36px;
  font-size: 14px;
  line-height: 36px;
  text-align: center;
  color: #fff;
  background-color: #f90013;
}
.address-detail {
  padding-left: 15px;
  font-size: 14px;
  color: #999999;
}
.remarks-container {
  margin: 15px 0px;
}
.remarks-input {
  margin-top: 15px;
}
.invoices-container p{
  font-size: 12px;
  line-height: 30px;
  color: #999;
}
.pay-container {
  margin: 15px;
  display: flex;
  justify-content: flex-end;
}
.pay-box {
  font-size: 18px;
  font-weight: bolder;
  color: #495060;
}
.money {
  font-size: 26px;
  color: #f90013;
}
.pay-btn {
  margin: 15px 0px;
  display: flex;
  justify-content: flex-end;
}
</style>
