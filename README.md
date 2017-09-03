# bank-queue-challenge
A bank, ABC Bank, has many branches and customers. Each branch has a limited number of teller counters. ABC Bank would like to improve their customer experience at each branch. Managing long queues of customers at the bank during business hours is one of the most challenging tasks. ABC Bank also provides a better customer experience to their premium customers by providing priority over non premium customers (less waiting time at branches). In order to achieve this, ABC Bank has decided to introduce new machines to manage queues at each of their branches.

## Code setup
### Build
* Install mvn 3.3 or above
* Install Java 8 or above
* run ""


## API Design
### Branch API
* GET:/branch - List all the branches

### Counter API
* GET:/branch/{branchCode}/counter - List all counters at branch with branchCode - {branchCode}
* GET:/branch/{branchCode}/counter/{counterCode} - return counter details with token queue
* GET:/branch/{branchCode}/counter/{counterCode}/tokenQueue - return counter details with token queue

### Token API
* PUT:/branch/{branchCode}/token?customerId={customerId}&description={tokenQueryDescription}&queryType={queryType}
* POST:/branch/{branchCode}/token/{tokenId}/counter/{counterCode}/update?description={counterLogDescription}
* POST:/branch/{branchCode}/token/{tokenId}/setNextCounter?counterCode={nextCounterCode}
* POST:/branch/{branchCode}/token/{tokenId}/complete
* POST:/branch/{branchCode}/token/{tokenId}/cancel

Code uses couple of design principles and patterns like Dependency Injection, Composition over inheritence, builder pattern, factory pattern etc.

TODO: Add more documentation
TODO code:
1) Scope of observable pattern
2) Strategy pattern
