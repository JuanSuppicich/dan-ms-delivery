package com.durandsuppicich.danmsdelivery.dto;

import org.hibernate.validator.constraints.Mod11Check;

import javax.validation.constraints.*;
import java.util.List;

public class PackageRequestDto {

    @NotBlank
    @Size(min = 11, max = 11)
    @Mod11Check(threshold = 7)
    private String customerCuit;

    @NotEmpty
    private List<@Positive @NotNull Integer> ordersIds;

    public String getCustomerCuit() {
        return customerCuit;
    }

    public List<Integer> getOrdersIds() {
        return ordersIds;
    }

}
