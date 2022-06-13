package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("Verify if hello with given name works.")
    request {
        method GET()
        url("/start/Sebastian")
    }
    response {
        status OK()
        body("Hello Sebastian!")
    }
}
