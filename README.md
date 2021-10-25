# WalletSummary
It is a spring boot application with inbuilt tomcat server and database as MySql.
Starting point of this application is WalletSummaryApplication.java.

#Instruction to launch the application
Pre requisite : We need to have one database and Schema so please create one Database with name walletSummary in MySql server and for schema use database.sql.

As this is a spring boot we can directly start by running WalletSummaryApplication.java main class server port as 8081


#API
http://localhost:8081/wallet/credit POST
Accepting 
        {
            "datetime": "2021-10-25T16:20:01+01:00",
            "amount": 111.0
        }
http://localhost:8081/wallet/transactionSummary GET 
        {
            "startDatetime": "2019-10-05T10:45:01+01:00",
            "endDatetime": "2019-10-06T14:45:01+01:00"
        }
 
Api BASIC Authentication 
 Username: anymind
 Password: anymindbtc
 
 Note: For now it is InmemoryAuthentication implemented