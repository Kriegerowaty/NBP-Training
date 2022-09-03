package com.example.nbptraining.Repository;

import com.example.nbptraining.Entity.NbpEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NbpRepository extends JpaRepository<NbpEntity,Long> {
}
