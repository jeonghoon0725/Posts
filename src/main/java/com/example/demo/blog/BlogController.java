package com.example.demo.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
        List<Blog> posts =  blogService.getAllBlogs();
        return posts;
    }

    // Get blog by ID
    @GetMapping("/{id}")
    public Blog getBlogById(@PathVariable Long id) {
        return blogService.getBlogById(id);
    }

    // Update blog
    @PutMapping("/{id}")
    public Blog updateBlog(@PathVariable Long id, @RequestBody Blog updatedBlog) {
        return blogService.updateBlog(id, updatedBlog);
    }

    // Delete blog
    @DeleteMapping("/{id}")
    public boolean deleteBlog(@PathVariable Long id) {
        return blogService.deleteBlog(id);
    }

}
