package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("Verify if hello guest works.")
    request {
        method GET()
        url("/start")
    }
    response {
        status OK()
        body("Hello guest!")
    }
}
