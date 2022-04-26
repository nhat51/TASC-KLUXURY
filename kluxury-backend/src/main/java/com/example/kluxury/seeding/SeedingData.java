package com.example.kluxury.seeding;

import com.example.kluxury.entity.Brand;
import com.example.kluxury.entity.Category;
import com.example.kluxury.entity.Product;
import com.example.kluxury.repo.BrandRepository;
import com.example.kluxury.repo.CategoryRepository;
import com.example.kluxury.repo.ProductRepository;
import com.github.javafaker.Cat;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SeedingData implements CommandLineRunner {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    HashMap<Integer, Category> mapCategory = new HashMap<>();
    HashMap<Integer, Brand> mapBrand = new HashMap<>();

    @Override
    public void run(String... args) throws Exception {
        loadDataBrand();
        loadDataCategory();
        loadDataProduct();
    }

    private void loadDataBrand(){
        if (brandRepository.count() == 0) {
            List<Brand> brands = new ArrayList<>();
            Brand brand = new Brand();
            brand.setId(1);
            brand.setName("Channel");
            brand.setBrandImage("https://bloganchoi.com/wp-content/uploads/2016/11/chanel.png");
            brands.add(brand);
            mapBrand.put(1,brand);

            Brand brand1 = new Brand();
            brand1.setId(2);
            brand1.setName("Gucci");
            brand1.setBrandImage("https://file.hstatic.net/1000282067/article/logo-thuong-hieu-gucci-elle-man-10__1__eea04867392e48749756524deb3de928.png");
            brands.add(brand1);
            mapBrand.put(2,brand1);

            Brand brand2 = new Brand();
            brand2.setId(3);
            brand2.setName("Doncle");
            brand2.setBrandImage("https://luxevn.com/wp-content/uploads/2012/05/D-andG-thumb.jpg");
            brands.add(brand2);
            mapBrand.put(3, brand2);

            Brand brand3 = new Brand();
            brand3.setId(4);
            brand3.setName("Dior");
            brand3.setBrandImage("https://bloganchoi.com/wp-content/uploads/2020/12/my-pham-dior-3.jpg");
            brands.add(brand3);
            mapBrand.put(4, brand3);

            Brand brand4 = new Brand();
            brand4.setId(5);
            brand4.setName("Hermes");
            brand4.setBrandImage("https://vcdn-giaitri.vnecdn.net/2022/03/19/hermes-2-png-6124-1647681408.jpg");
            brands.add(brand4);
            mapBrand.put(5, brand4);

            Brand brand5 = new Brand();
            brand5.setId(6);
            brand5.setName("Versace");
            brand5.setBrandImage("https://sidoni.net/upload/baiquet/hinhnd/lich-su-thuong-hieu-versace-y-nghia-bieu-tuong-cua-thuong-hieu-versace4.jpg");
            brands.add(brand5);
            mapBrand.put(6,brand5);

            Brand brand6 = new Brand();
            brand6.setId(7);
            brand6.setName("Brand 7");
            brand6.setBrandImage("https://sidoni.net/upload/baiquet/hinhnd/lich-su-thuong-hieu-versace-y-nghia-bieu-tuong-cua-thuong-hieu-versace4.jpg");
            brands.add(brand6);
            mapBrand.put(7,brand6);

            Brand brand7 = new Brand();
            brand7.setId(8);
            brand7.setName("Brand 8");
            brand7.setBrandImage("https://sidoni.net/upload/baiquet/hinhnd/lich-su-thuong-hieu-versace-y-nghia-bieu-tuong-cua-thuong-hieu-versace4.jpg");
            brands.add(brand7);
            mapBrand.put(8,brand7);

            Brand brand8 = new Brand();
            brand8.setId(9);
            brand8.setName("Brand 9");
            brand8.setBrandImage("https://sidoni.net/upload/baiquet/hinhnd/lich-su-thuong-hieu-versace-y-nghia-bieu-tuong-cua-thuong-hieu-versace4.jpg");
            brands.add(brand8);
            mapBrand.put(9,brand8);

            Brand brand9 = new Brand();
            brand9.setId(10);
            brand9.setName("Brand 10");
            brand9.setBrandImage("https://sidoni.net/upload/baiquet/hinhnd/lich-su-thuong-hieu-versace-y-nghia-bieu-tuong-cua-thuong-hieu-versace4.jpg");
            brands.add(brand9);
            mapBrand.put(10,brand9);

            brandRepository.saveAll(brands);
        }

    }

    private void loadDataCategory(){
        if (categoryRepository.count() == 0){
            List<Category> list = new ArrayList<>();
            Category category = new Category();
            category.setId(1);
            category.setName("Áo phông");
            list.add(category);
            mapCategory.put(1,category);

            Category category1 = new Category();
            category1.setId(2);
            category1.setName("Phụ kiện");
            list.add(category1);
            mapCategory.put(2,category1);

            Category category2 = new Category();
            category2.setId(3);
            category2.setName("Giày-Đép");
            list.add(category2);
            mapCategory.put(3,category2);

            Category category3 = new Category();
            category3.setId(4);
            category3.setName("Trang Sức");
            list.add(category3);
            mapCategory.put(4,category3);

            Category category4 = new Category();
            category4.setId(5);
            category4.setName("Áo phông nam");
            category4.setParentCategory(category);
            list.add(category4);
            mapCategory.put(5,category4);


            Category category5 = new Category();
            category5.setId(6);
            category5.setName("Áo phông nữ");
            category5.setParentCategory(category);
            list.add(category5);
            mapCategory.put(6,category5);

            Category category6 = new Category();
            category6.setId(7);
            category6.setName("Mỹ Phẩm");
            list.add(category6);
            mapCategory.put(7,category6);

            Category category7 = new Category();
            category7.setId(8);
            category7.setName("Son");
            category7.setParentCategory(category6);
            list.add(category7);
            mapCategory.put(8,category7);

            Category category8 = new Category();
            category8.setId(9);
            category8.setName("Phấn");
            category8.setParentCategory(category6);
            list.add(category8);
            mapCategory.put(9,category8);

            Category category9 = new Category();
            category9.setId(10);
            category9.setName("Kẻ mắt");
            category9.setParentCategory(category6);
            list.add(category9);
            mapCategory.put(10,category9);

           categoryRepository.saveAll(list);
        }

    }

    private void loadDataProduct(){
        if (productRepository.count() == 0) {
            int max = 11;
            Faker faker = new Faker();
            for (int i = 1; i < max; i++) {
                Product product = new Product();
                product.setId(i);
                product.setPrice(faker.random().nextDouble());
                product.setName(faker.harryPotter().character());
                product.setDescription(faker.ancient().primordial());
                product.setStatus(1);
                product.setRating(faker.random().nextDouble());
                product.setCategory_id(i);
                product.setBrand_id(i);
                product.setBrand(mapBrand.get(i));
                product.setCategory(mapCategory.get(i));

                productRepository.save(product);
            }
        }

    }
}
