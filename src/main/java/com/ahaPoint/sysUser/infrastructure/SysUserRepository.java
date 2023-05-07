package com.ahaPoint.sysUser.infrastructure;

import com.ahaPoint.sysUser.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SysUserRepository extends JpaRepository<SysUser, Long> {

    Optional<SysUser> findByPhoneNumber(String phoneNumber);

    Optional<SysUser> findByPhoneNumberAndPassword(String phoneNumber, String password);
}
