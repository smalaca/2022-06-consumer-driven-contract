package contracts.producer

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "not existing producer"
    request {
        method GET()
        url("/producer/dasdsad")
    }
    response {
        body(
                id: anyUuid(),
                title: "NOT existing",
                producerId: -1
        )
        status OK()
    }
}