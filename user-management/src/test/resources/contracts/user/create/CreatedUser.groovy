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
                login: value(consumer(alphaNumeric())),
                password: value(consumer(alphaNumeric())),
                group: "Spider Verse"
        )
    }
    response {
        status CREATED()
        headers {
            contentType(applicationJson())
        }
        body(
                id: regex("[0-9]+"),
                login: fromRequest().body('$.login'),
                group: fromRequest().body('$.group')
        )
    }
}