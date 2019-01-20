package util;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by Inka on 13-Jan-19.
 */
public class DataProviders {
    @DataProvider
    public static Iterator<Object[]> loginPositive() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(DataProviders.class.getResourceAsStream("/LoginPositive.data")));
        List<Object[]> userData = new ArrayList<>();

        for (String line = in.readLine(); line != null; line = in.readLine()) {
            userData.add(line.split(";"));
        }


        in.close();
        return userData.iterator();
    }
    @DataProvider
    public static Iterator<Object[]> loginPositiveWithProfile() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(DataProviders.class.getResourceAsStream("/LoginPositiveWithProfile.data")));
        List<Object[]> userData = new ArrayList<>();

        for (String line = in.readLine(); line != null; line = in.readLine()) {
            userData.add(line.split(";"));
        }


        in.close();
        return userData.iterator();
    }

    @DataProvider
    public static Iterator<Object[]> anotherPositiveLogin() {
        List<Object[]> data = new ArrayList();
        data.add(new Object[]{"Lena@gmail.com", "1234567890"});
        data.add(new Object[]{"EleNa@gmail.com", "1234567890"});
        data.add(new Object[]{"123elena@gmail.com", "1234567890"});

        return data.iterator();
    }

    @DataProvider
    public Iterator<Object[]> randomUsers() {
        List<Object[]> data = new ArrayList();

        for (int i = 0; i < 3; ++i) {
            data.add(new Object[]{this.generateRandomName(), this.generateRandomPassword()});
        }

        return data.iterator();
    }

    private Object generateRandomPassword() {
        return "pass" + (new Random()).nextInt();
    }

    private Object generateRandomName() {
        return "demo" + (new Random()).nextInt() + "@gmail.com";
    }

   /* @DataProvider
    public Iterator<Object[]> createNewAccountsWithDataProvider() {
        List<Object[]> data = new ArrayList();

        for(int i = 0; i < 6; ++i) {
            data.add(new Object[]{this.generateRandomEm(), this.generateRandomPass()});
        }

        return data.iterator();
    }

    private Object generateRandomPass() {
        return "pass" + (new Random()).nextInt();
    }

    private Object generateRandomEm() {
        return "demo" + (new Random()).nextInt()+"@gmail.com";*/


    @DataProvider
    public static Iterator<Object[]> createNewAccountsWithDataProvider() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(DataProviders.class.getResourceAsStream("/NewAccounts.data")));
        List<Object[]> userData = new ArrayList<>();

        for (String line = in.readLine(); line != null; line = in.readLine()) {
            userData.add(line.split(";"));
        }


        in.close();
        return userData.iterator();
    }
    @DataProvider
    public static Iterator<Object[]> loginNegativeAuth() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(DataProviders.class.getResourceAsStream("/LoginNegativeAuth.data")));
        List<Object[]> userData = new ArrayList<>();

        for (String line = in.readLine(); line != null; line = in.readLine()) {
            userData.add(line.split(";"));
        }


        in.close();
        return userData.iterator();
    }
    @DataProvider
    public static Iterator<Object[]> loginNegative() {
        List<Object[]> data = new ArrayList();
        data.add(new Object[]{"Lenagmail.com"});
        data.add(new Object[]{"Len:a@gmail.com"});


        return data.iterator();
    }
}

