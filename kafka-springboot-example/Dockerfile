FROM confluentinc/cp-kafka:latest

COPY create-topics.sh /usr/local/bin/create-topics.sh
RUN chmod +x /usr/local/bin/create-topics.sh

CMD ["bash", "-c", "/usr/local/bin/create-topics.sh && /etc/confluent/docker/run"]