package kr.ac.jejunu.project.mvc;

import kr.ac.jejunu.project.bus.JnuBusSchedule;
import kr.ac.jejunu.project.bus.JnuBusStation;
import kr.ac.jejunu.project.dao.JnuBusScheduleDao;
import kr.ac.jejunu.project.dao.JnuBusStationDao;
import kr.ac.jejunu.project.dao.ManagerDao;
import kr.ac.jejunu.project.management.Manager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.sql.SQLException;
import java.util.LinkedList;

@Controller
@Configuration
@ComponentScan
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/bus_one").setViewName("bus_one");
        registry.addViewController("/weekday").setViewName("weekday");
        registry.addViewController("/holiday").setViewName("holiday");
        registry.addViewController("/everyday").setViewName("everyday");
        registry.addViewController("/bus_two").setViewName("bus_two");
        registry.addViewController("/acourse").setViewName("acourse");
        registry.addViewController("/bcourse").setViewName("bcourse");
        registry.addViewController("/etc").setViewName("etc");
    }
}