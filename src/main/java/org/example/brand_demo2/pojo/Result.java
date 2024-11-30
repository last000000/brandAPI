package org.example.brand_demo2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Delete;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    public Integer code;
    public String msg;
    public Object data;

    public static  Result success(){
        return new Result(1,"success",null);
    }
    public static Result success(Object data){

        return new Result(1,"success", data);
    }
    public static Result error(){

        return new Result(0,"error!",null);
    }
}
