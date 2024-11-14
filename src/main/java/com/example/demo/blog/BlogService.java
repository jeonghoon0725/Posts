package com.example.demo.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    // Create
    public Blog createBlog(Blog blog) {
        blog.setCdate(LocalDateTime.now());
        blog.setMdate(LocalDateTime.now());
        return blogRepository.save(blog);
    }

    // Read
    public List<Blog> getAllBlogs() {
        System.out.println("-------");

        List<Blog> posts = blogRepository.findAll();

        System.out.println(posts.toString());

        return posts;
    }

    public Blog getBlogById(Long id) {
        Optional<Blog> blog = blogRepository.findById(id);
        return blog.orElse(null);
    }

    // Update
    public Blog updateBlog(Long id, Blog updatedBlog) {
        if (blogRepository.existsById(id)) {
            updatedBlog.setId(id);
            updatedBlog.setMdate(LocalDateTime.now()); // 수정일 갱신
            return blogRepository.save(updatedBlog);
        }
        return null;
    }

    // Delete
    public boolean deleteBlog(Long id) {
        if (blogRepository.existsById(id)) {
            blogRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
