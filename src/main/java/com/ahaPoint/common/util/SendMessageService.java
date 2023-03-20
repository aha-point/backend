package com.ahaPoint.common.util;

import com.ahaPoint.member.interfaces.mapper.check_random_code.CheckRandomCodeInput;
import com.ahaPoint.sysUser.domain.CheckNumber;

public interface SendMessageService {

    String sendMessage(CheckNumber input);
}
