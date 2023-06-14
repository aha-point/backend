package com.ahaPoint.member.domain;

import com.ahaPoint.point.domain.Point;
import com.ahaPoint.sysUser.domain.SysUser;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "member", catalog = "aha_point")
@Getter
@DynamicUpdate
@NoArgsConstructor @AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(builderMethodName = "entityBuilder", toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Member {

    @Id
    @Column(name = "MEMBER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // member pk

    @Column(name = "SYS_ID")
    private Long sysId; // sysUser Id (pk)

    @NotBlank
    private String name;

    @Email
    private String email;

    @Size(max = 6)
    private String zipCode;

    private String address;

    private String agreeMarketing; // 이메일 수신 동의

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    /* ============ <연관관계> ============ */
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SYS_ID", insertable = false, updatable = false)
    private SysUser sysUser;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    private List<Point> points;

    public void setSysId(Long id) { // sysUser의 Id 값을 넣어서 save한다.
        this.sysId = id;
    }
}
