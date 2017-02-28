Project : SpringBatchWithTwoDBExample:
This Project contains two functionality:
1: Read data from table of one DB and write to CSV file.
2: Read Data from CSV file and write it to other table of Different Database


Project : SpringAfterJobBeforeJobExample:
This Project contains two functionality:
1: BeforeJob & AfterJob functionality
2: BeforeStep & AfterStep functionality



Project : SpringInheritingParentJobExample:
This project is use to define how to inherit the functionality of Parent Job in Child Job 



Project : SpringMapJobRepositoryFactoryBeanExample
In-Memory Repository
There are scenarios in which you may not want to persist your domain objects to the database. One reason may be speed; storing domain objects at each commit point takes extra time. Another reason may be that you just don't need to persist status for a particular job. For this reason, Spring batch provides an in-memory Map version of the job repository:




Project : SpringJobRepositoryFactoryBeanExample : As described in earlier, the JobRepository is used for basic CRUD operations of the various persisted domain objects within Spring Batch, such as JobExecution and StepExecution. It is required by many of the major framework features, such as the JobLauncher, Job, and Step. The batch namespace abstracts away many of the implementation details of the JobRepository implementations and their collaborators. 
