package com.example.web.repo;

import com.example.web.models.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepo extends CrudRepository<Client, Long> {

}
