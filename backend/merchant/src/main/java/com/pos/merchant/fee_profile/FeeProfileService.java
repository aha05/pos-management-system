package com.pos.merchant.fee_profile;

import com.pos.merchant.common.ResourceNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeeProfileService {
    private final FeeProfileRepository feeProfileRepository;
    private final FeeProfileMapper feeProfileMapper;

    public FeeProfile findFeeProfileById (Long feeProfileId) {
        return feeProfileRepository.findById(feeProfileId).orElseThrow(
                () -> new ResourceNotFoundException("Fee Profile", "feeProfileId", feeProfileId)
        );
    }

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
