package utils;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {


    public String getRandomGender() {
        String[] genderArray = {"Male", "Female", "Other"};
        int index = new Random().nextInt(genderArray.length);
        String gender = genderArray[index];
        return gender;
    }

    public String getRandomMonth() {
        String[] genderArray = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int index = new Random().nextInt(genderArray.length);
        String month = genderArray[index];
        return month;
    }

    private int randomValue(int origin, int bound) {

        return ThreadLocalRandom.current().nextInt(origin, bound);
    }

    public String getRandomDay() {
        int a = randomValue(1, 28);
        String day = a + "";
        return day;
    }
    public String getRandomYear() {
        int b = randomValue(1980, 2022);
        String year = b + "";
        return year;
    }

    public String getRandomCity() {
        String[] genderArray = {"Delhi", "Gurgaon", "Noida"};
        int index = new Random().nextInt(genderArray.length);
        String city = genderArray[index];
        return city;
    }


}















