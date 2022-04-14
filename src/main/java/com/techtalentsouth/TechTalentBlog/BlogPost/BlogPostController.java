package com.techtalentsouth.TechTalentBlog.BlogPost;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogPostController {
	
	
public String index(BlogPost blogPost, Model model) {
    posts.removeAll(posts);
    for (BlogPost post : blogPostRepository.findAll()) {
    	posts.add(post);
    }
	
	@Autowired
	private BlogPostRepository blogPostRepository;
	private static List<BlogPost> posts = new ArrayList<>();
	
	private BlogPost blogPost;
	@PostMapping(value = "/")
	public String addNewBlogPost(BlogPost blogPost, Model model) {
	    blogPostRepository.save(blogPost);
	    posts.add(blogPost);
	    model.addAttribute("title", blogPost.getTitle());
	    model.addAttribute("author", blogPost.getAuthor());
	    model.addAttribute("blogEntry", blogPost.getBlogEntry());
	    return "blogpost/result";
	}
	@RequestMapping(value = "/blogposts/{id}", method = RequestMethod.DELETE)
	public String deletePostWithId(@PathVariable Long id, BlogPost blogPost) {

	    blogPostRepository.deleteById(id);
	    return "blogpost/index";

	}
}
