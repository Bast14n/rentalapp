package pl.surowka.carrental.rentalapp.carcatalog;

import org.springframework.data.jpa.repository.JpaRepository;

interface CarRepository extends JpaRepository<Car,String> {

}
