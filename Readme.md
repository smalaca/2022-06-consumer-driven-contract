# Consumer-Driven Contract
### How to verify if everything works?
#### module: product-management
1. Run `ProductManagementApp`
2. Open `http://localhost:8200/shops/summary/13`
3. You should see following response: `There are 3 products in the shop 13.`

#### module: product-management-consumer
1. Run `ProductManagementApp` from `product-management` module.
2. Execute all tests.
3. All tests should be green.

#### module: user-management
1. Run `UserManagementApp`
2. Open `http://localhost:8100/start`
3. You should see following response: `Hello guest!`

#### module: user-management-consumer
1. Run `UserManagementApp` from `user-management` module.
2. Execute all tests.
3. All tests should be green.
