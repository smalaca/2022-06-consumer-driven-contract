package contracts.producer

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "another producer"
    request {
        method GET()
        url("/producer/another")
    }
    response {
        body(
                id: anyUuid(),
                title: "Another world!",
                producerId: 2
        )
        status OK()
    }
}