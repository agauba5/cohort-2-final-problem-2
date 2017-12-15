package edu.cnm.deepdive.springdatarestpeople.membership;

import edu.cnm.deepdive.springdatarestpeople.group.Group;
import edu.cnm.deepdive.springdatarestpeople.person.Person;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Membership Entity : formats the list of members
 */
@Entity(name = "MembersList")
public class Membership {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private long id;

  @Column(nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Date created;


  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "person_id")
  private Person person;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "group_id")
  private Group group;


  /**
   *
   * @return gets the generated id
   */
  public long getId() {
    return id;
  }

  /**
   *
   * @return returns the Timestamp of when the membership was created
   */
  public Date getCreated() {
    return created;
  }

  /**
   *
   * @return returns a person from the membership list
   */
  public Person getPerson() {
    return person;
  }

  /**
   *
   * @param person sets a person to the membership list
   */

  public void setPerson(Person person) {
    this.person = person;
  }

  /**
   *
   * @return returns a group from the membership list
   */
  public Group getGroup() {
    return group;
  }
  /**
   *
   * @param group sets a group to the membership list
   */
  public void setGroup(Group group) {
    this.group = group;
  }
}

