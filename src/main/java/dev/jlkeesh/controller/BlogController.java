package dev.jlkeesh.controller;

import dev.jlkeesh.dao.BlogDAO;
import dev.jlkeesh.domain.Blog;
import dev.jlkeesh.dto.blog.BlogCreateDTO;
import dev.jlkeesh.dto.blog.BlogDeleteDTO;
import dev.jlkeesh.dto.blog.BlogUpdateDTO;
import dev.jlkeesh.mapper.BlogMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    private final BlogDAO blogDAO;
    private final BlogMapper blogMapper;

    public BlogController(BlogDAO blogDAO, BlogMapper blogMapper) {
        this.blogDAO = blogDAO;
        this.blogMapper = blogMapper;
    }

    @GetMapping
    public String list(Model model) {
        List<Blog> blogs = blogDAO.getAll();
        model.addAttribute("blogs", blogs);
        return "blog/list";
    }

    @GetMapping("/create")
    public String createPage() {
        return "blog/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute BlogCreateDTO dto) {
        Blog blog = blogMapper.fromCreateDTO(dto);
        blogDAO.save(blog);
        return "redirect:/blog";
    }
    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable String id, Model model) {
        Blog blog = blogDAO.get(id);
        model.addAttribute("blog", blog);
        return "blog/edit";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute BlogUpdateDTO dto) {
        Blog blog = blogMapper.fromUpdateDTO(dto);
        blogDAO.update(blog);
        return "redirect:/blog";
    }
    @GetMapping("/delete/{id}")
    public String deletePage(@PathVariable String id, Model model) {
        Blog blog = blogDAO.get(id);
        model.addAttribute("blog", blog);
        return "blog/delete";
    }
    @PostMapping("/delete")
    public String delete(@ModelAttribute BlogDeleteDTO dto) {
        Blog blog = blogMapper.fromDeleteDTO(dto);
        blogDAO.delete(blog);
        return "redirect:/blog";
    }

    @GetMapping("/comment/{id}")
    public String commentPage(@PathVariable String id, Model model) {

        Blog blog = blogDAO.get(id);
        model.addAttribute("blog", blog);
//        model.addAttribute("user", ); TODO: get user from session
        return "blog/comment";
    }
    @PostMapping("/comment")
    public String comment(@ModelAttribute BlogUpdateDTO dto) {
        Blog blog = blogMapper.fromUpdateDTO(dto);
        blogDAO.update(blog);
        return "redirect:/blog";
    }
}
