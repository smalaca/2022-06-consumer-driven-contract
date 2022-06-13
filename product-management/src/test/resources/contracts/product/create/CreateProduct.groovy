package contracts.product.create

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Create Product"
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
                shopId: 42
        )
    }
    response {
        status CREATED()
        headers {
            contentType(applicationJson())
        }
        body(
                id: regex("[0-9]+"),
                name: fromRequest().body('$.name'),
                index: anyAlphaNumeric(),
                description: fromRequest().body('$.description'),
                price: fromRequest().body('$.price'),
                shopId: 42
        )
    }
}
