import axios from "axios";

const URL_PRODUCTS = "http://localhost:8080/api/v1/products";

class ProductService {

    getAll(params){
        return axios.get(URL_PRODUCTS + "/list",{
            params: params,
        });
    }
    save(body){
        return axios.post(URL_PRODUCTS + "/create",body)
    }
    detail(id){
        return axios.get(URL_PRODUCTS + "/detail/"+ id)
    }
    edit(id, body){
        return axios.put(URL_PRODUCTS + "/update/" + id,body)
    }
    delete(id){
        return axios.delete(URL_PRODUCTS + "/delete/" + id)
    }


}

export default new ProductService();