package com.ahaPoint.sysUser.interfaces;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
public class CheckPhoneNumber {
    private IsDuplicated isDuplicated;

    public static CheckPhoneNumber getIsDuplicated (Boolean value) {
        IsDuplicated result = IsDuplicated.getIsDuplicated(value);
        return CheckPhoneNumber.of(result);
    }
}
