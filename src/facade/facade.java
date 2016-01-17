/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import Entity.Project;
import Entity.ProjectUser;
import Entity.Task;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author bechw
 */
public class facade {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    Date date = new Date(2016, 01, 12);
   
    public void createUser(){
        EntityManager em = emf.createEntityManager();
        ProjectUser user = new ProjectUser("username","email",date);
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }
    
    public void createProject(){
        EntityManager em = emf.createEntityManager();
        Project project = new Project("name","description",date, date);
        em.getTransaction().begin();
        em.persist(project);
        em.getTransaction().commit();
        em.close();
    }
    
    public void createTask(){
        EntityManager em = emf.createEntityManager();
        Task task = new Task("name","description",3,3);
        em.getTransaction().begin();
        em.persist(task);
        em.getTransaction().commit();
        em.close();
    }
    
    public ProjectUser findUser(long id){
        EntityManager em = emf.createEntityManager();
        return em.find(ProjectUser.class, id);
    }
    
      public Project findProject(long id){
        EntityManager em = emf.createEntityManager();
        return em.find(Project.class, id);
    }
      
    public Task findTask(long id){
        EntityManager em = emf.createEntityManager();
        return em.find(Task.class, id);
    }
        
    public List<ProjectUser> findAllUser(){
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT s FROM ProjectUser s");
        return q.getResultList();
    }
    
    public List<Project> findAllProject(){
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT s FROM Project s");
        return q.getResultList();    
    }
      
    public List<Task> findAllTask(){
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT s FROM Task s");
        return q.getResultList();   
    }
    
    public void addTaskToProject(long projectId, long taskId){
        EntityManager em = emf.createEntityManager();        
        Project p = findProject(projectId);
        Task t = findTask(taskId);
        t.setProject(p);
        
        em.getTransaction().begin();
        em.merge(t);
        em.getTransaction().commit();
        em.close();
    }
    
        public void addUserToProject(long projectId, long userId){
        EntityManager em = emf.createEntityManager();        
        Project p = findProject(projectId);
        ProjectUser pu = findUser(userId);
        p.addUser(pu);
        
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
        em.close();
    }
}
