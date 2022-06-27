# Getting Started

### Requirements

At least Java Development Environment version 11 is required to run this application.

### Source

List of business locations are written at `src/main/resources/data.csv`.
Update that file to add or remove business locations.

### Run

You can run the application with
```sh
./gradlew bootRun
```

command. Alternatively it is possible to generate `jar` artifact with
```
./gradlew jar
```
and run with as
```sh
java -jar build/libs/db.jar
```

### Manual API call

When in development you can call the endpoint (assuming the local port is 8080) with
```sh
curl localhost:8080/office/aamp
```

### Limitations

Currently, the CSV file is included in the final package. In the future it would be better if it can be externalized.