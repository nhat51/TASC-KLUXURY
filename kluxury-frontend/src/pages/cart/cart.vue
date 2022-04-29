<template>
  <div><!-- entry-header-area start -->
    <div class="entry-header-area">
      <div class="container">
        <div class="row">
          <div class="col-12">
            <div class="entry-header">
              <h1 class="entry-title">Cart</h1>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- entry-header-area end -->
    <!-- cart-main-area start -->
    <div class="cart-main-area">
      <div class="container">
        <div class="row">
          <div class="col-12">
            <form action="#">
              <div class="table-content table-responsive">
                <table>
                  <thead>
                  <tr>
                    <th class="product-thumbnail">Image</th>
                    <th class="product-name">Product</th>
                    <th class="product-price">Price</th>
                    <th class="product-quantity">Quantity</th>
                    <th class="product-remove">Remove</th>
                  </tr>
                  </thead>
                  <tbody>
                  <tr v-for="od in cartData.orderDetails" :key="od.id">
                    <td class="product-thumbnail"><a href="#"><img src="img/product/productDemo.jpg"
                                                                   alt="" /></a></td>
                    <td class="product-name"><a href="#">{{od.product_name}}</a></td>
                    <td class="product-price"><span class="amount">${{od.unit_price}}</span></td>
                    <td class="product-quantity">
                      <button @click="decreaseProductAmount(od.id.product_id)" id="decrease"><i class="fa fa-minus"></i></button>
                      <input id="productAmount" type="number" :value="od.amount" />
                      <button @click="increaseProductAmount(od.id.product_id)" id="increase"><i class="fa fa-plus"></i></button>
                    </td>
                    <td class="product-remove"><a @click="confirmRemove(od.id.product_id)"><i class="fa fa-times"></i></a></td>
                  </tr>
                  </tbody>
                </table>
              </div>
              <div class="row">
                <div class="col-lg-8 col-md-7">
                  <div class="buttons-cart">
                    <input type="submit" value="Update Cart" />
                    <a href="#">Continue Shopping</a>
                  </div>
                  <div class="coupon">
                    <h3>Coupon</h3>
                    <p>Enter your coupon code if you have one.</p>
                    <input type="text" placeholder="Coupon code" />
                    <input type="submit" value="Apply Coupon" />
                  </div>
                </div>
                <div class="col-lg-4 col-md-5">
                  <div class="cart_totals">
                    <h2>Cart Totals</h2>
                    <table>
                      <tbody>
                      <tr class="cart-subtotal">
                        <th>Subtotal</th>
                        <td><span class="amount">�215.00</span></td>
                      </tr>
                      <tr class="shipping">
                        <th>Shipping</th>
                        <td>
                          <ul id="shipping_method">
                            <li>
                              <input type="radio" />
                              <label>
                                Flat Rate: <span class="amount">�7.00</span>
                              </label>
                            </li>
                            <li>
                              <input type="radio" />
                              <label>
                                Free Shipping
                              </label>
                            </li>
                            <li></li>
                          </ul>
                          <p><a class="shipping-calculator-button" href="#">Calculate
                            Shipping</a></p>
                        </td>
                      </tr>
                      <tr class="order-total">
                        <th>Total</th>
                        <td>
                          <strong><span class="amount">${{this.cartData.totalPrice}}</span></strong>
                        </td>
                      </tr>
                      </tbody>
                    </table>
                    <div class="wc-proceed-to-checkout">
                      <a href="/checkout">Proceed to Checkout</a>
                    </div>
                  </div>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
    <!-- cart-main-area end --></div>
</template>

<script>
import OrderService from "@/service/OrderService";

export default {
  name: "cart",
  data(){
    return {
      cartData:[],
      cartItem:[],
      userId: 1,
      params:{
        product_id:undefined
      },
      productAmount:{
        product_id: undefined,
        amount: undefined
      }
    }
  },
  created() {
    this.getCartData()
  },
  methods:{
    getCartData(){
      OrderService.getAll(this.userId).then(rs =>{
        this.cartData = rs.data
        console.log(rs.data)
      })
    },
    removeItem(productId){
      this.params.product_id = productId
      OrderService.removeItem(this.params,this.userId).then(
          () => {
            this.getCartData()
          }
      )

    },
    confirmRemove(id){
      const isConfirm = confirm("Bạn có muốn xóa sản phẩm này khỏi giỏ hàng")
      if (isConfirm === true){
        this.removeItem(id)
        this.getCartData()
      }
    },
    increaseProductAmount(id){
     this.productAmount.product_id = id;
     this.productAmount.amount = 1;
     OrderService.addToCart(this.userId,this.productAmount)
      this.getCartData()
    },
    decreaseProductAmount(id){
      this.productAmount.product_id = id;
      this.productAmount.amount = -1;
      OrderService.addToCart(this.userId,this.productAmount)
      this.getCartData()
    }


  }
}
</script>

<style scoped>

</style>