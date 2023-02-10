package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarServiceImpl implements CarService {

    private List<Car> cars;

     {
        cars = new ArrayList<>();

        cars.add(new Car((long) 1,"Nissan Murano", 2014));
        cars.add(new Car((long) 2,"Kia K5", 2020));
        cars.add(new Car((long) 3,"Kia Optima", 2018));
        cars.add(new Car((long) 4,"Mercedes Benz", 2013));
        cars.add(new Car((long) 5,"Reno Logan", 2010));
    }

    public List<Car> listCars(int count) {
        return cars.stream().limit(count).collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
