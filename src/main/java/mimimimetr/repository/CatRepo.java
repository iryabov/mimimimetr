package mimimimetr.repository;

import org.springframework.data.repository.CrudRepository;

import mimimimetr.entity.Cat;


public interface CatRepo extends CrudRepository<Cat, Long> {

}
