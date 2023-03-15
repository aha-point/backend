package com.ahaPoint.sysUser.infrastructure;

import com.ahaPoint.sysUser.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserRepository extends JpaRepository<SysUser, Long> {

}
