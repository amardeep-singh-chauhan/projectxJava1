package com.amardeep.projectx;

import com.amardeep.projectx.databases.ProdDB;
import com.amardeep.projectx.interfaces.DB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectxApplication implements CommandLineRunner {

    @Autowired
    private DB db;

    public static void main(String[] args) {
        SpringApplication.run(ProjectxApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(db.getData());
    }
}
