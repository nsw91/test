package com.example;

import com.example.demo.entry.Person;
import com.example.demo.service.OdmPersonRepo;

public class run_test {

    public static void main(String[] args) {
        OdmPersonRepo odmPersonRepo = new OdmPersonRepo();
        Person person = odmPersonRepo.findByCn("user1");
        //System.out.println(person.toString());
    }
}
