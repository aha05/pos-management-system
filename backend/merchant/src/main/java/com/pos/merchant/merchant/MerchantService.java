package com.pos.merchant.merchant;

import com.pos.merchant.branch.BranchRepository;
import com.pos.merchant.common.ResourceNotFoundException;
import com.pos.merchant.event.MerchantCreatedEvent;
import com.pos.merchant.settlement_account_reference.SettlementAccountService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantService {
    private final MerchantRepository merchantRepository;
    private final BranchRepository branchRepository;
    private final MerchantMapper merchantMapper;
    private final SettlementAccountService settlementAccountService;

    private static final Logger log = LoggerFactory.getLogger(MerchantService.class);
    private final StreamBridge streamBridge;


    public Merchant findMerchantById(Long merchantId){
        return merchantRepository.findById(merchantId).orElseThrow(
                () -> new ResourceNotFoundException("Merchant", "merchantId", merchantId)
        );
    }

    public MerchantResponse getMerchantById(Long merchantId){
       var merchant =  merchantRepository.findById(merchantId).orElseThrow(
                () -> new ResourceNotFoundException("Merchant", "merchantId", merchantId)
        );
        return merchantMapper.toDto(merchant);
    }

    public List<MerchantResponse> getMerchants() {
        return merchantRepository.findAll()
                .stream()
                .map(merchantMapper::toDto)
                .toList();
    }

    public MerchantResponse addMerchant(MerchantRequest request) {
        var merchant = merchantRepository.save(merchantMapper
                .toEntity(request));
        sendCommunication(merchant);
        return merchantMapper.toDto(merchant);

    }

    public List<MerchantInformation> getMerchantInfo() {
        return merchantRepository.findAll()
                .stream()
                .map(merchant -> {
                    var settlementAccount = settlementAccountService
                            .findSettlementAccountByMerchantId(merchant.getId());

                    String settlementAccountNumber = settlementAccount != null
                            ? settlementAccount.getAccountNumber()
                            : null;

                    long branches = branchRepository.findAllByMerchantId(merchant.getId()).size();

                    return merchantMapper.toMerchantInfo(
                            merchant,
                            settlementAccountNumber,
                            branches
                    );
                })
                .toList();
    }

    public MerchantInformation getMerchantInfoById (Long merchantId) {
       var merchant = merchantRepository.findById(merchantId).orElseThrow(
                () -> new ResourceNotFoundException("Merchant", "merchantId", merchantId)
        );

        var settlementAccount = settlementAccountService
                .findSettlementAccountByMerchantId(merchantId);

        String settlementAccountNumber = settlementAccount != null
                ? settlementAccount.getAccountNumber()
                : null;

        long branches = branchRepository.findAllByMerchantId(merchantId).size();

        return merchantMapper.toMerchantInfo(merchant, settlementAccountNumber, branches);
    }

    private void sendCommunication(Merchant merchant) {
        var merchantCreatedEvent = new MerchantCreatedEvent(
                merchant.getId(),
                merchant.getMerchantCode(),
                merchant.getTradeName(),
                merchant.getStatus().toString()
        );
        log.info("Sending Communication request for the details: {}", merchantCreatedEvent);
        var result = streamBridge.send("merchantCreated-out-0", merchantCreatedEvent);
        log.info("Is the Communication request successfully triggered ? : {}", result);
    }

}