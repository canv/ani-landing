package com.ani.controller;

import com.ani.domain.VideoExample;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class ExampleController {

    public List<VideoExample> exampleList = new ArrayList<>();

    @GetMapping("/greeting")
    public String greetingForm(Map<String, Object> model) {
        VideoExample videoExample;

        if(exampleList.size()!=0) videoExample = exampleList.get(exampleList.size()-1);
        else {
            videoExample = new VideoExample();
            videoExample.setId(0);
            videoExample.setContent("empty videoExample");
        }

//        model.put("id", videoExample.getId());
//        model.put("content", videoExample.getContent());;
        model.put("videoExample", videoExample);;
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(
            @RequestParam(name="id", required = false, defaultValue = "0") String id,
            @RequestParam(name="content", required = false, defaultValue = "FixMe") String content,
            Map<String, Object> model
    ) {
        VideoExample videoExample = new VideoExample();
        videoExample.setId(Long.parseLong(id));
        videoExample.setContent(content);

        exampleList.add(videoExample);

//        model.put("id", id);
//        model.put("content", content);
        model.put("videoExample", videoExample);;
        return "greeting";
    }

}
