package com.example.demo.controller;


import com.example.demo.entry.Person;
import com.example.demo.service.OdmPersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class TestController {
    @Autowired
    private OdmPersonRepo odmPersonRepo;

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @RequestMapping(value = "/findOne", method = RequestMethod.POST)
    public Person findByCn(@RequestParam(name = "cn") String cn) {
        return odmPersonRepo.findByCn(cn);
    }

    @PostMapping(value = "/create")
    public Person create(@RequestParam(name = "cn") String cn, @RequestParam(name = "sn") String sn) {
        Person person = new Person();
        person.setCn(cn);
        person.setSn(sn);
        return odmPersonRepo.create(person);
    }


    @PostMapping(value = "/update")
    public Person update(@RequestParam(name = "cn") String cn, @RequestParam(name = "sn") String sn) {
        Person person = new Person();
        person.setCn(cn);
        person.setSn(sn);
        return odmPersonRepo.modifyPerson(person);
    }

    @PostMapping(value = "/delete")
    public void delete(@RequestParam(name = "cn") String cn) {
        Person person = new Person();
        person.setCn(cn);
        odmPersonRepo.deletePerson(person);
    }

}
