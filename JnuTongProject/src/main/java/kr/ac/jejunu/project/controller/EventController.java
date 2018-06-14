package kr.ac.jejunu.project.controller;

import kr.ac.jejunu.project.bus.BusSchedule;
import kr.ac.jejunu.project.dao.BusScheduleDao;
import kr.ac.jejunu.project.dao.JnuEventDao;
import kr.ac.jejunu.project.event.JnuEvent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;
import java.util.LinkedList;

@Controller
@RequestMapping(method = RequestMethod.GET)
public class EventController {
    @RequestMapping("/etc")
    public String index(Model model) {
        int index = 0;

        model.addAttribute("jnuBusScheduleList", getEventSchedule());
        model.addAttribute("jnuEventSchedule.date", getEventSchedule().get(index).getDate());
        model.addAttribute("jnuEventSchedule.name", getEventSchedule().get(index).getName());

        return "etc";
    }

    private LinkedList<JnuEvent> getEventSchedule() {
        JnuEventDao jnuEventDao = new JnuEventDao();

        LinkedList<JnuEvent> jnuEvents = null;
        try {
            jnuEvents = jnuEventDao.get();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return jnuEvents;
    }
}
