package com.cos.photogramstart.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ImageController {
    @GetMapping({"/", "/image/story"})  // {}를 사용해 여러 개의 주소에 대해서도 하나의 return 값 지정 가능
    public String story(){
        return "image/story";
    }

    @GetMapping("/image/popular")  //
    public String popular(){
        return "image/popular";
    }

    @GetMapping("/image/upload")  //
    public String upload(){
        return "image/upload";
    }

}
