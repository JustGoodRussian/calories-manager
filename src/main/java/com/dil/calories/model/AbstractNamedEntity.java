package com.dil.calories.model;

public abstract class AbstractNamedEntity extends AbstractBaseEntity {

    protected String name;

    public AbstractNamedEntity(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AbstractNamedEntity{" +
                "name='" + name + '\'' +
                '}';
    }
}
