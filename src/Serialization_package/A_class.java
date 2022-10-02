/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serialization_package;

import java.io.Serializable;
import java.util.Date;

public class A_class implements Serializable{
 
    private static final long serialVersionUID = 1234L;
 
    private String username;
    private String email;
    private transient String password;
    private Date birthday;
    private int age;
 
    public A_class(String username, String email, String password, Date birthday,int age) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.age = age;
    }
 
    public void printInfo() {
        System.out.println("username: " + username);
        System.out.println("email: " + email);
        System.out.println("password: " + password);
        System.out.println("birthday: " + birthday);
        System.out.println("age: " + age);
    }


}
