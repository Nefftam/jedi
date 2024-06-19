package com.jedi.berry;

public class Person {
    String name;
    int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    Person(String name, int id)
    {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj)
    {
        Person p = (Person)obj;

        if(this.hashCode() != p.hashCode()) return false;

        return this.id == p.getId() && this.name.equals(p.getName());
    }

    @Override
    public int hashCode() {
        String name = this.name;
        char nameArr[] = name.toCharArray();
        int x = 0;
        for(int i = 0 ; i< nameArr.length ; i++)
        {
            x = x + nameArr[i];
        }
        return x;
    }

    //abc
    //bca

    // if two objects are equal , hashcode must be same
    //if two hashcode are same , two objects need not always be equal
}
