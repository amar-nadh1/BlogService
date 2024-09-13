package com.example.BlogsandComments.Controller;

import com.example.BlogsandComments.DTO.AddBlog;
import com.example.BlogsandComments.DTO.BlogLikeRequest;
import com.example.BlogsandComments.models.Blog;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequestMapping("/api/v1/blog")

public class BlogController {
    @PostMapping("/")
    public Blog createBlog(@RequestBody AddBlog blog){

    }

    @GetMapping("/{id}")
    public Blog getBlogById(@PathVariable long id){

    }

    @GetMapping("/all")
    public List<Blog> getAllBlogs(){

    }
    @PostMapping("/{id}/like")
    public void like(@PathVariable("id") long blogId, @RequestBody BlogLikeRequest request){

    }

}
