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
  @Column(columnDefinition = "TEXT") // Define a coluna descricao como um text o
  public String description;
  
  @Required(message="Campo obrigatório")
  @Min(value = 1, message = "Prioridade tem que ser maior ou igual a 1")
  public int priority;
  
  public boolean status = false;

  
  public static Finder<Long,Task> find = new Finder(
    Long.class, Task.class
  );
  

public static List<Task> all() {
	  return find.orderBy("priority asc").findList(); 
	  //Retorna lista de tarefas ordenada pelo banco de dados com o atributo priority em ascendência 
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