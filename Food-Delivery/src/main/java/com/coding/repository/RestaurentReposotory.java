package com.coding.repository;

import com.coding.model.Restaurent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurentReposotory extends JpaRepository<Restaurent,Long> {
    public List<Restaurent> getRestaurent(Integer rating, Double price);
    public List<Restaurent> getRestaurent(Integer rating);
    public List<Restaurent> getRestaurent(Double price);
}
