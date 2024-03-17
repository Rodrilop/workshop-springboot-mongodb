package com.rcslopes.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rcslopes.workshopmongo.domain.Post;
import com.rcslopes.workshopmongo.domain.User;
import com.rcslopes.workshopmongo.dto.AuthorDTO;
import com.rcslopes.workshopmongo.repository.PostRepository;
import com.rcslopes.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
				
		User maria = new User(null, "Maria Laura", "maria@gmail.com"); 
		User anne = new User(null, "Anne Moura", "anne@gmail.com"); 
		User rodrigo = new User(null, "Rodrigo Lopes", "rodrilop@gmail.com"); 
		
		userRepository.saveAll(Arrays.asList(maria,anne,rodrigo));
		
		Post post1 = new Post(null, sdf.parse("14/03/2024"), "Partiu São Paulo", "Bora ver o Coringão jogar", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("15/03/2024"), "Bom dia", "Hoje o dia está maravilhoso", new AuthorDTO (maria));
	
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1,post2));
		userRepository.save(maria);
			
	}
	
}
