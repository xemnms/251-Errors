package com.dizon.app.validator;

import com.dizon.app.dto.OrderRequest;

// SOLID: ISP - one tiny, single-purpose interface. No implementer is forced to
//        provide methods it does not need.
// SOLID: DIP - OrderService depends on this abstraction; the concrete rules can be
//        swapped or mocked without touching the service.
public interface OrderValidator {

    // Throws InvalidOrderException if the request is not valid.
    void validate(OrderRequest request);
}
