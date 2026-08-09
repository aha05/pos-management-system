package com.pos.merchant.branch;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("merchant-branch")
@RequiredArgsConstructor
public class MerchantBranchController {
    private final MerchantBranchService merchantBranchService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MerchantBranchResponse> getMerchantBranches() {
        return merchantBranchService.getMerchantBranches();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public MerchantBranchResponse addMerchantBranch(@Valid @RequestBody MerchantBranchRequest request) {
        return merchantBranchService.addMerchantBranch(request);
    }
}
