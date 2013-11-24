package models;

import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class Task extends Model {

  @Id
  private Long id;
  
  @Required(message="Campo obrigatório")
  private String label;
  
  @Required(message="Campo obrigatório")
  private String project;
  
  @Required(message="Campo obrigatório")
  @Column(columnDefinition = "TEXT") // Define a coluna descricao como um text o
  private String description;
  
  @Required(message="Campo obrigatório")
  @Min(value = 1, message = "Prioridade tem que ser maior ou igual a 1")
  private int priority;
  
  private boolean isDone = false;

  
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
	  task.setDone(true);
	  task.update();
	}

	private void setDone(boolean b) {
		this.isDone = true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public boolean isDone() {
		return isDone;
	}

	

}