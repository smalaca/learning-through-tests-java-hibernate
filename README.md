learning-through-tests-java-hibernate
=====================================

Tests which shows how hibernate ORM works.

Requirements:
1) JDK 7
2) MySQL

Steps to run test:
1) go to ltt.java.hibernate directory
2) execute: mvn compile
3) create travis user with rights which allows for db creation
4) execute: mysql -utravis < src/main/resources/database/schema_creation.sql
5) for each required package execute: mysql -utravis < src/main/resources/database/[package_name].sql
6) start db connector: 
mvn exec:java -Dexec.mainClass="org.hsqldb.Server" -Dexec.args="-database.0 file:target/data/learning_through_test"