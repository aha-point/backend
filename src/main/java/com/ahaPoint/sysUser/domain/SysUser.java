package com.ahaPoint.sysUser.domain;

import com.ahaPoint.member.domain.Member;
import com.ahaPoint.store.domain.Store;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.validation.constraints.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "sys_user", catalog = "aha_point")
@Getter
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(builderMethodName = "entityBuilder", toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class SysUser {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id; // pk

    @NotBlank
    private String phoneNumber; // 아이디이자 핸드폰 번호

    @NotBlank
    private String password; // 비밀번호

    private String type; // Member, Store

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


    /* ============ <연관관계> ============ */
    @OneToOne(fetch = FetchType.LAZY, optional = false, mappedBy = "sysUser")
    private Store store;

    @OneToOne(fetch = FetchType.LAZY, optional = false, mappedBy = "sysUser")
    private Member member;
}
