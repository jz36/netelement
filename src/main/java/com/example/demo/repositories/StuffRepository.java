package com.example.demo.repositories;

import com.example.demo.entity.Stuff;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StuffRepository extends CrudRepository<Stuff, Integer> {

    List<Stuff> findAllByDivisionId(Integer divisionId);

    @Query(value = "SELECT * from stuff_schema.stuff t where LOWER(t.stuff_name) like '%' || LOWER(:searched) ||'%'", nativeQuery = true)
    List<Stuff> findAllByFioLike(@Param("searched") String searched);
}
