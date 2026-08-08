package com.pos.merchant.fee_profile;

import com.pos.merchant.category.MerchantCategoryRequest;
import com.pos.merchant.category.MerchantCategoryResponse;
import com.pos.merchant.category.MerchantCategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fee-profile")
@RequiredArgsConstructor
public class FeeProfileController {
    private final FeeProfileService feeProfileService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<FeeProfileResponse> getFeeProfiles() {
        return feeProfileService.getFeeProfiles();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public FeeProfileResponse addFeeProfile(@Valid @RequestBody FeeProfileRequest request) {
        return feeProfileService.addFeeProfile(request);
    }
}
