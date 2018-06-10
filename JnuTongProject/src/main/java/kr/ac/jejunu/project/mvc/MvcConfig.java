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
        registry.addViewController("/bus_two").setViewName("bus_two");
        registry.addViewController("/etc").setViewName("etc");
    }

    @RequestMapping("/hello")
    public String index(Model model) throws SQLException, ClassNotFoundException {
        int index = 0;
        model.addAttribute("jnubusStaionList", getJnuBusSchedule());
        /*model.addAttribute("jnuBusStation.id", getJnuBusSchedule().get(index).getId());
        model.addAttribute("jnuBusStation.name", getJnuBusSchedule().get(index).getName());
        index += 1;*/
        return "hello";
    }

    private LinkedList<JnuBusStation> getJnuBusSchedule() {
        JnuBusStationDao jnuBusStationDao = new JnuBusStationDao();

        LinkedList<JnuBusStation> jnuBusStations = null;
        try {
            jnuBusStations = jnuBusStationDao.get();
            for (JnuBusStation j : jnuBusStations) {
                System.out.println(j);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jnuBusStations;
    }
}