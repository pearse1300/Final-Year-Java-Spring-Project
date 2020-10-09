package io.PearseMcLaughlin.FrameDataTool.FrameDataTool;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class FrameDataToolApplication {

	private static final Logger log = LoggerFactory.getLogger(FrameDataToolApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FrameDataToolApplication.class, args);
	}

}
