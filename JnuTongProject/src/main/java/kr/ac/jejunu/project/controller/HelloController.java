package kr.ac.jejunu.project.controller;

import kr.ac.jejunu.project.bus.BusLineInfo;
import kr.ac.jejunu.project.bus.BusSchedule;
import kr.ac.jejunu.project.bus.JnuBusSchedule;
import kr.ac.jejunu.project.bus.JnuBusStation;
import kr.ac.jejunu.project.dao.BusLineInfoDao;
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
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model){
        int index = 0;

        model.addAttribute("jnuBusStationList", getJnuBusStation());
        model.addAttribute("jnuBusStation.id", getJnuBusStation().get(index).getId());
        model.addAttribute("jnuBusStation.name", getJnuBusStation().get(index).getName());

        model.addAttribute("jnuBusScheduleList", getJnuBusSchedule());
        model.addAttribute("jnuBusSchedule.id", getJnuBusSchedule().get(index).getId());
        model.addAttribute("jnuBusSchedule.departuretime", getJnuBusSchedule().get(index).getDepartureTime());
        model.addAttribute("jnuBusSchedule.course", getJnuBusSchedule().get(index).getCourse());
        model.addAttribute("jnuBusSchedule.gooceanscience", getJnuBusSchedule().get(index).getGoOceanScience());

        model.addAttribute("busLineInfoList", getBusLineInfo());
        model.addAttribute("busLineInfo.lineId", getBusLineInfo().get(index).getLineId());
        model.addAttribute("busLineInfo.lineNo", getBusLineInfo().get(index).getLineNo());
        model.addAttribute("busLineInfo.detailLineNo", getBusLineInfo().get(index).getDetailLineNo());
        model.addAttribute("busLineInfo.description", getBusLineInfo().get(index).getDescription());

        model.addAttribute("busScheduleList", getBusSchedule());
        model.addAttribute("busSchedule.scheduleNo", getBusSchedule().get(index).getScheduleNo());
        model.addAttribute("busSchedule.lineId", getBusSchedule().get(index).getLineId());
        model.addAttribute("busSchedule.departureTime", getBusSchedule().get(index).getDepartureTime());
        model.addAttribute("busSchedule.day", getBusSchedule().get(index).getDay());

        return "hello";
    }

    private LinkedList<JnuBusStation> getJnuBusStation() {
        JnuBusStationDao jnuBusStationDao = new JnuBusStationDao();

        LinkedList<JnuBusStation> jnuBusStations = null;
        try {
            jnuBusStations = jnuBusStationDao.get();
            /*for (JnuBusStation j : jnuBusStations) {
                System.out.println(j);
            }*/
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jnuBusStations;
    }

    private LinkedList<BusLineInfo> getBusLineInfo() {
        BusLineInfoDao busLineInfoDao = new BusLineInfoDao();

        LinkedList<BusLineInfo> busLineInfos = null;
        try {
            busLineInfos = busLineInfoDao.get();
            /*for (BusLineInfo b : busLineInfos) {
                System.out.println(b);
            }*/
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return busLineInfos;
    }

    private LinkedList<JnuBusSchedule> getJnuBusSchedule() {
        JnuBusScheduleDao jnuBusScheduleDao = new JnuBusScheduleDao();

        LinkedList<JnuBusSchedule> jnuBusSchedules = null;
        try {
            jnuBusSchedules = jnuBusScheduleDao.getOrigin();
            /*for (JnuBusSchedule j : jnuBusSchedules) {
                System.out.println(j);
            }*/
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return jnuBusSchedules;
    }

    private LinkedList<BusSchedule> getBusSchedule() {
        BusScheduleDao busScheduleDao = new BusScheduleDao();

        LinkedList<BusSchedule> busSchedules = null;
        try {
            busSchedules = busScheduleDao.getOrigin();
            /*for (BusSchedule b : busSchedules) {
                System.out.println(b);
            }*/
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return busSchedules;
    }
}
