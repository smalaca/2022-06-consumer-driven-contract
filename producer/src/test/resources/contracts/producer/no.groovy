package contracts.producer

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "no producer"
    request {
        method GET()
        url("/producer/no")
    }
    response {
        body(
                id: anyUuid(),
                title: "No world!",
                producerId: 1
        )
        status OK()
    }
}