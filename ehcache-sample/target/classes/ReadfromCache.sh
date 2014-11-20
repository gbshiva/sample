TC_HOME=/home/gecloud/bigmemory-max-4.1.4
TC_LICENSE_KEY=$TC_HOME/terracotta-license.key
#PERF_CLASSPATH=$(echo ${TC_HOME}/apis/ehcache/lib/*.jar | tr ' ' ':')
#PERF_CLASSPATH=${PERF_CLASSPATH}:$(echo ${TC_HOME}/apis/toolkit/lib/*.jar | tr ' ' ':')
PERF_CLASSPATH=.:/home/gecloud/sample/ehcache-sample/target/ehcache-sample-1.0-SNAPSHOT.jar

java  -XX:+UseLargePages -d64 -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -verbose:gc -Xms2g -Xmx2g  -Dcom.tc.productkey.path=${TC_LICENSE_KEY} -cp ${PERF_CLASSPATH} com.terracotta.sample.ReadfromCache
