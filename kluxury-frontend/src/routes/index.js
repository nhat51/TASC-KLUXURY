import Vue from 'vue'
import VueRouter from 'vue-router'
import {homePage} from "@/pages/home";
import {shopPage} from "@/pages/shop";
import {cartPage} from "@/pages/cart";
import {checkoutPage} from "@/pages/checkout";


Vue.use(VueRouter)

const routes = [
    ...homePage,
    ...shopPage,
    ...cartPage,
    ...checkoutPage
]

const router = new VueRouter({
    mode: 'history',
    routes
})

router.beforeEach((to, from, next) => {
    document.title = to.meta.title;
    next();
})

export default router;