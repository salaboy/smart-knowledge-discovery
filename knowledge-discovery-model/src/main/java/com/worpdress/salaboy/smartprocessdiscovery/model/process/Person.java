package com.worpdress.salaboy.smartprocessdiscovery.model.process;

/**
 * Created by IntelliJ IDEA.
 * User: salaboy
 * Date: 2/4/11
 * Time: 2:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class Person {
    private Long id;
    private String actorId;
    private String email;

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActorId() {
        return actorId;
    }

    public void setActorId(String actorId) {
        this.actorId = actorId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
