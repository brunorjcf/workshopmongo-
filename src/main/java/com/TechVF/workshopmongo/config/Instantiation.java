package com.TechVF.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.TechVF.workshopmongo.domain.Post;
import com.TechVF.workshopmongo.domain.User;
import com.TechVF.workshopmongo.repository.PostRepository;
import com.TechVF.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User Alex = new User(null, "Alex Green", "alex@gmail.com");
		User Bob = new User(null, "Bob Marley", "bob@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("23/03/2020"), "Partiu viagem", "Vou viajar para Portugal. Abraços!", maria);
		Post post2 = new Post(null, sdf.parse("24/03/2020"), "Bom dia!", "Acordei feliz hoje!", maria);
		
		userRepository.saveAll(Arrays.asList(maria, Alex, Bob));
		postRepository.saveAll(Arrays.asList(post1, post2));
	}
}
