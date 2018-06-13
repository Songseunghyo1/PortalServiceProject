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
@RequestMapping(method = RequestMethod.GET)
public class BusTwoController {

    @RequestMapping("/bus_two")
    public String indexBusTwo(Model model) {
        int index = 0;

        model.addAttribute("jnuBusScheduleList", getJnuBusSchedule());
        model.addAttribute("jnuBusSchedule.id", getJnuBusSchedule().get(index).getId());
        model.addAttribute("jnuBusSchedule.departuretime", getJnuBusSchedule().get(index).getDepartureTime());
        model.addAttribute("jnuBusSchedule.course", getJnuBusSchedule().get(index).getCourse());
        model.addAttribute("jnuBusSchedule.gooceanscience", getJnuBusSchedule().get(index).getGoOceanScience());

        return "bus_two";
    }

    @RequestMapping("/bus_two/acourse")
    public String indexACourse(Model model) {
        int index = 0;

        model.addAttribute("jnuBusScheduleList", getJnuBusScheduleACourse());
        model.addAttribute("jnuBusSchedule.id", getJnuBusScheduleACourse().get(index).getId());
        model.addAttribute("jnuBusSchedule.departuretime", getJnuBusScheduleACourse().get(index).getDepartureTime());
        model.addAttribute("jnuBusSchedule.course", getJnuBusScheduleACourse().get(index).getCourse());
        model.addAttribute("jnuBusSchedule.gooceanscience", getJnuBusScheduleACourse().get(index).getGoOceanScience());

        return "acourse";
    }

    @RequestMapping("/bus_two/bcourse")
    public String indexBCourse(Model model) {
        int index = 0;

        model.addAttribute("jnuBusScheduleList", getJnuBusScheduleBCourse());
        model.addAttribute("jnuBusSchedule.id", getJnuBusScheduleBCourse().get(index).getId());
        model.addAttribute("jnuBusSchedule.departuretime", getJnuBusScheduleBCourse().get(index).getDepartureTime());
        model.addAttribute("jnuBusSchedule.course", getJnuBusScheduleBCourse().get(index).getCourse());
        model.addAttribute("jnuBusSchedule.gooceanscience", getJnuBusScheduleBCourse().get(index).getGoOceanScience());

        return "bcourse";
    }

    private LinkedList<JnuBusSchedule> getJnuBusSchedule() {
        JnuBusScheduleDao jnuBusScheduleDao = new JnuBusScheduleDao();

        LinkedList<JnuBusSchedule> jnuBusSchedules = null;
        try {
            jnuBusSchedules = jnuBusScheduleDao.getOrigin();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return jnuBusSchedules;
    }

    private LinkedList<JnuBusSchedule> getJnuBusScheduleACourse() {
        JnuBusScheduleDao jnuBusScheduleDao = new JnuBusScheduleDao();

        LinkedList<JnuBusSchedule> jnuBusSchedules = null;
        try {
            jnuBusSchedules = jnuBusScheduleDao.getACourse();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return jnuBusSchedules;
    }

    private LinkedList<JnuBusSchedule> getJnuBusScheduleBCourse() {
        JnuBusScheduleDao jnuBusScheduleDao = new JnuBusScheduleDao();

        LinkedList<JnuBusSchedule> jnuBusSchedules = null;
        try {
            jnuBusSchedules = jnuBusScheduleDao.getBCourse();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return jnuBusSchedules;
    }
}
