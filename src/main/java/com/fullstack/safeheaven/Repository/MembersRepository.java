package com.fullstack.safeheaven.Repository;

import com.fullstack.safeheaven.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembersRepository extends JpaRepository<Members, Integer> {

}
