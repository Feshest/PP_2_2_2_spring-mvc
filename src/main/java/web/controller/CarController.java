package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(@Qualifier("carBean") CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String showCars(@RequestParam(defaultValue = "5") String count, ModelMap model) {
        List<Car> cars = carService.listCars(Integer.parseInt(count));

        model.addAttribute("cars", cars);
        return "cars";
    }
}
