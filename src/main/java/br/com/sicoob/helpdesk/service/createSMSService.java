package br.com.sicoob.helpdesk.service;

import okhttp3.*;

import java.io.IOException;

public class createSMSService {

    private static final String BASE_URL = "https://2kwrkp.api.infobip.com";
    private static final String API_KEY = "App 15123e227b0d78fac43bdab4fe7c2334-48b4f727-a364-4e0a-aa72-bfc829cf17f2";
    private static final String MEDIA_TYPE = "application/json";

    private static final String SENDER = "InfoSMS";
//    private static final String RECIPIENT = "5561994452922";
//    private static final String MESSAGE_TEXT = "pra testar se tu vai receber, vou pro almoço quando eu voltar a gente testa kkkk";

    public static Object sendSMS(String recipient, String message) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        String bodyJson = String.format("{\"messages\":[{\"from\":\"%s\",\"destinations\":[{\"to\":\"%s\"}],\"text\":\"%s\"}]}",
                SENDER,
                recipient,
                message
        );

        MediaType mediaType = MediaType.parse(MEDIA_TYPE);
        RequestBody body = RequestBody.create(bodyJson, mediaType);

        Request request = prepareHttpRequest(body);
        Response response = client.newCall(request).execute();

        return response.code();

    }

    private static Request prepareHttpRequest(RequestBody body) {
        return new Request.Builder()
                .url(String.format("%s/sms/2/text/advanced", BASE_URL))
                .method("POST", body)
                .addHeader("Authorization", API_KEY)
                .addHeader("Content-Type", MEDIA_TYPE)
                .addHeader("Accept", MEDIA_TYPE)
                .build();
    }
}
