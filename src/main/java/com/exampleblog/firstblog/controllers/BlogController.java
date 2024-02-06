package com.exampleblog.firstblog.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exampleblog.firstblog.models.Post;
import com.exampleblog.firstblog.repositories.PostRepository;

@Controller
public class BlogController {

  @Autowired
  private PostRepository postRepository;

  @GetMapping("/blog")
  public String blogMain(Model model) {
    Iterable<Post> posts = postRepository.findAll();
		model.addAttribute("posts", posts);
    return "blog-main";
  }

  @GetMapping("/blog/add")
  public String blogAdd(Model model) {
    return "blog-add";
  }

  @PostMapping("/blog/add")
  public String blogPostAdd(@RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model) {
    Post post = new Post(title, anons, full_text);
    postRepository.save(post);
    return "redirect:/blog";
  }

  @GetMapping("/blog/{id}")
  public String blogDetails(@PathVariable(value = "id") long id, Model model) {
    if(!postRepository.existsById(id)) {
      return "redirect:/blog";
    }
    
    Optional<Post> post = postRepository.findById(id);
    ArrayList<Post> result = new ArrayList<>();
    post.ifPresent(result::add);
    model.addAttribute("post", result);
    return "blog-details";
  }

  @GetMapping("/blog/{id}/edit")
  public String blogEdit(@PathVariable(value = "id") long id, Model model) {
    if(!postRepository.existsById(id)) {
      return "redirect:/blog";
    }
    
    Optional<Post> post = postRepository.findById(id);
    ArrayList<Post> result = new ArrayList<>();
    post.ifPresent(result::add);
    model.addAttribute("post", result);
    return "blog-edit";
  }

  @PostMapping("/blog/{id}/edit")
  public String blogPostUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model) {
    Post post = postRepository.findById(id).orElseThrow();
    post.setTitle(title);
    post.setAnons(anons);
    post.setFull_text(full_text);
    postRepository.save(post);
    return "redirect:/blog/{id}";
  }

  @SuppressWarnings("null")
  @PostMapping("/blog/{id}/remove")
  public String blogPostRemove(@PathVariable(value = "id") long id, Model model) {
    Post post = postRepository.findById(id).orElseThrow();
    postRepository.delete(post);
    return "redirect:/blog";
  }

}
