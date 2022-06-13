package contracts.product.create

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Product already exists"
    request {
        method POST()
        url("/products")
        headers {
            contentType(applicationJson())
        }
        body(
                name: "Coffee",
                description: value(consumer(alphaNumeric())),
                price: value(consumer(aDouble())),
                shopId: 13
        )
    }
    response {
        status CONFLICT()
    }
}
