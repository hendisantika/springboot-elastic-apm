# Spring Boot Elastic APM

Sample spring boot application with some config files for POC of the Elastic APM Stack.

Execute the steps bellow:

1. Create a sample SpringBoot application
2. Download the library "apm-agent-attach-1.7.0.jar"
   from https://search.maven.org/search?q=g:co.elastic.apm%20AND%20a:apm-agent-attach&core=gav
3. Run up the containers

```shell 
$docker-compose up
```

4. Run the application

```shell 
$ java -jar target/spring-boot-elastic-apm-0.0.1-SNAPSHOT.jar
```

5. Get the PID of application
6. Install the agent (_more about configs: https://www.elastic.co/guide/en/apm/agent/java/current/intro.html_)

```shell
$java -jar apm-agent-attach-1.7.0.jar --pid <pid> --config 'capture_body=all'
```

7. Open kibana (http://localhost:5601)
8. Go to the "APM" item of the left menu
9. The name of the application will be displayed, click on it
   ![alt-text](img/apm.png)
10. Some monitoring data will be displayed
    ![alt-text](img/service.png)
11. Send some requests

```shell
curl -X POST \
  http://localhost:8080/payments/json \
  -H 'Content-Type: application/json' \
  -H 'X-Organization: zup' \
  -d '{
  "description": "Jujutsu Kaisen",
  "amount": 1500,
  "currency": "IDR",
  "creditCard": {
    "type": "MASTERCARD",
    "number": "5568392674344894"
  },
  "customer": {
    "cpf": "39782928070",
    "name": "John Doo"
  }
}'
```

12. Some seconds later the http request will be displayed
    ![alt-text](img/trx.png)
