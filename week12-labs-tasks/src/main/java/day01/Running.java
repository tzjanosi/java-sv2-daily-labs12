package day01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Running {
    private List<Trip> runningList=new ArrayList<>();

    public Double sumInYerAndMonth(int year, int mopnth){
        Double total=0.0;
        for(Trip trip:runningList){
            if(trip.matchYearAndMonth(year,mopnth)){
                total+=trip.getLength();
            }
        }
        return total;
    }
    public List<String> readFromFile(Path path){
        //Paths.get("src/test/resources/inpayments.txt")
        try {
            return Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file: "+path, ioe);
        }
    }
    private void process(List<String> listToValidate){
        String[] fieldsArray;
        boolean first=true;
        for(String line:listToValidate){
            if(!first) {
                fieldsArray = line.split(" km;");
                if (fieldsArray.length == 2 && isValidDouble(fieldsArray[0]) && isValidDate(fieldsArray[1])) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate date = LocalDate.parse(fieldsArray[1],formatter);
                    Double length = Double.parseDouble(fieldsArray[0]);
                    runningList.add(new Trip(length,date));
                }
            }
            else{
                first=false;
            }
        }
    }
    public void loadFromFile(Path path){
        process(readFromFile(path));
    }

    public boolean DateValidator(String dateStr) {
        String dateFormat="yyyy-MM-dd";
        DateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
    private boolean isValidDate(String input) {
        if(input==null){
            throw new NullPointerException("The name is null!");
        }
        return DateValidator(input);
    }

    private boolean isValidDouble(String input){
        try{
            Double.parseDouble(input);
            return true;
        }
        catch(NumberFormatException nfe){
            throw new NumberFormatException("Problem with the amount!");
        }
    }

    public List<Trip> getRunningList() {
        return runningList;
    }

    public static void main(String[] args) {
        Running runningDiary=new Running();
        runningDiary.loadFromFile(Paths.get("src/main/resources/running.csv"));
        int year=2021;
        int month=12;
        System.out.println(year+". "+month+": "+ runningDiary.sumInYerAndMonth(year,month));
        year=2022;
        month=1;
        System.out.println(year+". "+month+": "+ runningDiary.sumInYerAndMonth(year,month));
    }
}
