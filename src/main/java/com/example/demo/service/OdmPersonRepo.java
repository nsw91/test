package com.example.demo.service;

import com.example.demo.entry.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Service;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

/**
 * @Author: geng_pool
 * @Description:
 * @Date: Created in 2017/12/27 10:37
 * @Modified by:
 */
@Service
public class OdmPersonRepo {

    @Autowired
    private LdapTemplate ldapTemplate;

    public Person create(Person person){
        ldapTemplate.create(person);
        return person;
    }

    public Person findByCn(String cn){
        return ldapTemplate.findOne(query().where("cn").is(cn),Person.class);
    }

    public Person modifyPerson(Person person){
        ldapTemplate.update(person);
        return person;
    }

    public void deletePerson(Person person){
        ldapTemplate.delete(person);
    }

}
