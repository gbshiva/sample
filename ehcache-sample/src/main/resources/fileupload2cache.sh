TC_HOME=/home/gecloud/bigmemory-max-4.1.4
TC_LICENSE_KEY=$TC_HOME/terracotta-license.key
#PERF_CLASSPATH=$(echo ${TC_HOME}/apis/ehcache/lib/*.jar | tr ' ' ':')
#PERF_CLASSPATH=${PERF_CLASSPATH}:$(echo ${TC_HOME}/apis/toolkit/lib/*.jar | tr ' ' ':')
PERF_CLASSPATH=.:/home/gecloud/ehcache-sample/target/ehcache-sample-1.0-SNAPSHOT.jar

java -Dcom.sn.management.jmxremote="true" -Dcom.sun.management.jmxremote.authenticate="false" -Dcom.sun.management.jmxremote.ssl="false" -Dcom.sun.management.jmxremote.port=9900 -XX:+UseLargePages -d64 -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -verbose:gc -Xms2g -Xmx2g -XX:MaxDirectMemorySize=100M -Dcom.tc.productkey.path=${TC_LICENSE_KEY} -cp ${PERF_CLASSPATH} com.terracotta.sample.FileUpload2Cache data.csv
