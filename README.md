# jhipstergenerator

Sample project to create jhipster entities from a liquibase database dump.

Developed against the sakila database sample from MySQL

$ java -jar -Dapp.input=sakila.changelog.xml -Dapp.output=test jhipstergenerator-0.0.1-SNAPSHOT.jar