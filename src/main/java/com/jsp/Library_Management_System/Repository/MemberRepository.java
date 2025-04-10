package com.jsp.Library_Management_System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.Library_Management_System.Entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

}
