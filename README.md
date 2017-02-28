To run:

1. Run it the "direct" way, where it works.

        mvn compile exec:java -Dexec.mainClass=org.apache.demo.module_with_properties.ReadProperties -pl module_with_properties

  This should work, and print `{key=value}`.

1. Run it after shading, where it will fail.

        mvn clean package
        java -cp shading/target/shading-1.0-SNAPSHOT.jar org.apache.demo.module_with_properties.ReadProperties

  This should fail with an error that it can't find a repackaged properties file: `Exception in thread "main" java.lang.RuntimeException: /org/apache/demo/shading/repackaged/org/apache/demo/module_with_properties/some.properties`

1. Look at the actual shaded jar.

        jar tf shading/target/shading-1.0-SNAPSHOT.jar | grep -i properties

  You will see that the files themselves were not moved.

  If you look around more, you will see that Avro was shaded. (It's just there as a sanity check.)
