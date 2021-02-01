package com.chootay.repositories;

import com.chootay.models.Sparepart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SparepartRepository  extends JpaRepository<Sparepart, Integer> {
}
