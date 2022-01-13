package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Organizer {
    private List<SubjectAndTeacher> recordsList=new ArrayList<>();

    public int numberOfLessonsOfThisTeacher(String teacherName){
        int totalLessons=0;
        for(SubjectAndTeacher subjectAndTeacher:recordsList){
            totalLessons+= subjectAndTeacher.numberOfLessonsOfThisTeacher(teacherName);
        }
        return totalLessons;
    }
    public void loadFromFile(Path path){
        process(readFromFile(path));
    }
    public List<String> readFromFile(Path path){
        //Paths.get("src/test/resources/inpayments.txt")
        try {
            return Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file: "+path, ioe);
        }
    }
    private void process(List<String> listToLoad){
        int numberOfRecordToLoad=listToLoad.size()/4;

        int basic=0;
        String teacherName;
        String subjectName;
        String className;
        int numberPerWeek;

        for(int i=0;i<numberOfRecordToLoad;i++){
            basic=4*i;
            teacherName=listToLoad.get(basic);
            subjectName=listToLoad.get(basic+1);
            className=listToLoad.get(basic+2);
            numberPerWeek=Integer.parseInt(listToLoad.get(basic+3));
            SubjectAndTeacher subjectAndTeacher=new SubjectAndTeacher(teacherName, subjectName, className, numberPerWeek);
            recordsList.add(subjectAndTeacher);
        }
    }

    public static void main(String[] args) {
        Organizer organizer=new Organizer();
        organizer.loadFromFile(Paths.get("src/main/resources/beosztas.txt"));

        System.out.println(organizer.numberOfLessonsOfThisTeacher("Albatrosz Aladin"));
    }
}
