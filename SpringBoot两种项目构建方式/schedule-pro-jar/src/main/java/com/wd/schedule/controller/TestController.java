package com.wd.schedule.controller;

import com.wd.schedule.common.model.Demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    /**
     * 默认页
     * @return
     */
    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("/index");
        return mav;
    }


    /**
     * 跳转页
     * @param map
     * @return
     */
    @GetMapping("/list")
    public ModelAndView test(Map<String,Object> map){
        ModelAndView mav = new ModelAndView();
        List<Demo> demoList = new ArrayList<>(4);
        demoList.add(new Demo(1, "标题1", "编程小石头1", "2501902696"));
        demoList.add(new Demo(2, "标题2", "编程小石头2", "2501902696"));
        demoList.add(new Demo(3, "标题3", "编程小石头3", "2501902696"));
        demoList.add(new Demo(4, "标题4", "编程小石头4", "2501902696"));
        mav.setViewName("/demo/list");
        mav.addObject("demoList",demoList);
        return mav;
    }


}
