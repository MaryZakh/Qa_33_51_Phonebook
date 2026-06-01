package manager;

import models.Contact;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderContact {


    @DataProvider
    public Iterator<Object[]> example() {
        List<Object[]> list = new ArrayList<>();


        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactSuccess() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Contact.builder()
                .name("Tony")
                .lastName("Molly")
                .phone("343434345424")
                .email("molly@gmail.com")
                .address("Haifa")
                .description("all fields")
                .build()});
        list.add(new Object[]{Contact.builder()
                .name("Tony")
                .lastName("Molly")
                .phone("3434343849034")
                .email("tony@gmail.com")
                .address("Haifa")
                .build()});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactWrongPhone() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Contact.builder()
                .name("John")
                .lastName("Wick")
                .phone("123")
                .email("john@gmail.com")
                .address("Haifa")
                .description("Friend")
                .build()});
        list.add(new Object[]{Contact.builder()
                .name("John")
                .lastName("Wick")
                .phone("123659123659453133135133")
                .email("john@gmail.com")
                .address("Haifa")
                .description("Friend")
                .build()});
        list.add(new Object[]{Contact.builder()
                .name("John")
                .lastName("Wick")
                .phone("wwwwwwwwwwww")
                .email("john@gmail.com")
                .address("Haifa")
                .description("Friend")
                .build()});
        list.add(new Object[]{Contact.builder()
                .name("John")
                .lastName("Wick")
                .phone("")
                .email("john@gmail.com")
                .address("Haifa")
                .description("Friend")
                .build()});
        list.add(new Object[]{Contact.builder()
                .name("John")
                .lastName("Wick")
                .phone("123-456-4956-12")
                .email("john@gmail.com")
                .address("Haifa")
                .description("Friend")
                .build()});

        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> contactCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] all = line.split(",");
            list.add(new Object[]{Contact.builder()
                    .name(all[0])
                    .lastName(all[1])
                    .email(all[2])
                    .phone(all[3])
                    .address(all[4])
                    .description(all[5])
                    .build()});
            line = reader.readLine();
        }


        return list.iterator();
    }
}
