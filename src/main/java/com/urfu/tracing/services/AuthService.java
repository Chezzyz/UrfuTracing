package com.urfu.tracing.services;

import com.urfu.tracing.model.tracing.entity.OrderEntity;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final ContractorService contractorService;

    @Value("${auth.last-digits.count}")
    private int countOfLastDigitsForAuth;

    public boolean isAuthorized(@NonNull OrderEntity orderEntity, String phoneNumberDigits){
        String senderPhone = contractorService.findContractorPhoneNumber(orderEntity.getSenderUuid());
        String receiverPhone = contractorService.findContractorPhoneNumber(orderEntity.getReceiverUuid());

        return getLastDigitsOfNumber(senderPhone, countOfLastDigitsForAuth).equals(phoneNumberDigits)
                || getLastDigitsOfNumber(receiverPhone, countOfLastDigitsForAuth).equals(phoneNumberDigits);
    }

    private String getLastDigitsOfNumber(String str, int digitsCount){
        return str.substring(Math.max(str.length() - digitsCount - 1, 0));
    }
}
