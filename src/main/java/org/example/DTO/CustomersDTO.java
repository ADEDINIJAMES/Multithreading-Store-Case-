package org.example.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example._enum.GoodType;
import org.example.entities.Goods;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomersDTO {
    private long customersId;
    private String firstname;
    private GoodType good;
    private String email;
    private Long  payment;
}
