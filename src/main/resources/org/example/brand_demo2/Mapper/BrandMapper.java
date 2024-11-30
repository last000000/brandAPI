package org.example.brand_demo2.Mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.example.brand_demo2.pojo.Brand;

public interface BrandMapper {
    @Update("update tb_brand set brand_name = #{brandName}, company_name = #{companyName}, ordered = #{ordered}, description = #{description}, status = #{status} where id = #{id} and status = #{oldStatus}")
    boolean updateByIdAndStatus(@Param("brandName") String brandName, @Param("companyName") String companyName, @Param("ordered") int ordered, @Param("description") String description, @Param("status") int status, @Param("id") int id, @Param("oldStatus") int oldStatus);
}
