package day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassNoteBookTest {

    @Test
    void addStudent() {
        ClassNoteBook classNoteBook = new ClassNoteBook();
        classNoteBook.addStudent(new Student(5,"John"));
        classNoteBook.addStudent(new Student(2,"Jack"));
        classNoteBook.addStudent(new Student(7,"Jane"));
        classNoteBook.addStudent(new Student(3,"Joe"));
        System.out.println(classNoteBook.getStudents());
        classNoteBook.addMark(7,5);
        classNoteBook.addMark(5,4);
        classNoteBook.addMark(5,5);
        System.out.println(classNoteBook.getStudents());
        assertEquals(5,classNoteBook.getStudents().get(new Student(5,"John")).get(1));
    }

}