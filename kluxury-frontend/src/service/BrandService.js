import axios from "axios";

const URL_CATEGORIES = "http://localhost:8080/api/v1/brands";

class BrandService {

    getAll(){
        return axios.get(URL_CATEGORIES + "/list", {
        });
    }


}

export default new BrandService();