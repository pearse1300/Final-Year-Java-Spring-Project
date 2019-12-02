package io.PearseMcLaughlin.FrameDataTool.FrameDataTool;

import io.PearseMcLaughlin.FrameDataTool.FrameDataTool.Repository.FrameDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackageClasses = FrameDataRepository.class)
@SpringBootApplication
public class FrameDataToolApplication {

	private static final Logger log = LoggerFactory.getLogger(FrameDataToolApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FrameDataToolApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner demo(FrameDataRepository repo){
//		return(args) -> {
//			log.info("frames found with find all");
//			log.info("---------------------------");
//			for (CharacterFrameData frames : repo.findAll()){
//				log.info(frames.toString());
//			}
//			log.info("");
//		};
//	}

}
