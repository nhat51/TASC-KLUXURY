import axios from "axios";

const URL_CATEGORIES = "http://localhost:8080/api/v1/orders";

class OrderService {

    getAll(user_id){
        return axios.get(URL_CATEGORIES + "/cart", {
            headers:user_id
        });
    }
    addToCart(userId,body){
        return axios.get(URL_CATEGORIES + "/add_to_cart"
            , {headers:userId}
            ,body
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