package com.ahaPoint.common.util;


import com.ahaPoint.sysUser.domain.CheckNumber;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.exception.NurigoEmptyResponseException;
import net.nurigo.sdk.message.exception.NurigoMessageNotReceivedException;
import net.nurigo.sdk.message.exception.NurigoUnknownException;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.model.MessageType;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class SendMessageServiceImpl implements SendMessageService {
    private DefaultMessageService messageService;
    public static Integer CODE_NUMBER = 2;
    public static Integer ROUND_NUMBER = 999;

    @Value("${message.api.key}")
    public String API_KEY;

    @Value("${message.api.secret}")
    public String API_SECRET;

    @Value("${message.domain.address}")
    public String DOMAIN_ADDRESS;

    @Override
    public String sendMessage(CheckNumber input) {
        this.messageService = NurigoApp.INSTANCE.initialize(API_KEY, API_SECRET, DOMAIN_ADDRESS);
        String randomCode = generate6RandomCode();

        //HashMap<String, String> params = new HashMap<String, String>();
        Message message = new Message();
        message.setTo(input.getPhoneNumber()); // 수신번호
        message.setFrom("01099735424"); // 발신번호
        message.setType(MessageType.SMS);
        message.setText("[ahaPoint] 인증번호 " + randomCode + " 를 입력하세요.");

        try {
            messageService.send(message);
            log.info("message", message.toString());
            return randomCode;
        }  catch (NurigoMessageNotReceivedException e) {
            throw new RuntimeException(e);
        } catch (NurigoEmptyResponseException e) {
            throw new RuntimeException(e);
        } catch (NurigoUnknownException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 난수를 이용해서 6자리의 난수코드 생성
     */
    public static String generate6RandomCode() {
        String randomCode = "";
        for (int i = 0; i < CODE_NUMBER; i++) {
            int code = generateRandomNumber();
            randomCode += String.valueOf(code);
        }
        return randomCode;
    }

    /**
     * 세 개의 난수 생성
     */
    private static int generateRandomNumber() {
        return new Random().nextInt(ROUND_NUMBER + 1);
    }

}

