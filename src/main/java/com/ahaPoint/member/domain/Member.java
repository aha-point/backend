package com.ahaPoint.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Entity
@Table(name = "member", catalog = "aha_point")
@Getter
@DynamicUpdate
@NoArgsConstructor @AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(builderMethodName = "entityBuilder", toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Member {

    @Id @Column(name = "sys_id")
    private Long id; // sysUser Id (pk)

    @Max(value = 11)
    private String phoneNumber;

    @NotBlank
    private String password;

    @NotBlank
    private String name;

    @Email
    private String email;

    @Max(value = 5)
    private String zipCode;

    private String address;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


}
