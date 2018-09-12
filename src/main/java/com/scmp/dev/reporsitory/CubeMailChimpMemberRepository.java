package com.scmp.dev.reporsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scmp.dev.entity.CubeMailChimpMember;

public interface CubeMailChimpMemberRepository extends JpaRepository<CubeMailChimpMember, String> {

	
}