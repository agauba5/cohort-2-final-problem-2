package edu.cnm.deepdive.springdatarestpeople.person;

import edu.cnm.deepdive.springdatarestpeople.group.Group;
import edu.cnm.deepdive.springdatarestpeople.membership.Membership;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Person Entity : formats the list of people
 */
@Entity(name = "Person")
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String name;

  @Column(nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Date created;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "person", cascade = CascadeType.ALL)
  private List<Membership> memberships = new LinkedList<>();

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "person", cascade = CascadeType.ALL)
  private List<Group> groups = new LinkedList<>();

  /**
   * Empty constructor
   */
  public Person(){

  }

  /**
   * Overloaded method
   * @param name input of the persons name
   */
  public Person(String name){
    this.name = name;

  }

  /**
   *
   * @return gets the generated id
   */
  public long getId() {
    return id;
  }

  /**
   *
   * @return returns the Timestamp of when the person was created
   */
  public Date getCreated() {
    return created;
  }

  /**
   *
   * @return returns the name of the person
   */
  public String getName() {
    return name;
  }

  /**
   *
   * @param name sets the name of the person
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   *
   * @return returns a list of the memberships the person has
   */
  public List<Membership> getMemberships() {
    return memberships;
  }

  /**
   *
   * @param memberships sets the membership to the person the has
   */
  public void setMemberships(
      List<Membership> memberships) {
    this.memberships = memberships;
  }

  /**
   *
   * @return returns  a list of groups the person founded
   */
  public List<Group> getGroups() {
    return groups;
  }

  /**
   *
   * @param groups sets the groups the person belongs to
   */
  public void setGroups(List<Group> groups) {
    this.groups = groups;
  }
}
