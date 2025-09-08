package com.js.controller;

import com.js.pojo.ActQueryParam;
import com.js.pojo.Activity;
import com.js.pojo.PageResult;
import com.js.pojo.Result;
import com.js.service.ActService;
import com.js.utils.CurrentHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@RequestMapping("/acts")
@RestController
public class ActController {

    private static final Logger log = LoggerFactory.getLogger(ActController.class);

    @Autowired
    private ActService actService;

    /**
     * 分页查询
     * @return
     */
//    @GetMapping
//    public Result page(@RequestParam(defaultValue = "1") Integer page,
//                       @RequestParam(defaultValue = "10") Integer pageSize,
//                       String name, Integer typeId,
//                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
//                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){//日期例子：1999-03-21
//        log.info("分页查询 {},{},{},{},{},{}",page,pageSize,name,typeId,begin,end);
//        PageResult<Activity> pageResult=actService.list(page,pageSize,name,typeId,begin,end);
//        return Result.success(pageResult);
//    }

    @GetMapping
    public Result page(ActQueryParam actQueryParam){//日期例子：1999-03-21
        log.info("分页查询 {}",actQueryParam);
        PageResult<Activity> pageResult=actService.list(actQueryParam);
        return Result.success(pageResult);
    }


    /**
     * 新增活动
     */
    @PostMapping
    public Result save(@RequestBody Activity activity){
        log.info("新增活动 {}",activity);
        activity.setCreateTime(LocalDateTime.now());//设置创造时间
        activity.setCreatorId(CurrentHolder.getCurrentId());
        //System.out.println("活动创建者id："+activity.getCreatorId());
        actService.save(activity);
        return Result.success();
    }

    /**
     * （批量）删除活动
     */
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        log.info("批量删除 {}",ids);
        actService.delete(ids);
        return Result.success();
    }

    /**
     * 根据id查询活动
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("查询id为{}的活动",id);
        Activity activity=actService.getInfo(id);
        return Result.success(activity);
    }

    /**
     * 修改活动
     */
    @PutMapping
    public Result update(@RequestBody Activity activity){
        log.info("更新活动 {}",activity);
        actService.update(activity);
        return Result.success();
    }


    //根据创建人获取活动
    @GetMapping("/creator")
    public Result getByCreatorId(Integer creatorId){
        log.info("根据创建人id查询活动 {}",creatorId);
        List<Activity> activities=actService.getByCreatorId(creatorId);
        return Result.success(activities);
    }

}
