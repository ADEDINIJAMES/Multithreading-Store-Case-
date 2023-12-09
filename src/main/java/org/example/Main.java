package org.example;

import org.example.DTO.CustomersDTO;
import org.example._enum.Gender;
import org.example._enum.GoodType;
import org.example.entities.Goods;
import org.example.entities.Person;
import org.example.serviceImplementation.Implementation;
import org.example.serviceInterface.InterfaceService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

import static java.lang.Thread.sleep;
import static org.example._enum.GoodType.*;
import static org.example.serviceImplementation.Implementation.custommersList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static Goods goods= new Goods();
    static CustomersDTO customersDTO= new CustomersDTO();

    private static Long sales= 0L;
     static int goodQuantity = 500;
    static InterfaceService decrement= (goods)->Main.goodQuantity--;
    static InterfaceService increment= (sales)->Main.sales++;


    public static void main(String[] args) throws InterruptedException {


        Implementation implementation = new Implementation();
        Person person1= new Person(1L,"James","Adedini","adedinijames28@gmail.com", Gender.Male, LocalDate.of(2015, Month.SEPTEMBER,28));
        Person person2= new Person(1L,"Peter","James","adedinijames28@gmail.com", Gender.Male, LocalDate.of(2015, Month.SEPTEMBER,28));
        Person person3= new Person(1L,"Adedini","Peter","adedinijames28@gmail.com", Gender.Male, LocalDate.of(2015, Month.SEPTEMBER,28));
        Goods goods1 = new Goods(20L, "HD", Cameras,25,20000L);
        CustomersDTO customersDTO1= new CustomersDTO(1L,"James", Cameras,"adedinijames28@gmail.com",2000L);
        CustomersDTO customersDTO2= new CustomersDTO(2L,"Peter", Mouse,"adedinijames28@gmail.com",2000L);
        CustomersDTO customersDTO3= new CustomersDTO(3L,"Adedini", Computer,"adedinijames28@gmail.com",2000L);
//        Runnable r1 = new Thread(()->
//
//            for (Person person: custommersList) {
//                try {
//                    decrement.run(goods1.getQuantity());
//                    Thread.sleep(5000);
//                    increment.run(sales);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//
//            }
//        });

        Thread t1 = new Thread(()->{
Implementation implementation1 = new Implementation();

            try {
                Implementation.addcustomers.run(person1);
                implementation1.addCustomerstoBuyers.run(person1);
                implementation1.buyGoods.run(customersDTO1);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                increment.run(sales);
                decrement.run(goodQuantity);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        Thread t2 = new Thread(()->{
            Implementation implementation1 = new Implementation();

            try {
                Implementation.addcustomers.run(person2);
                implementation1.addCustomerstoBuyers.run(person2);
                implementation1.buyGoods.run(customersDTO2);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                increment.run(sales);
                decrement.run(goodQuantity);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        Thread t3 = new Thread(()->{
            Implementation implementation1 = new Implementation();

            try {
                Implementation.addcustomers.run(person3);
                implementation1.addCustomerstoBuyers.run(person3);
                implementation1.buyGoods.run(customersDTO3);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                increment.run(sales);
                decrement.run(goodQuantity);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Sales After all Transactions= "+sales);
        System.out.println("Stock After all Transactions = "+goodQuantity);
    }

}