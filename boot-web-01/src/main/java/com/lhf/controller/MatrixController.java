package com.lhf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: lhf
 * @Date: 2021/2/27 15:11
 */
@RestController
public class MatrixController {

    /**
     * 矩阵变量的测试
     * 1、使用场景
     *  禁用了cookie，导致获取不到JsessionId，每次请求可以把JsessionId放到矩阵变量中
     *  矩阵变量格式
     *  /car/path;jessionId=xxxxx
     *  ; 分号后面都是矩阵变量
     *  springboot默认禁用了矩阵变量
     */
    //matrix/path;low=34;brand=byd,yd
    //path;low=34;brand=byd,yd 是一个整体
    @GetMapping("/matrix/{path}")
    public Map<String, Object> matrixTest(@MatrixVariable("low") Integer low,
                             @MatrixVariable("brand")List<String> brand){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("low", low);
        map.put("brand", brand);
        return map;
    }

    //matrix/boss;age=26/2;age=10；同一字段名取值可以使用pathVar参数来区别
    @GetMapping("/matrix/{bossId}/{empId}")
    public Map<String, Object> boss(@MatrixVariable(value = "age", pathVar = "bossId") Integer bossAge,
                                          @MatrixVariable(value = "age", pathVar = "empId")Integer empAge){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("bossAge", bossAge);
        map.put("empAge", empAge);
        return map;
    }
}
