/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import facade.facade;

/**
 *
 * @author bechw
 */
public class test {
    public static void main(String[] args) {
        facade f = new facade();
        
        f.createProject();
        f.createTask();
        f.createUser();
         f.createProject();
        f.createTask();
        f.createUser();
        
        System.out.println(f.findAllProject());
        System.out.println(f.findAllTask());
        System.out.println(f.findAllUser());
        
        System.out.println(f.findProject(1));
        System.out.println(f.findTask(2));
        System.out.println(f.findUser(3));
        
        f.addTaskToProject(1, 2);
        f.addUserToProject(1, 3);
    }
}
