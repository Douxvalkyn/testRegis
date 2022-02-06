package com.example;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entities.Prenom;
import com.example.repositories.PrenomRepository;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Controller
@SpringBootApplication
public class Main {

  @Value("${spring.datasource.url}")
  private String dbUrl;

  @Autowired
  private DataSource dataSource;

  static Logger mainLog = LoggerFactory.getLogger(Main.class);
	
	
  public static void main(String[] args) throws Exception {
    SpringApplication.run(Main.class, args);
  }
  
  @Autowired
  private ApplicationContext appContext;

  @RequestMapping("/")
  String index() {
    return "index";
  }
  
  
  @RequestMapping("/test")
  String test() {
    return "test";
  }
  
  public void run(String... args) {
	  PrenomRepository prenomRepo = appContext.getBean(PrenomRepository.class);
	  Iterable<Prenom> prenoms = prenomRepo.findAll();
		List<Prenom> results = new ArrayList<Prenom>();
		for (Prenom p:prenoms) {
			results.add(p);
		}

	  mainLog.info("size  " + results.size());
		Prenom p1=new Prenom();
		  p1.setEffectif(25);
		  p1.setLibelle("Aude");
		  results.add(p1);
		  mainLog.info("p1  " + p1);
	  prenomRepo.save(p1);
	
}
  


//  @RequestMapping("/db")
//  String db(Map<String, Object> model) {
//    try (Connection connection = dataSource.getConnection()) {
//      Statement stmt = connection.createStatement();
//      stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
//      stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
//      ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");
//
//      ArrayList<String> output = new ArrayList<String>();
//      while (rs.next()) {
//        output.add("Read from DB: " + rs.getTimestamp("tick"));
//      }
//
//      model.put("records", output);
//      return "db";
//    } catch (Exception e) {
//      model.put("message", e.getMessage());
//      return "error";
//    }
//  }

//  @Bean
//  public DataSource dataSource() throws SQLException {
//    if (dbUrl == null || dbUrl.isEmpty()) {
//      return new HikariDataSource();
//    } else {
//      HikariConfig config = new HikariConfig();
//      config.setJdbcUrl(dbUrl);
//      return new HikariDataSource(config);
//    }
//  }

}
