# Data-generator-microservice

This application produces data and sends it to [Data consumer service](https://github.com/qReolq/data-analyser-microservice) with Apache Kafka.

### Technologies
Spring(Boot), Docker, Apache Kafka, CI/CD(Github actions)

### Usage

You can find Docker compose file in [Data analyser service](https://github.com/qReolq/data-analyser-microservice) <code>docker/docker-compose.yaml</code>.

Application is running on port 8081.

### Environments
To start an application you need to pass variables to .env file.

* <code>KAFKA_BOOTSTRAP_SERVERS</code> - Bootstrap server in Kafka


### Endpoints
* POST <code>/api/v1/data/send</code>

Example JSON
```JSON
{
  "sensorId": 1,
  "timestamp": "2023-09-12T12:10:05",
  "measurement": 12.5,
  "measurementType": "TEMPERATURE"
}
```

* POST <code>/api/v1/data/test/send</code>

Example JSON

```JSON
{
  "delayInSeconds": 3,
  "measurementTypes": [
    "POWER",
    "VOLTAGE",
    "TEMPERATURE"
  ]
}
```

