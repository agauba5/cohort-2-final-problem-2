package edu.cnm.deepdive.springdatarestpeople.group;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * Interface for the Group object
 */
@RepositoryRestResource(collectionResourceRel = "groups", path = "groups")
public interface GroupRepository extends CrudRepository<Group, Long> {

  List<Group> findByName(@Param("name") String name);

}
