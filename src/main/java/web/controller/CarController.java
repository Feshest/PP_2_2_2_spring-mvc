package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CarController {

    private final CarServiceImpl carService;

    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String showCars(HttpServletRequest request, ModelMap model) {
        String count = request.getParameter("count");
        if (count == null) {
            model.addAttribute("messages", carService.getCars());
        } else {
            model.addAttribute("messages", carService.listCars(Integer.parseInt(count)));
        }
        return "cars";
    }
}
