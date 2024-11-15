package com.example.demo.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RequestMapping("/blog")
@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    // Create Blog
    @PostMapping
    public Blog createBlog(@RequestBody Blog blog) {
        return blogService.createBlog(blog);
    }

    // Get all blogs
    @GetMapping
    public List<Blog> getAllBlogs(Model model) {
        List<Blog> BlogDataList =  blogService.getAllBlogs();

        return BlogDataList;
    }

    // Get blog by ID
    @GetMapping("/{id}")
    public Blog getBlogById(@PathVariable Long id) {
        return blogService.getBlogById(id);
    }

    @PostMapping("/update")
    @ResponseBody
    public Blog updateBlog(@RequestBody Blog updatedBlog) {
        Long id = updatedBlog.getId();
        return blogService.updateBlog(id, updatedBlog);
    }

    // Delete blog
    @DeleteMapping("/{id}")
    public boolean deleteBlog(@PathVariable Long id) {
        return blogService.deleteBlog(id);
    }

}
