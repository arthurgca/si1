package models;

import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class Task extends Model {

  @Id
  public Long id;
  
  @Required(message="Campo obrigatório")
  public String label;
  @Required(message="Campo obrigatório")
  public String project;
  @Required(message="Campo obrigatório")
  public String description;
  @Required(message="Campo obrigatório")
  public int priority;
  
  public boolean status = false;

  
  public static Finder<Long,Task> find = new Finder(
    Long.class, Task.class
  );
  
  public static List<Task> all() {
	  return find.orderBy("priority asc").findList();
	}

	public static void create(Task task) {
	  task.save();
	}

	public static void delete(Long id) {
	  find.ref(id).delete();
	}

	public static void setDone(Long id) {
	  Task task = find.ref(id);
	  task.status = true;
	  task.update();
	}

}