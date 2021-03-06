package kr.ac.jejunu.project.controller;

import kr.ac.jejunu.project.bus.BusSchedule;
import kr.ac.jejunu.project.dao.BusScheduleDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;
import java.sql.Time;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(method = RequestMethod.GET)
public class BusOneController {
    @RequestMapping("/bus_one")
    public String index(Model model) {
        int index = 0;

        model.addAttribute("busScheduleList", getOriginBusSchedule());
        model.addAttribute("busSchedule.scheduleNo", getOriginBusSchedule().get(index).getScheduleNo());
        model.addAttribute("busSchedule.lineId", getOriginBusSchedule().get(index).getLineId());
        model.addAttribute("busSchedule.departureTime", getOriginBusSchedule().get(index).getDepartureTime());
        model.addAttribute("busSchedule.day", getOriginBusSchedule().get(index).getDay());

        return "bus_one";
    }

    /** localhost:8080/bus_one/weekday
     *
     * */
    @RequestMapping("/bus_one/weekday")
    public String indexSemester(Model model) {
        int index = 0;

        model.addAttribute("busScheduleList", getWeekdayBusSchedule());
        model.addAttribute("busSchedule.scheduleNo", getWeekdayBusSchedule().get(index).getScheduleNo());
        model.addAttribute("busSchedule.lineId", getWeekdayBusSchedule().get(index).getLineId());
        model.addAttribute("busSchedule.departureTime", getWeekdayBusSchedule().get(index).getDepartureTime());
        model.addAttribute("busSchedule.day", getWeekdayBusSchedule().get(index).getDay());

        return "weekday";
    }

    /** localhost:8080/bus_one/holiday
     *
     * */
    @RequestMapping("/bus_one/holiday")
    public String indexHoliday(Model model) {
        int index = 0;

        model.addAttribute("busScheduleList", getHolidayBusSchedule());
        model.addAttribute("busSchedule.scheduleNo", getHolidayBusSchedule().get(index).getScheduleNo());
        model.addAttribute("busSchedule.lineId", getHolidayBusSchedule().get(index).getLineId());
        model.addAttribute("busSchedule.departureTime", getHolidayBusSchedule().get(index).getDepartureTime());
        model.addAttribute("busSchedule.day", getHolidayBusSchedule().get(index).getDay());

        return "holiday";
    }

    /** localhost:8080/bus_one/everyday
     *
     * */
    @RequestMapping("/bus_one/everyday")
    public String indexEveryday(Model model) {
        int index = 0;

        model.addAttribute("busScheduleList", getEverydayBusSchedule());
        model.addAttribute("busSchedule.scheduleNo", getEverydayBusSchedule().get(index).getScheduleNo());
        model.addAttribute("busSchedule.lineId", getEverydayBusSchedule().get(index).getLineId());
        model.addAttribute("busSchedule.departureTime", getEverydayBusSchedule().get(index).getDepartureTime());
        model.addAttribute("busSchedule.day", getEverydayBusSchedule().get(index).getDay());

        return "everyday";
    }

    /** localhost:8080/bus_one/editweekday
     *
     * */
    @RequestMapping("/bus_one/editweekday")
    public String indexEditWeekday(Model model) {
        int index = 0;

        model.addAttribute("busScheduleList", getWeekdayBusSchedule());
        model.addAttribute("busSchedule.scheduleNo", getWeekdayBusSchedule().get(index).getScheduleNo());
        model.addAttribute("busSchedule.lineId", getWeekdayBusSchedule().get(index).getLineId());
        model.addAttribute("busSchedule.departureTime", getWeekdayBusSchedule().get(index).getDepartureTime());
        model.addAttribute("busSchedule.day", getWeekdayBusSchedule().get(index).getDay());

        return "editweekday";
    }



    /** localhost:8080/bus_one/editeveryday
     *
     * */
    @RequestMapping("/bus_one/editeveryday")
    public String indexEditEveryday(Model model) {
        int index = 0;

        model.addAttribute("busScheduleList", getEverydayBusSchedule());
        model.addAttribute("busSchedule.scheduleNo", getEverydayBusSchedule().get(index).getScheduleNo());
        model.addAttribute("busSchedule.lineId", getEverydayBusSchedule().get(index).getLineId());
        model.addAttribute("busSchedule.departureTime", getEverydayBusSchedule().get(index).getDepartureTime());
        model.addAttribute("busSchedule.day", getEverydayBusSchedule().get(index).getDay());

        return "editeveryday";
    }

    /** localhost:8080/bus_one/editeveryday
     *
     * */
    @RequestMapping("/bus_one/editholiday")
    public String indexEditHoliday(Model model) {
        int index = 0;

        model.addAttribute("busScheduleList", getHolidayBusSchedule());
        model.addAttribute("busSchedule.scheduleNo", getHolidayBusSchedule().get(index).getScheduleNo());
        model.addAttribute("busSchedule.lineId", getHolidayBusSchedule().get(index).getLineId());
        model.addAttribute("busSchedule.departureTime", getHolidayBusSchedule().get(index).getDepartureTime());
        model.addAttribute("busSchedule.day", getHolidayBusSchedule().get(index).getDay());

        return "editholiday";
    }
    private LinkedList<BusSchedule> getOriginBusSchedule() {
        BusScheduleDao busScheduleDao = new BusScheduleDao();

        LinkedList<BusSchedule> busSchedules = null;
        try {
            busSchedules = busScheduleDao.getOrigin();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return busSchedules;
    }

    private LinkedList<BusSchedule> getEverydayBusSchedule() {
        BusScheduleDao busScheduleDao = new BusScheduleDao();

        LinkedList<BusSchedule> busSchedules = null;
        try {
            busSchedules = busScheduleDao.getEveryday();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return busSchedules;
    }

    private LinkedList<BusSchedule> getWeekdayBusSchedule() {
        BusScheduleDao busScheduleDao = new BusScheduleDao();

        LinkedList<BusSchedule> busSchedules = null;
        try {
            busSchedules = busScheduleDao.getWeekday();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return busSchedules;
    }

    private LinkedList<BusSchedule> getHolidayBusSchedule() {
        BusScheduleDao busScheduleDao = new BusScheduleDao();

        LinkedList<BusSchedule> busSchedules = null;
        try {
            busSchedules = busScheduleDao.getHoliday();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return busSchedules;
    }
}
