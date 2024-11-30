package org.example.brand_demo2.Mapper;


import org.apache.ibatis.annotations.*;
import org.example.brand_demo2.pojo.Brand;

import java.util.List;
@Mapper

public interface BrandMapper {
   @Select("select * from tb_brand")
    public List<Brand> selectAll();
    @Select("select * from tb_brand where id = #{id}")
    public List<Brand> selectById(int id);
    @Delete("delete from tb_brand where id = #{id}")
    public boolean deleteById(int id);
    @Insert("insert into tb_brand (brand_name,company_name,ordered,description,status) values (#{brandName},#{companyName},#{ordered},#{description},#{status})")
    public boolean addBrand(Brand brand);
    //@Update("update tb_brand set brand_name = #{brandName},company_name = #{companyName},ordered = #{ordered},description = #{description} ,status = #{status} where id = #{idName}")
    public boolean updateById(Brand brand,int idName);
    @Select("select count(*) from tb_brand")
    public Long count();
    @Select("select * from tb_brand limit #{start},#{pageSize}")
    public List<Brand> selectByPage( int start,int pageSize);
    @Select("select * from  tb_brand")
    public List<Brand> list();
    @Select("select count(*) from tb_brand where brand_name = #{brandname} and company_name = #{companyName} and ordered = #{ordered} and description = #{description} and status = #{status}")
    public Long countByCondition(String brandName, String companyName, int ordered, String description, int status);
}
