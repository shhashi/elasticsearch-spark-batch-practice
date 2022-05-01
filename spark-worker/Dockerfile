FROM openjdk:11-jdk

RUN apt-get update -o Acquire::Check-Valid-Until=false -o Acquire::Check-Date=false -y \
    && wget https://downloads.lightbend.com/scala/2.12.2/scala-2.12.2.deb \
    && apt-get install ./scala-2.12.2.deb -y
RUN cd /opt \
    && wget https://archive.apache.org/dist/spark/spark-3.2.1/spark-3.2.1-bin-hadoop3.2.tgz \
    && tar -xvzf spark-3.2.1-bin-hadoop3.2.tgz
RUN wget https://repo1.maven.org/maven2/org/elasticsearch/elasticsearch-spark-30_2.12/8.1.2/elasticsearch-spark-30_2.12-8.1.2.jar \
    && cp elasticsearch-spark-30_2.12-8.1.2.jar /opt/spark-3.2.1-bin-hadoop3.2/jars/

CMD bash /opt/spark-3.2.1-bin-hadoop3.2/sbin/start-slave.sh spark://es-spark:7077 -c 1 -m 1G --host spark-worker && /bin/bash
