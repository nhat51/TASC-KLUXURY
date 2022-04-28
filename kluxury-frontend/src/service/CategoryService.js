import axios from "axios";

const URL_CATEGORIES = "http://localhost:8080/api/v1/categories";

class CategoryService {

    getAll(){
        return axios.get(URL_CATEGORIES + "/list", {
        });
    }


}

export default new CategoryService();