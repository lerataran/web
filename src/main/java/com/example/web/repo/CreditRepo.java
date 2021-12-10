package com.example.web.repo;

import com.example.web.models.Credit;
import org.springframework.data.repository.CrudRepository;

public interface CreditRepo extends CrudRepository<Credit, Long> {
}
