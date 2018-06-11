package kr.ac.jejunu.project.controller;

import kr.ac.jejunu.project.bus.BusSchedule;
import kr.ac.jejunu.project.bus.JnuBusSchedule;
import kr.ac.jejunu.project.bus.JnuBusStation;
import kr.ac.jejunu.project.dao.BusScheduleDao;
import kr.ac.jejunu.project.dao.JnuBusScheduleDao;
import kr.ac.jejunu.project.dao.JnuBusStationDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;
import java.util.LinkedList;

@Controller
@RequestMapping("/bus_one")
public class BusOneController {
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        int index = 0;

        model.addAttribute("busScheduleList", getBusSchedule());
        model.addAttribute("busSchedule.scheduleNo", getBusSchedule().get(index).getScheduleNo());
        model.addAttribute("busSchedule.lineId", getBusSchedule().get(index).getLineId());
        model.addAttribute("busSchedule.departureTime", getBusSchedule().get(index).getDepartureTime());
        model.addAttribute("busSchedule.day", getBusSchedule().get(index).getDay());

        return "bus_one";
    }

    private LinkedList<BusSchedule> getBusSchedule() {
        BusScheduleDao busScheduleDao = new BusScheduleDao();

        LinkedList<BusSchedule> busSchedules = null;
        try {
            busSchedules = busScheduleDao.get();
            for (BusSchedule b : busSchedules) {
                System.out.println(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return busSchedules;
    }
}
