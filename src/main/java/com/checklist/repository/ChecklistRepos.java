package com.checklist.repository;

import com.checklist.domain.Checklist;
import org.springframework.data.repository.CrudRepository;

public interface ChecklistRepos extends CrudRepository<Checklist, Integer> {

}