package com.lenskartapp.repository;

import com.lenskartapp.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface IBrandRepository extends JpaRepository<Brand, Integer> {
}
