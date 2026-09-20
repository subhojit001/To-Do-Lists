package com.project.ToDo_Lists.Repository;

import com.project.ToDo_Lists.Todo;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TodoRepo {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Todo> findAll() {
        //System.out.println("in the repo");
        TypedQuery<Todo> typedQuery=entityManager.createQuery("from Todo", Todo.class);
        return typedQuery.getResultList();
    }

    public Optional<Todo> findbyId(Long id){
        Todo todo=entityManager.find(Todo.class,id);
        return Optional.ofNullable(todo);
    }


    @Transactional
    public void save(Todo todo){
        entityManager.persist(todo);
    }


    @Transactional
    public void update(Todo oldTodo) {
        entityManager.merge(oldTodo);
    }

    @Transactional
    public void delete(long id) {
        Todo todo=entityManager.find(Todo.class,id);
        if(todo!= null)
           entityManager.remove(todo);
    }
}
