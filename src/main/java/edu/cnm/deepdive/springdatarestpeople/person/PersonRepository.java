package edu.cnm.deepdive.springdatarestpeople.person;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Interface for the Person object
 */
@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends CrudRepository<Person, Long> {

  /**
   *
   * @param name
   * @return
   */
  List<Person> findPersonByName(@Param("name") String name);

}
