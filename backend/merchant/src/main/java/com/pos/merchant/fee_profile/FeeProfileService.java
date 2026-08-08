package com.pos.merchant.fee_profile;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeeProfileService {
    private final FeeProfileRepository feeProfileRepository;
    private final FeeProfileMapper feeProfileMapper;

    public List<FeeProfileResponse> getFeeProfiles() {
        return feeProfileRepository.findAll()
                .stream()
                .map(feeProfileMapper::toDto)
                .toList();
    }

    public FeeProfileResponse addFeeProfile(@Valid FeeProfileRequest request) {
        var merchantCategory = feeProfileRepository.save(feeProfileMapper.toEntity(request));
        return feeProfileMapper.toDto(merchantCategory);
    }
}
