package org.jspiders.SpringMvcInventory.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.valves.rewrite.Substitution;
import org.jspiders.SpringMvcInventory.validation.Discount;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Item {
    @NotBlank(message = "INVALID CATEGORY")
    private String category;
    @NotBlank(message = "INVALID NAME")
    private String name;
    // @NotNull(message = "INVALID PRICE")
   @NotNull(message = "price must not be empty")
    private double price;
   @NotNull(message = "discount must not be empty")
    private double discount;
    @NotNull(message = "INVALID DATE")
    @Past(message = "must be past date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public String getJoins()
    {
        SimpleDateFormat sd=new SimpleDateFormat();
        return sd.format(date);
    }

}
