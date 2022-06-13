package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("No products")
    request {
        method GET()
        url("/shops/summary/42")
    }
    response {
        status OK()
        body("There is no products in the shop 42.")
    }
}
