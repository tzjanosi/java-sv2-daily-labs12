package day04;

public class SubjectAndTeacher {
    private String teacherName;
    private String subjectName;
    private String className;
    private int numberPerWeek;

    public SubjectAndTeacher(String teacherName, String subjectName, String className, int numberPerWeek) {
        this.teacherName = teacherName;
        this.subjectName = subjectName;
        this.className = className;
        this.numberPerWeek = numberPerWeek;
    }

    public int numberOfLessonsOfThisTeacher(String teacherName){
        return this.teacherName.equals(teacherName)?numberPerWeek:0;
    }
}
