package com.smalaca.domain.enumeration;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Test;

import com.smalaca.dbhandler.HibernateUtil;

public class TaskIntegrityTest {
    private final Session session = HibernateUtil.getSessionFactory().openSession();

    @Test
    public void createAndRead() {
        session.beginTransaction();

        Task makeCoffee = new Task("Make coffee", Priority.LOW);
        Task run = new Task("Run", Priority.HIGH);

        Integer makeCoffeeId = (Integer) session.save(makeCoffee);
        Integer runId = (Integer) session.save(run);

        Task makeCoffeeFromDb = (Task) session.get(Task.class, makeCoffeeId);
        Task runFromDb = (Task) session.get(Task.class, runId);

        assertTrue(makeCoffee.equals(makeCoffeeFromDb));
        assertTrue(run.equals(runFromDb));
        assertFalse(makeCoffeeFromDb.equals(runFromDb));

        session.getTransaction().rollback();
        session.close();
    }
    
     @Test
     public void update() {
         session.beginTransaction();
        
         Task doSomething = new Task("Do something");
         Integer doSomethingId = (Integer) session.save(doSomething);
        
         Task doSomethingFromDb = (Task) session.get(Task.class, doSomethingId);
        
         doSomething.changePriority(Priority.HIGH);
         doSomething.done();
         
         session.update(doSomething);
        
         Task sebastianFromDbAfterUpdate = (Task) session.get(Task.class,doSomethingId);
        
         assertTrue(doSomething.equals(doSomethingFromDb));
         assertTrue(doSomethingFromDb.equals(sebastianFromDbAfterUpdate));
         assertTrue(doSomething.equals(sebastianFromDbAfterUpdate));
        
         assertEquals(Priority.HIGH, sebastianFromDbAfterUpdate.getPriority());
         assertTrue(sebastianFromDbAfterUpdate.checkStatus(Status.DONE));
         
         session.getTransaction().rollback();
         session.close();
     }
    
     @Test
     public void delete() {
         session.beginTransaction();
        
         Task notToDo = new Task("I won't do it any way");
         Integer notToDoId = (Integer) session.save(notToDo);
        
         session.delete(notToDo);
        
         Task notExisting = (Task) session.get(Task.class, notToDoId);
        
         assertNull(notExisting);
        
         session.getTransaction().rollback();
         session.close();
     }
}
