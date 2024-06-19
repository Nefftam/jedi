package com.jedi.threads;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;

public class Demo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Filtered f = (Filtered) mymethod().getEntity();
        Response x =  Response.ok().entity(f.filtered_rest_response.get(0)).build();
    }

    public static Response mymethod()
    {
        Person p = new Person();
        Filtered f = new Filtered();
        f.filtered_rest_response = new ArrayList<>();
        f.filtered_rest_response.add(p);
        return Response.ok().entity(f).build();
    }
}

class Filtered
{
    List<Person> filtered_rest_response ;
}

class Person
{
    String Name;
}
