package com.ani.controller;

import com.ani.domain.VideoExample;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ExampleController {

    public List<VideoExample> exampleList = new ArrayList<>();

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        VideoExample videoExample;

        if(exampleList.size()!=0) videoExample = exampleList.get(exampleList.size()-1);
        else videoExample = new VideoExample();
        model.addAttribute("videoExample", videoExample);
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute VideoExample videoExample, Model model) {
        exampleList.add(videoExample);
        model.addAttribute("videoExample", videoExample);
        return "greeting";
    }

}
