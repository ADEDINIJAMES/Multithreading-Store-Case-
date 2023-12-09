package org.example.serviceImplementation;

import org.example.DTO.CustomersDTO;
import org.example.entities.Goods;
import org.example.entities.Person;
import org.example.exception.GoodNotAvailable;
import org.example.serviceInterface.InterfaceService;

import java.util.*;

public class Implementation extends Thread{
    private static String lock1 = "LOCK";
    private static String lock2 = "LOCK";
public  static  Goods goods = new Goods();
    public static List<Goods> goodsList = new ArrayList<>();
    public static List<Person> custommersList = new ArrayList<>();
    public static Queue<Person> customersDTOsList = new LinkedList<>();

    public static InterfaceService<Goods> addGoods = (goods -> {
        if (goods.getQuantity() != 0) {
            goodsList.add(goods);
        }

    });

    public static InterfaceService<Person> addcustomers = (person -> {
        if (person.getCustomersId() != 0) {
            custommersList.add(person);
        }
    });
    public   InterfaceService addCustomerstoBuyers = (person) ->  {
        Person person1= new Person();
        synchronized (lock1) {
            try {
                System.out.println("Validating customer......");
                Thread.sleep(5000);
                if (custommersList.contains(person1.getCustomersId())) {
                    customersDTOsList.add(person1);

                } else {
                    Thread.yield();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
      }
       // synchronized (lock2) {
        System.out.println("Transaction can now take place...");
      // }
    };
    public   InterfaceService<CustomersDTO>  buyGoods = customersDTO -> {
        synchronized (lock2) {
            try {
                System.out.println("Checking goods Availability.....");
                Thread.sleep(5000);
                if (customersDTOsList.contains(customersDTO) && goodsList.contains(customersDTO.getGood())) {
                    if (goods.getQuantity() != 0 && Objects.equals(customersDTO.getPayment(), goods.getPrice())) {
                        System.out.println(customersDTO.getFirstname() + ", ID: " + customersDTO.getCustomersId() + " has successfully bought " + customersDTO.getGood());
                        System.out.println(goods.getName() + " is now :" + goods.getQuantity());
                    } else {
                        throw new GoodNotAvailable("This Good is no more available!! or your Price does not match");
                    }
                }
            } catch (InterruptedException ie) {
                throw new RuntimeException();
            } catch (GoodNotAvailable e) {
                throw new RuntimeException(e);
            }
       }
        synchronized (lock1) {
            System.out.println("Transactions successful.....");
            goods.setQuantity(goods.getQuantity() - 1);
            System.out.println(customersDTO.getFirstname()+" has bought a "+ customersDTO.getGood());
            custommersList.remove(customersDTO);


        }
    };

}
