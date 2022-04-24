package com.example.kluxury.seeding;

import com.example.kluxury.entity.Brand;
import com.example.kluxury.entity.Category;
import com.example.kluxury.repo.BrandRepository;
import com.example.kluxury.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SeedingData implements CommandLineRunner {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        loadDataBrand();
        loadDataCategory();
    }

    private void loadDataBrand(){
        if (brandRepository.count() == 0) {
            Brand brand = new Brand();
            brand.setName("Channel");
            brand.setBrandImage("https://bloganchoi.com/wp-content/uploads/2016/11/chanel.png");

            Brand brand1 = new Brand();
            brand1.setName("Gucci");
            brand1.setBrandImage("https://file.hstatic.net/1000282067/article/logo-thuong-hieu-gucci-elle-man-10__1__eea04867392e48749756524deb3de928.png");

            Brand brand2 = new Brand();
            brand2.setName("Doncle");
            brand2.setBrandImage("https://luxevn.com/wp-content/uploads/2012/05/D-andG-thumb.jpg");

            Brand brand3 = new Brand();
            brand3.setName("Dior");
            brand3.setBrandImage("https://bloganchoi.com/wp-content/uploads/2020/12/my-pham-dior-3.jpg");

            Brand brand4 = new Brand();
            brand4.setName("Hermes");
            brand4.setBrandImage("https://vcdn-giaitri.vnecdn.net/2022/03/19/hermes-2-png-6124-1647681408.jpg");

            Brand brand5 = new Brand();
            brand5.setName("Versace");
            brand5.setBrandImage("https://sidoni.net/upload/baiquet/hinhnd/lich-su-thuong-hieu-versace-y-nghia-bieu-tuong-cua-thuong-hieu-versace4.jpg");

            brandRepository.save(brand);
            brandRepository.save(brand1);
            brandRepository.save(brand2);
            brandRepository.save(brand3);
            brandRepository.save(brand4);
            brandRepository.save(brand5);
        }

    }

    private void loadDataCategory(){
        if (categoryRepository.count() == 0){
            Category category = new Category();
            category.setId(1);
            category.setName("Áo phông");

            Category category1 = new Category();
            category1.setId(2);
            category1.setName("Phụ kiện");

            Category category2 = new Category();
            category2.setId(3);
            category2.setName("Giày-Đép");

            Category category3 = new Category();
            category3.setId(4);
            category3.setName("Trang Sức");

            Category category4 = new Category();
            category4.setId(5);
            category4.setName("Áo phông nam");
            category4.setParentCategory(category);


            Category category5 = new Category();
            category5.setId(6);
            category5.setName("Áo phông nữ");
            category5.setParentCategory(category);

            Category category6 = new Category();
            category6.setId(7);
            category6.setName("Mỹ Phẩm");

            Category category7 = new Category();
            category7.setId(8);
            category7.setName("Son");
            category7.setParentCategory(category6);

            categoryRepository.save(category);
            categoryRepository.save(category1);
            categoryRepository.save(category2);
            categoryRepository.save(category3);
            categoryRepository.save(category4);
            categoryRepository.save(category5);
            categoryRepository.save(category6);
            categoryRepository.save(category7);
        }

    }
}
