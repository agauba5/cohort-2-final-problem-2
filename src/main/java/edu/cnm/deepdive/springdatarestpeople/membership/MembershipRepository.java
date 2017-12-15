package edu.cnm.deepdive.springdatarestpeople.membership;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Interface for the Membership object
 */
@RepositoryRestResource(collectionResourceRel = "memberships", path = "memberships")
public interface MembershipRepository extends CrudRepository<Membership, Long> {

}
