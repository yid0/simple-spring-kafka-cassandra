package com.yidoughi.respository;

import com.yidoughi.domain.Message;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MessageRepository extends CassandraRepository<Message, UUID> {
    Message findOneById (UUID id);
}
