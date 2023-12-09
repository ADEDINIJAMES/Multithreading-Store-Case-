package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example._enum.GoodType;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    private long goodsId;
private String name;
private GoodType type;
private int quantity;
private Long price;

//    public final static BigDecimal Computer = new BigDecimal("50,000");
//    public final static BigDecimal Mouse = new BigDecimal("10,000");
//    public final static BigDecimal Charger = new BigDecimal("15,000");
//    public final static BigDecimal Cameras= new BigDecimal("25,000");
//    public final static BigDecimal Camcoders= new BigDecimal("30,000");



}
