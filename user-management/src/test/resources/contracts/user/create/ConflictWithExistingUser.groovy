package contracts.user.create

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("Create User with conflict")
    request {
        method POST()
        url("/users")
        headers {
            contentType(applicationJson())
        }
        body(
                login: "Odinson",
                password: value(consumer(alphaNumeric())),
                group: "Avengers"
        )
    }
    response {
        status CONFLICT()
    }
}