package com.ahaPoint.member.infrastructure;

import com.ahaPoint.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
