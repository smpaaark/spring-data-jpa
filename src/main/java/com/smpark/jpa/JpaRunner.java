package com.smpark.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

	@Autowired
	PostRepository postRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Post post = new Post();
		post.setTitle("Spring Data JPA 언제 보나...");

		Comment comment = new Comment();
		comment.setComment("빨리 보고 싶어요.");
		post.addComment(comment);

		Comment comment1 = new Comment();
		comment1.setComment("곧 보여드릴게요.");
		post.addComment(comment1);

		postRepository.save(post);
		postRepository.findAll().forEach(System.out::println);
	}
	
}
