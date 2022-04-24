package com.example.kluxury.service.brand;

import com.example.kluxury.entity.Brand;
import com.example.kluxury.repo.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService{

    @Autowired
    BrandRepository brandRepository;
    @Override
    public List<Brand> getAll() {
        return brandRepository.getAll();
    }

    @Override
    public Brand save(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand getById(int id) {
        return brandRepository.getById(id);
    }

    @Override
    public Brand update(int id, Brand brand) {
        Brand updatedBrand = brandRepository.getById(id);
        updatedBrand.setName(brand.getName());
        updatedBrand.setUpdated_at(LocalDate.now());
        updatedBrand.setBrandImage(brand.getBrandImage());
        return updatedBrand;
    }

    @Override
    public boolean delete(int id) {
        Brand updatedBrand = brandRepository.getById(id);
        if (updatedBrand == null){
            return false;
        }
        updatedBrand.set_delete(true);
        return true;
    }
}
