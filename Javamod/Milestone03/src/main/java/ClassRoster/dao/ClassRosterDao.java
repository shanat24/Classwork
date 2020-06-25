/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassRoster.dao;

import ClassRoster.dto.Student;
import java.util.List;

/**
 *
 * @author Shantoria Taylor
 */
public interface ClassRosterDao {
    
    Student addStudent(String studentId, Student student)
        throws ClassRosterPersistenceException;
    
    List<Student> getAllStudents()
        throws ClassRosterPersistenceException;
        
    Student getStudent(String studentId)
        throws ClassRosterPersistenceException;
        
    Student removeStudent(String studentId)
        throws ClassRosterPersistenceException;
}
