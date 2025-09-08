package com.js.controller;


import com.js.pojo.ActType;
import com.js.pojo.Result;
import com.js.service.ActTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/actTypes")
@RestController
public class ActTypeController {

    private static final Logger log = LoggerFactory.getLogger(ActTypeController.class);

    @Autowired
    private ActTypeService actTypeService;

    /**
     * 获取所有活动类型数据
     * @return
     */

    @GetMapping
    public Result list() {
        log.info("获取所有活动类型数据");
        List<ActType> actTypeList= actTypeService.getAll();
        return Result.success(actTypeList);
    }


    //添加活动类型
    @PostMapping
    public Result add(@RequestBody ActType actType) {
        log.info("添加活动类型");
        actTypeService.add(actType);
        return Result.success();
    }

    //根据id查询活动类型
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据id查询活动类型");
        ActType actType=actTypeService.getById(id);
        return Result.success(actType);
    }
    //修改活动类型
    @PutMapping
    public Result update(@RequestBody ActType actType) {
        log.info("修改活动类型");
        actTypeService.update(actType);
        return Result.success();
    }

    //删除活动类型
    @DeleteMapping
    public Result delete( Integer  id) {
        log.info("删除活动类型");
        actTypeService.delete(id);
        return Result.success();
    }
}
