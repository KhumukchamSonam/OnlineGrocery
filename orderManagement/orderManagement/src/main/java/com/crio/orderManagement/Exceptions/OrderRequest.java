package com.crio.orderManagement.Exceptions;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private Integer customerId;
    private List<Integer> itemList;
}
