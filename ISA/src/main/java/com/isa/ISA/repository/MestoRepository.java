package com.isa.ISA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isa.ISA.model.Mesto;

public interface MestoRepository extends JpaRepository<Mesto, Long> {

}
