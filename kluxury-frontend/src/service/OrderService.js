import axios from "axios";

const URL_CATEGORIES = "http://localhost:8080/api/v1/orders";

class OrderService {

    getAll(userId){
        return axios.get(URL_CATEGORIES + "/cart",{headers:{'user_id' : userId}});
    }
    addToCart(userId,body){
        return axios.post(URL_CATEGORIES + "/add_to_cart" ,body
            , {headers:{'user_id' : userId}}
        );
    }
    removeItem(param,userId){
        return axios.post(URL_CATEGORIES + "/remove",null,
            {headers:{'user_id' : userId},params:param}
        );
    }
    proceedOrder(userId,orderDto){
        return axios.get(URL_CATEGORIES + "/proceed_order"
            ,{headers:userId}
            ,orderDto
        );
    }
    getOrders(userId){
        return axios.get(URL_CATEGORIES + "/proceed_order"
            ,{headers:userId}
        );
    }

}

export default new OrderService();