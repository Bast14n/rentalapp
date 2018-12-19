package pl.surowka.carrental.rentalapp.carcatalog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
	
	@Autowired
	CarRepository carRepository;
	
	@GetMapping("/cars")
	List<Car> list(){
		return carRepository.findAll();
	}
	
	@PostMapping("/cars")
	void create(@RequestBody Car car) {
		carRepository.save(car);
		
	}
	
	@GetMapping("/cars/{id}")
	Car detalis(@PathVariable String id) {
		
		return carRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("no such car"));
	}
	
	@DeleteMapping("/cars/{id}")
	void delete(@PathVariable String id) {
		carRepository.deleteById(id);
	}
	
	@PutMapping("/cars/{id}")
	void update(@PathVariable String id,@RequestBody Car car) {
		Car loaded = carRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("no such car"));
		
		loaded.setCapacity(car.getCapacity());
		loaded.setModel(car.getModel());
		loaded.setYearOfManufacture(car.getYearOfManufacture());
		loaded.setSegment(car.getSegment());
		loaded.setName(car.getName());
		
		carRepository.save(loaded);
		
	}
}
