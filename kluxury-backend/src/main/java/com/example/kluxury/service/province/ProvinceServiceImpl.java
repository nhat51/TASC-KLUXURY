package com.example.kluxury.service.province;

import com.example.kluxury.entity.Province;
import com.example.kluxury.repo.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService{
    @Autowired
    ProvinceRepository provinceRepository;

    @Override
    public List<Province> getAllProvince(){
        return provinceRepository.findAll();
    }
}
