package org.example.brand_demo2.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.brand_demo2.Mapper.BrandMapper;
import org.example.brand_demo2.pojo.Brand;
import org.example.brand_demo2.pojo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> selectAll() {
        return brandMapper.selectAll();
    }

    @Override
    public boolean deleteById(int id) {
        return brandMapper.deleteById(id);
    }

    @Override
    public boolean addBrand(Brand brand) {
        return brandMapper.addBrand(brand);
    }

    @Override
    public List<Brand> selectById(int id) {
        return brandMapper.selectById(id);
    }

    @Override
    public boolean updateById(Brand brand,int id) {
        String brandName = brand.getBrandName();
        String companyName = brand.getCompanyName();
        int ordered = brand.getOrdered();
        String description = brand.getDescription();
        int status = brand.getStatus();

        return brandMapper.updateById(brand,id);
    }

    @Override
    public PageBean selectByPage(int page, int pageSize) {
        Long count = brandMapper.count();
        int start = (page-1)*pageSize;
        List<Brand> brands = brandMapper.selectByPage(start,pageSize);
        PageBean pagebean = new PageBean(count,brands);
        return pagebean;
    }

    @Override
    public PageBean selectByCondition(String brandName, String companyName, int ordered, String description, int status) {
        Long count = brandMapper.countByCondition(brandName,companyName,ordered,description,status);
        return null;
    }
}
