package edu.cnm.deepdive.springdatarestpeople.group;


import edu.cnm.deepdive.springdatarestpeople.membership.Membership;
import edu.cnm.deepdive.springdatarestpeople.person.Person;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Group entity : formats the list of groups
 */
@Entity(name = "Cohort" )
public class Group {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private long id;

  private String name;

  @Column(nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Date created;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "group", cascade = CascadeType.ALL)
  private List<Membership> memberships = new LinkedList<>();

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "founder_id")
  private Person person;


  /**
   *
   * @return Returns the generated id
   */
  public long getId() {
    return id;
  }

  /**
   *
   * @return Returns the name of the group
   */
  public String getName() {
    return name;
  }

  /**
   *
   * @param name sets the name of the group
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   *
   * @return returns the Timestamp of when the group was created
   */
  public Date getCreated() {
    return created;
  }


  /**
   *
   * @return returns a list of memberships from the group
   */
  public List<Membership> getMemberships() {
    return memberships;
  }

  /**
   *
   * @param memberships sets a membership to the group
   */
  public void setMemberships(
      List<Membership> memberships) {
    this.memberships = memberships;
  }

  /**
   *
   * @return returns a person from the group
   */
  public Person getPerson() {
    return person;
  }

  /**
   *
   * @param person sets a person to the group
   */
  public void setPerson(Person person) {
    this.person = person;
  }
}
