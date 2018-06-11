package kr.ac.jejunu.project.controller;

import kr.ac.jejunu.project.bus.JnuBusSchedule;
import kr.ac.jejunu.project.dao.JnuBusScheduleDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;
import java.util.LinkedList;

@Controller
@RequestMapping("/bus_two")
public class BusTwoController {
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        int index = 0;

        model.addAttribute("jnuBusScheduleList", getJnuBusSchedule());
        model.addAttribute("jnuBusSchedule.id", getJnuBusSchedule().get(index).getId());
        model.addAttribute("jnuBusSchedule.departuretime", getJnuBusSchedule().get(index).getDepartureTime());
        model.addAttribute("jnuBusSchedule.course", getJnuBusSchedule().get(index).getCourse());
        model.addAttribute("jnuBusSchedule.gooceanscience", getJnuBusSchedule().get(index).getGoOceanScience());

        return "bus_two";
    }

    private LinkedList<JnuBusSchedule> getJnuBusSchedule() {
        JnuBusScheduleDao jnuBusScheduleDao = new JnuBusScheduleDao();

        LinkedList<JnuBusSchedule> jnuBusSchedules = null;
        try {
            jnuBusSchedules = jnuBusScheduleDao.get();
            for (JnuBusSchedule j : jnuBusSchedules) {
                System.out.println(j);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return jnuBusSchedules;
    }
}