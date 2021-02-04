package com.codegym.airbnb.repositories;

import com.codegym.airbnb.model.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface HomeRepository extends CrudRepository<Room, Long> {

    @Query("SELECT h FROM Room h")
    Iterable<Room> findAllCustomQuery();
    @Query("SELECT h FROM Room h where province_id = 1")
    Iterable<Room> findAllRoomByProvinceId(int id);

//    @Query("SELECT h.id, h.name, h.description, h.address, h.pricePerNight, h.numBedrooms, h.numBathrooms FROM Home h WHERE h.id = ?1")
    @Query(value = "SELECT id, name, description, address, price_per_night, total_of_bedroom, total_of_bathroom, province_id, property_type          , user_id FROM rooms WHERE id = ?1", nativeQuery = true)
    Optional<Room> findByHomeId(Long id);

}
