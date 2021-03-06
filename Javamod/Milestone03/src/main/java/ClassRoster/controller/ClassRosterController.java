/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassRoster.controller;

import ClassRoster.dao.ClassRosterDao;
import ClassRoster.dao.ClassRosterPersistenceException;
import ClassRoster.dao.ClassRosterDaoFileImpl;
import ClassRoster.dto.Student;
import ClassRoster.service.ClassRosterServiceLayer;
import ClassRoster.ui.ClassRosterView;
import ClassRoster.ui.UserIO;
import ClassRoster.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author Shantoria Taylor
 */
public class ClassRosterController {

   
    private ClassRosterView view;
    
    private UserIO io = new UserIOConsoleImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try{
        while (keepGoing) {
            io.print("Main Menu");
            io.print("1. List Student IDs");
            io.print("2. Create New Student");
            io.print("3. View a Student");
            io.print("4. Remove a Sudent");
            io.print("5. Exit");

            menuSelection = io.readInt("Please select from the" + " above choices.", 1, 5);
            switch (menuSelection) {
                case 1:
                    listStudents();
                    break;

                case 2:
                    createStudent();
                    break;

                case 3:
                    viewStudent();
                    break;

                case 4:
                   removeStudent();
                    break;

                case 5:
                    keepGoing = false;
                    break;

                default:
                    io.print("UNKNOWN COMMAND");
            }
        }
        exitMessage();
    }
    catch (ClassRosterPersistenceException e) {
    view.displayErrorMessage(e.getMessage());
}
    }
    private ClassRosterServiceLayer service;

    private void createStudent() throws ClassRosterPersistenceException {
        view.displayCreateStudentBanner();
        Student newStudent = view.getNewStudentInfo();
        dao.addStudent(newStudent.getStudentId(), newStudent);
        view.displayCreateSuccessBanner();
    }

    private void listStudents() throws ClassRosterPersistenceException {
        view.displayDisplayAllBanner();
        List<Student> studentList = dao.getAllStudents();
        view.displayStudentList(studentList);
        
    }

    private void viewStudent() throws ClassRosterPersistenceException {
        view.displayDisplayStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student student = dao.getStudent(studentId);
        view.displayStudent(student);
    }
    
    
    private void removeStudent() throws ClassRosterPersistenceException {
        
        view.displayRemoveStudentBanner();
        String studentId = view.getStudentIdChoice();
        
        
        Student removedStudent = dao.removeStudent(studentId);
        view.displayRemoveResult(removedStudent);
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    
    private void exitMessage() {
        view.displayExitBanner();
    }
    
    
    
    
    public ClassRosterController(ClassRosterDao dao, ClassRosterView view){
        this.dao = dao;
        this.view = view;
    }
    
    
    
    
    
}
