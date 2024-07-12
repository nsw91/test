package com.example.demo.entry;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;
import org.springframework.ldap.support.LdapNameBuilder;

import javax.naming.Name;

/**
 * @Author: geng_pool
 * @Description:
 * @Date: Created in 2017/12/27 10:24
 * @Modified by:
 */
@Getter
@Entry(objectClasses = {"organizationalPerson", "person", "top"}, base = "ou=roles,dc=maxcrc,dc=com")
public class Person {

    /* setter   */
    /* getter   */
    @Setter
    @Id
    @JsonIgnore
    private Name dn;

    @Attribute(name = "cn")
    private String cn;

    @Setter
    @Attribute(name = "sn")
    private String sn;


    public Person(String cn) {
        this.dn = LdapNameBuilder.newInstance()
                .add("dc", "com")
                .add("dc", "maxcrc")
                .add("ou", "roles")
                .add("cn", cn)
                .build();
    }

    public Person() {
    }

    public void setCn(String cn) {
        this.cn = cn;
        if (this.dn == null) {
            this.dn = LdapNameBuilder.newInstance()
                    .add("dc", "com")
                    .add("dc", "maxcrc")
                    .add("ou", "roles")
                    .add("cn", cn)
                    .build();
        }
    }



    @Override
    public String toString() {
        return "Person{" +
                "dn=" + dn +
                ", cn='" + cn + '\'' +
                ", sn='" + sn + '\'' +
                '}';
    }
}
