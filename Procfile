web: java $JAVA_OPTS -jar target/*.jar -port $PORT
log: sh /opt/logstash-forwarder/logstash-forwarder -config /etc/logstash-forwarder/logstash-forwarder.json -spool-size 100