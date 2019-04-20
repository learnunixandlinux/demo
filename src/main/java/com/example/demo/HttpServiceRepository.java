package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HttpServiceRepository extends CrudRepository<HttpTraffic, String> {
    HttpTraffic findByTransactionId(String transactionId);
}
