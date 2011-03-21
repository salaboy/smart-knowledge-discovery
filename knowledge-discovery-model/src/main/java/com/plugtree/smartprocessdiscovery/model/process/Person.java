package com.plugtree.smartprocessdiscovery.model.process;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Person implements IsSerializable {
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
