package com.ani.controller;

import com.ani.domain.VideoContent;
import com.ani.repository.VideoContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    VideoContentRepository videoContentRepository;

    List<VideoContent> videoContentList = new ArrayList<>();

    @GetMapping("/")
    public String getIndex(Model model) {

        VideoContent videoContent = videoContentRepository.findFirstByNumber(0);

        if (videoContent == null)
            videoContent = new VideoContent(0L, "NoneTitle", "NoneAbout", "NoneAuthor", "NoneSource");

        model.addAttribute("videoContent", videoContent);
        return "index";
    }

    @PostMapping("/")
    public String postIndex(@ModelAttribute VideoContent videoContent, Model model) {
        videoContentRepository.save(videoContent);
        model.addAttribute("videoContent", videoContent);
        return "index";
    }

}