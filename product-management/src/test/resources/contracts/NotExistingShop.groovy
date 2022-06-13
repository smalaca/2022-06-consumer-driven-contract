package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("Not existing shop")
    request {
        method GET()
        url("/shops/summary/7")
    }
    response {
        status NOT_FOUND()
    }
}
