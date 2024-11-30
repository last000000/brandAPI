package org.example.brand_demo2.service;


import org.example.brand_demo2.pojo.Brand;
import org.example.brand_demo2.pojo.PageBean;

import java.util.List;

public interface BrandService {

    public List<Brand> selectAll();
    public boolean deleteById(int id);
    public boolean addBrand(Brand brand);
    public List<Brand> selectById(int id);
    public boolean updateById(Brand brand,int id);
    public PageBean selectByPage(int page, int pageSize);
    public PageBean selectByCondition(String brandName,String companyName,int ordered, String description,int status);
}
