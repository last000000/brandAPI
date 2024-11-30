package org.example.brand_demo2.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.example.brand_demo2.pojo.PageBean;
import org.example.brand_demo2.service.BrandService;
import org.example.brand_demo2.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.brand_demo2.pojo.Result;

import java.util.List;

@RestController
@Slf4j
public class brandController {

    @Autowired
    private BrandService brandService;
    @GetMapping("/selectAll")
    public Result list(){
        List<Brand> brands = brandService.selectAll();
        log.info("查询所有brand名单");
        return Result.success(brands);
    }
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id){
        log.info("根据id {} 查询brand",id);
        return Result.success(brandService.selectById(id));
    }
    @GetMapping("/selectByPage")
    public Result selectByPage(@RequestParam(defaultValue = "1") Integer page,
                                @RequestParam(defaultValue = "5") Integer pageSize){
        log.info("分页查询，页码为{}，每页记录数{}",page,pageSize);
        PageBean pageBean = brandService.selectByPage(page,pageSize);
        return Result.success(pageBean);
    }
    @GetMapping("/selectByCondition")
    public Result selectByCondition(String brandName,String companyName,Integer ordered,String description,int status){
        log.info("根据brandName:{} companyName:{}查询brand",brandName,companyName);
        return Result.success(brandService.selectByCondition(brandName,companyName,ordered,description,status));
    }
    @GetMapping("/cookies")
    public Result cookies(HttpServletResponse response){
        Cookie cookie = new Cookie("name","zhangsan");
        response.addCookie(cookie);
        log.info("创建一个cookie");
        return Result.success();
    }
    @GetMapping("/getCookies")
    public Result getCookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        return Result.success(cookies);
    }
    @DeleteMapping("/deleteById/{id}")
    public Result deleteById(@PathVariable Integer id){
        log.info("删除id为{}的brand",id);
        return Result.success(brandService.deleteById(id));
    }
    @PostMapping("/addBrand")
    public Result addBrand(@RequestBody Brand brand){
        log.info("添加brand");
        return Result.success(brandService.addBrand(brand));
    }
    @PostMapping("/updateById/{id}")
    public Result updateById(@PathVariable Integer id,@RequestBody Brand brand){
        log.info("根据id {} 修改brand",id);
        log.info("brand:{}",brand);
        return Result.success(brandService.updateById(brand,id));
    }
}
