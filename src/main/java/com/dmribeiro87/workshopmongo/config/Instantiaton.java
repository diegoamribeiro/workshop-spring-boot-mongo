package com.dmribeiro87.workshopmongo.config;

import com.dmribeiro87.workshopmongo.domain.Post;
import com.dmribeiro87.workshopmongo.domain.User;
import com.dmribeiro87.workshopmongo.dto.AuthorDTO;
import com.dmribeiro87.workshopmongo.dto.CommentDTO;
import com.dmribeiro87.workshopmongo.repository.PostRepository;
import com.dmribeiro87.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiaton implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void run(String... args) throws Exception {

        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post p1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo, Abraços!!", new AuthorDTO(maria));
        Post p2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Hoje eu acordei feliz!!", new AuthorDTO(maria));
        Post p3 = new Post(null, sdf.parse("17/05/2018"), "Hoje é o meu aniversário", "Parabéns para mim!!", new AuthorDTO(alex));

        CommentDTO c1 = new CommentDTO("Boa viagem, mana", sdf.parse("21/03/2018"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("21/03/2018"), new AuthorDTO(alex));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia", sdf.parse("22/03/2018"), new AuthorDTO(alex));

        p1.getComments().addAll(Arrays.asList(c1, c2));
        p2.getComments().addAll(Arrays.asList(c3));
        postRepository.saveAll(Arrays.asList(p1, p2, p3));

        maria.getPosts().addAll(Arrays.asList(p1, p2));
        userRepository.save(maria);

    }
}
