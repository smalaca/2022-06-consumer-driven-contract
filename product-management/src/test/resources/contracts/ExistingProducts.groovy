package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("Existing products")
    request {
        method GET()
        url("/shops/summary/13")
    }
    response {
        status OK()
        body("There are 3 products in the shop 13.")
    }
}
