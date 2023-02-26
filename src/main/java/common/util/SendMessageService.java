package common.util;


import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

@Service
public class SendMessageService {
    public static Integer CODE_NUMBER = 5;
    public static Integer ROUND_NUMBER = 999;

    /**
     * MMS 발송 예제
     * 단일 발송, 여러 건 발송 상관없이 이용 가능
     */
//    @PostMapping("/send-mms")
//    public String sendSmsForSignUp() throws IOException {
//        ClassPathResource resource = new ClassPathResource("static/sample.jpg");
//        File file = resource.getFile();
//        String imageId = this.messageService.uploadFile(file, StorageType.MMS, null);
//
//        Message message = new Message() {
//            @Override
//            public String getFormattedMessage() {
//                return null;
//            }
//
//            @Override
//            public String getFormat() {
//                return null;
//            }
//
//            @Override
//            public Object[] getParameters() {
//                return new Object[0];
//            }
//
//            @Override
//            public Throwable getThrowable() {
//                return null;
//            }
//        };
//        // 발신번호 및 수신번호는 반드시 01012345678 형태로 입력되어야 합니다.
//        message.setFrom("발신번호 입력");
//        message.setTo("수신번호 입력");
//        message.setText("한글 45자, 영자 90자 이하 입력되면 자동으로 SMS타입의 메시지가 추가됩니다.");
//        message.setImageId(imageId);
//
//        // 여러 건 메시지 발송일 경우 send many 예제와 동일하게 구성하여 발송할 수 있습니다.
//        SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(message));
//        System.out.println(response);
//
//        return response;
//    }

    String api_key = "본인의 API KEY";
    String api_secret = "본인의 API SECRET";
    Message coolsms = new Message(api_key, api_secret) {
        @Override
        public Object getPayload() {
            return null;
        }

        @Override
        public MessageHeaders getHeaders() {
            return null;
        }
    };

    // 4 params(to, from, type, text) are mandatory. must be filled
    HashMap<String, String> params = new HashMap<String, String>();

        params.put("to", phoneNumber);    // 수신전화번호
        params.put("from", "발송할 번호 입력");    // 발신전화번호. 테스트시에는 발신,수신 둘다 본인 번호로 하면 됨
        params.put("type", "SMS");
        params.put("text", "핫띵크 휴대폰인증 테스트 메시지 : 인증번호는" + "["+cerNum+"]" + "입니다.");
        params.put("app_version", "test app 1.2"); // application name and version

        try {
        JSONObject obj = (JSONObject) coolsms.send(params);
        System.out.println(obj.toString());
    } catch (CoolsmsException e) {
        System.out.println(e.getMessage());
        System.out.println(e.getCode());
    }


    /**
     * 난수를 이용해서 5자리의 난수코드 생성
     */
    public static String generate5RandomCode() {
        String randomCode = "";
        for (int i = 0; i < CODE_NUMBER; i++) {
            int code = generateRandomNumber();
            randomCode += String.valueOf(code);
        }
        return randomCode;
    }

    /**
     * 한 개의 난수 생성
     */
    private static int generateRandomNumber() {
        return new Random().nextInt(ROUND_NUMBER + 1);
    }

}

