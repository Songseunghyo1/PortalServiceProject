package kr.ac.jejunu.project.controller;

import kr.ac.jejunu.project.bus.JnuBusStation;
import kr.ac.jejunu.project.dao.JnuBusStationDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;
import java.util.LinkedList;

@Controller
@RequestMapping("/hello")
public class JnuBusStationController {
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model){
        int index = 0;
        model.addAttribute("jnubusStaionList", getJnuBusSchedule());
        model.addAttribute("jnubusStaionList.id", getJnuBusSchedule().get(index).getId());
        model.addAttribute("jnubusStaionList.name", getJnuBusSchedule().get(index).getName());

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
