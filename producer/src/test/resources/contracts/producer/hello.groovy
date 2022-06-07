package contracts.producer

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "producer says hello"
    request {
        method GET()
        url("/producer/hello")
    }
    response {
        body(
                id: anyUuid(),
                title: "Hello world!",
                producerId: 1
        )
        status OK()
    }
}
