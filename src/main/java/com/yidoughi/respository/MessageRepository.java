package com.yidoughi.respository;

import com.yidoughi.domain.Message;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface MessageRepository extends CassandraRepository<Message, String> {
}
