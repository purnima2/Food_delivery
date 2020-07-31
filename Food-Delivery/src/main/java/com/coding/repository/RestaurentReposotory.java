package com.coding.repository;

import com.coding.model.Restaurent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RestaurentReposotory extends JpaRepository<Restaurent,Long> {
    public List<Restaurent> getByRating(Integer rating);
}
