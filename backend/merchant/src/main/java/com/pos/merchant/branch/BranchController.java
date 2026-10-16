package com.pos.merchant.branch;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("merchant/branch")
@RequiredArgsConstructor
public class BranchController {
    private final BranchService branchService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BranchResponse> getBranches() {
        return branchService.getBranches();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BranchResponse getBranchById(@PathVariable(name="id") Long branchId) {
        return branchService.getBranchById(branchId);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public BranchResponse addBranch(@Valid @RequestBody BranchRequest request) {
        return branchService.addBranch(request);
    }
}
