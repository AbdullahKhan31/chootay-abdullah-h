package com.chootay.repositories;

import com.chootay.models.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeRepository  extends JpaRepository<Bike, Integer> {
}
