package com.techtalentsouth.TechTalentBlog.BlogPost;


import org.springframework.data.repository.CrudRepository;

public interface BlogPostRepository extends CrudRepository<BlogPost, Long>{
}

@Controller
public class BlogPostController {
	
    @Autowired
    private BlogPostRepository blogPostRepository;
	
    @GetMapping(value="/")
    public String index(BlogPost blogPost) {
	return "blogpost/index";
    }

    private BlogPost blogPost;
    
    @PostMapping(value = "/")
    public String addNewBlogPost(BlogPost blogPost, Model model) {
	blogPostRepository.save(new BlogPost(blogPost.getTitle(), blogPost.getAuthor(), blogPost.getBlogEntry()));
	model.addAttribute("title", blogPost.getTitle());
	model.addAttribute("author", blogPost.getAuthor());
	model.addAttribute("blogEntry", blogPost.getBlogEntry());
	return "blogpost/result";
    }
