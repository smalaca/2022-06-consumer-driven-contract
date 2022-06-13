package contracts.product.create

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Not Existing Product"
    request {
        method POST()
        url("/products")
        headers {
            contentType(applicationJson())
        }
        body(
                name: value(consumer(alphaNumeric())),
                description: value(consumer(alphaNumeric())),
                price: value(consumer(aDouble())),
                shopId: 7
        )
    }
    response {
        status NOT_FOUND()
    }
}
